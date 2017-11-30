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
    compile 'com.sha.kamel:andrutil:0.2.1@aar'
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
DrawableUtil
VectorDrawableUtil
ActivityUtil
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
ObservableUtil
PhoneUtil
RecyclerViewUtil
RtlConfigUtil
SystemOverlayUtil
WindowUtil
```
# License

## Apache license 2.0
