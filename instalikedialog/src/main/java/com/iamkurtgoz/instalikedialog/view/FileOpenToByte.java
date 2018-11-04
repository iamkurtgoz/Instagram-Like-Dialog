package com.iamkurtgoz.instalikedialog.view;

import android.content.Context;
import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileOpenToByte extends AsyncTask<byte[],Integer,byte[]>{

    public interface FileOpenByteListener{
        void onStart();
        void onRemaining();
        void onProgress(int percent);
        void onFinish(byte[] bytes);
    }

    private static final int BUFFER_SIZE = 4096;
    private FileOpenByteListener fileOpenByteListener;
    private Context context;
    private String urlString;

    public FileOpenToByte(String urlString , Context context){
        this.context = context;
        this.urlString = urlString;
    }

    public FileOpenToByte(){
    }

    public FileOpenToByte setParameters(String urlString , Context context){
        this.context = context;
        this.urlString = urlString;
        return this;
    }

    public FileOpenToByte setFileOpenListener(FileOpenByteListener fileOpenListener){
        this.fileOpenByteListener = fileOpenListener;
        return this;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (fileOpenByteListener != null){
            fileOpenByteListener.onStart();
        }
    }

    @Override
    protected byte[] doInBackground(byte[]... params) {
        try {
            if (fileOpenByteListener != null){
                fileOpenByteListener.onRemaining();
            }

            URL url = new URL(urlString);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            int responseCode = httpConn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                int contentLength = httpConn.getContentLength();
                InputStream inputStream = httpConn.getInputStream();
                ByteArrayOutputStream buffer = new ByteArrayOutputStream(contentLength);

                int bytesRead = -1, totalBytesRead = -1;
                byte[] data = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(data)) != -1) {
                    if (isCancelled()) {
                        break;
                    }
                    buffer.write(data, 0, bytesRead);
                    totalBytesRead += bytesRead;
                    int progress = (int) (totalBytesRead * (100 / (double) contentLength));
                    publishProgress(progress);
                }
                buffer.close();
                inputStream.close();
                httpConn.disconnect();
                return buffer.toByteArray();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex){
            ex.printStackTrace();
        }
        return null;
    }

    int oldprogress = -1;
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        if (values[0] > oldprogress){
            oldprogress = values[0];
            if (fileOpenByteListener != null){
                fileOpenByteListener.onProgress(oldprogress);
            }
        }
    }

    @Override
    protected void onPostExecute(byte[] bytes) {
        super.onPostExecute(bytes);
        if (fileOpenByteListener != null){
            if (isCancelled()){
                fileOpenByteListener.onFinish(null);
            } else {
                fileOpenByteListener.onFinish(bytes);
            }
        }
    }

    public byte[] toByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int l;
        byte[] data = new byte[BUFFER_SIZE];
        while ((l = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, l);
        }
        buffer.flush();
        return buffer.toByteArray();
    }

}
