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

# License

## Apache license 2.0
