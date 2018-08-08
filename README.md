# Andrutil

[ ![Download](https://api.bintray.com/packages/shabankamel/android/andrutil/images/download.svg) ](https://bintray.com/shabankamel/android/andrutil/_latestVersion)

##### Useful Android Utilities.

# Installation

```gradle
repositories {
    maven {
        url  "https://dl.bintray.com/shabankamel/android" 
    }
}

dependencies {
    implementation 'com.sha.kamel:andrutil:0.15.2@aar'
}
```

# Usage:

```java
 // You must initialize library in Application class:
public final class MyApp extends Application{
 @Override
    public void onCreate() {
        super.onCreate();
    Andrutil.instance().applicationContext = this;
}
}
```

# Available Utils:
```
ActivityUtil
AppUtil
BackStackUtil
BottomNavigationViewUtil
Callback
DateUtil
DiskStorageUtil
FragmentManagerUtil
Func
GsonUtil
HtmlUtil
KeyboardUtil
KeyguardManagerUtil
LocaleUtil
MediaPlayerUtil
ObservableUtil
PackageInfoUtil
PhoneUtil
RecyclerViewUtil
RtlConfigUtil
ServiceUtil
SpaceItemDecoration
SystemOverlayUtil
ToastUtil
WindowUtil
VectorDrawableUtil
DrawableUtil
```
# License

## Apache license 2.0
