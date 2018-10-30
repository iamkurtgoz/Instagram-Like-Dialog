# Instagram Like Dialog
### Use Instagram-like dialog.

##What Works

#####You can see the same dialog on instagram. We have achieved a similar result by presenting the same image.

###How to Import
#####Step 1. Add the JitPack repository to your build file
```java
allprojects {
   repositories {
      maven { url 'https://jitpack.io' }
   }
}
```

#####Step 2. Add the dependency
```java
dependencies {
   implementation 'com.github.iamkurtgoz:Instagram-Like-Dialog:1.0.1'
}
```

###How to Use
```java
ArrayList<CustomInstagramLikeDialogModel> arrayList = new ArrayList<>();
        arrayList.add(new CustomInstagramLikeDialogModel(
                getString(R.string.follow),
                MainActivity.this
        )); //default value, color = black, special id = -1

        arrayList.add(new CustomInstagramLikeDialogModel(
                getString(R.string.get_profile),
                1,
                getResources().getColor(R.color.blue)
        )); //color = blue, special id = 1

        arrayList.add(new CustomInstagramLikeDialogModel(
                getString(R.string.block),
                123,
                getResources().getColor(R.color.brand_red)
        )); //color red, special id = 123

        //new InstaDialog(MainActivity.this, arrayList).setDialogClickCallBack(this).show();
        //or
        new InstaDialog(MainActivity.this, arrayList, this)
                .setDialogCancelable(true).show();
```
###Features

Function  | Description
------------- | -------------
setDialogClickCallBack  | The interface used to retrieve the selected item result.
setDialogCancelable | Sets whether the dialog can be turned off. Default true.
setTextTitle | Changes the title. If you define a title the title appears, and if you do not define the title the title will not appear.
setTextColor | Title color. Default black.
setTextSize | Title text size. Default 14sp.


###How to Result
![](https://github.com/iamkurtgoz/Instagram-Like-Dialog/raw/master/ss/ss_device.png)





###Contacts : kurtgozmehmet159@gmail.com
