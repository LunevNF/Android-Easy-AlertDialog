# Android-Easy-AlertDialog
Library that helps a few lines of code to show AlertDialog with button's onClick callbacks, or to show custom AlertDialog from service, for example.

## Installation
1. In **build.gradle**:
```gradle
allprojects {
    repositories {
        jcenter()
    }
}
dependencies {
    compile 'com.github.nikitosha:easyalertdialog:1.0.1'
}
```
2. You can downlad \*.JAR-file ([Downlad URL](https://github.com/nikitoSha/Android-Easy-AlertDialog/blob/master/libs/EasyAlertDialog_1.0.1.jar)), copy downladed lib into project's dir "libs" and in **build.gradle**:
```gradle
allprojects {
    repositories {
        jcenter()
    }
}
dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    compile files('libs/EasyAlertDialog_1.0.1.jar')    
}
```
That's all.

# How to use
