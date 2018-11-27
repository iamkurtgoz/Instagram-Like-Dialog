# Instagram Like Dialog
### Use Instagram-like dialog.
[![](https://jitpack.io/v/iamkurtgoz/Instagram-Like-Dialog.svg)](https://jitpack.io/#iamkurtgoz/Instagram-Like-Dialog)

## What Works

##### You can see the same dialog on instagram. We have achieved a similar result by presenting the same image.

### How to Import
##### Step 1. Add the JitPack repository to your build file
```java
allprojects {
repositories {
maven { url 'https://jitpack.io' }
}
}
```

##### Step 2. Add the dependency
```java
dependencies {
implementation 'com.github.iamkurtgoz:Instagram-Like-Dialog:1.0.5'
}
```

### How to Use Android List Dialog
```java
DModel[] customData = new DModel[]{
new DModel(getString(R.string.follow), R.drawable.instagram_icon),
new DModel(getString(R.string.get_profile), R.drawable.instagram_icon_2),
new DModel(getString(R.string.block), R.drawable.instagram_icon_3)
};

InstaDialog.with(MainActivity.this)
.androidList(MainActivity.this, customData)
.setDialogClickCallBack(new BuilderListAndroid.DialogClickCallBack() {
@Override
public void onDialogClickListener(DModel model, int position) {
Toast.makeText(MainActivity.this, "Text : " + model.getTitle() + ", position : " + position, Toast.LENGTH_SHORT).show();
}
})
.setTextSize(15)
.setTextGravity(Gravity.START)
.setCancelable(true)
.setItemIconActive(false)
.show();
```
### How to Use Android Dialog
```java
InstaDialog.with(MainActivity.this)
.androidDialog("Fikrini değiştirirsen, @iamkurtgoz'e tekrar takip isteği göndermen gerekecek.", "İptal", "Kabul")
.setProfileIconUrl("https://instagram.fist4-1.fna.fbcdn.net/vp/807d164c60a4e48041b9a095c5da5df7/5C691F53/t51.2885-19/s640x640/20838301_1915234258688325_4142410044761178112_n.jpg")
.setDialogClickCallBack(new BuilderDialogAndroid.DialogClickCallBack() {
@Override
public void onDialogCancelClickListener() {
Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
}

@Override
public void onDialogConfirmClickListner() {
Toast.makeText(MainActivity.this, "Confirm", Toast.LENGTH_SHORT).show();
}
}).show();
```
### How to Use Android Progress Dialog
```java
//.setLottieRaw(R.raw.settings_loading) default settings_loading.json
//lottie files url : https://www.lottiefiles.com/
InstaDialog.with(MainActivity.this)
                .progressDialog()
                .setTitle("Wait")
                .setTextColor(Color.BLACK)
                .build().show();
```

### Features

Function  | Description
------------- | -------------
setDialogClickCallBack  | The interface used to retrieve the selected item result.
setDialogCancelable | Sets whether the dialog can be turned off. Default true.
setTextTitle | Changes the title. If you define a title the title appears, and if you do not define the title the title will not appear.
setTextColor | Title color. Default black.
setTextSize | Title text size. Default 14sp.


### How to Result Android List Dialog
![](https://github.com/iamkurtgoz/Instagram-Like-Dialog/raw/master/ss/ss_android_list.png)

### How to Result Android Dialog
![](https://github.com/iamkurtgoz/Instagram-Like-Dialog/raw/master/ss/ss_android_dialog.png)




### Contacts : kurtgozmehmet159@gmail.com
