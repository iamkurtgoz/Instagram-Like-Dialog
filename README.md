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
   implementation 'com.github.iamkurtgoz:Instagram-Like-Dialog:1.0.3'
}
```

### How to Use
```java
    DModel[] customData = new DModel[]{
    new DModel(getString(R.string.follow), R.drawable.instagram_icon),
    new DModel(getString(R.string.get_profile), R.drawable.instagram_icon_2),
    new DModel(getString(R.string.block), R.drawable.instagram_icon_3)
    };

    InstaDialog.with(MainActivity.this)
    .init(customData, this)
    .setTitle("Instagram Dialog")
    .setTextSize(15)
    .setTextGravity(Gravity.START)
    .setCancelable(true)
    .setItemIconActive(true)
    .show();
```
### Features

Function  | Description
------------- | -------------
setDialogClickCallBack  | The interface used to retrieve the selected item result.
setDialogCancelable | Sets whether the dialog can be turned off. Default true.
setTextTitle | Changes the title. If you define a title the title appears, and if you do not define the title the title will not appear.
setTextColor | Title color. Default black.
setTextSize | Title text size. Default 14sp.


### How to Result
![](https://github.com/iamkurtgoz/Instagram-Like-Dialog/raw/master/ss/ss_device.png)





### Contacts : kurtgozmehmet159@gmail.com
