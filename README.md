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
2. You can downlad \*.JAR-file ([Downlad URL](https://github.com/nikitoSha/Android-Easy-AlertDialog/raw/master/libs/EasyAlertDialog_1.0.1.jar)), copy downladed lib into project's dir "libs" and in **build.gradle**:
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

## How to use
### Create simple standart AlertDialog with Activity's context (deprecated).
You need to set buttons and show dialog after function's return.
```java
EADialogManager eaDialogManager = new EADialogManager(YourActivityContext|YourAppContext);
AlertDialog alertDialog = eaDialogManager.createStandartDialog(
                        YourActivityContext, false,
                        "Standart dialog without automatic callbacks", null);
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,
                        "Accept",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Toast.makeText(YourActivityContext,
                                        "onClick: positive button",
                                        Toast.LENGTH_LONG).show();
                            }
                        });

                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Toast.makeText(YourActivityContext,
                                        "onClick: negative button",
                                        Toast.LENGTH_LONG).show();
                            }
                        });
                alertDialog.show();
```
### Show easy AlertDialog with Activity's context and positive button's callback.
```java
EADialogManager eaDialogManager = new EADialogManager(YourActivityContext|YourAppContext);
eaDialogManager.showEADialogWithOneButton(
        YourActivityContext, true, false,
        "Easy dialog with automatic callbacks", "My title",
        "OK", new EADialogManager.EADialogOneButtonClickListener() {
            @Override
            public void onButtonClick(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                Toast.makeText(YourActivityContext,
                        "onClick: positive button",
                        Toast.LENGTH_LONG).show();
            }
        }
);
```
### Show easy AlertDialog with Activity's context, positive and negative button's callback
```java
EADialogManager eaDialogManager = new EADialogManager(YourActivityContext|YourAppContext);
eaDialogManager.showEADialogWithTwoButtons(
        YourActivityContext, false, true,
        "Easy dialog with automatic callbacks (2)", null,
        "True", "False",
        new EADialogManager.EADialogTwoButtonsClickListener() {
            @Override
            public void onPositiveButtonClick(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                Toast.makeText(YourActivityContext,
                        "onClick: positive button",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNegativeButtonClick(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                Toast.makeText(YourActivityContext,
                        "onClick: negative button",
                        Toast.LENGTH_LONG).show();
            }
        }
);
```

### Show easy AlertDialog with Activity's context and positive, negative and neutral button's callback
```java
EADialogManager eaDialogManager = new EADialogManager(YourActivityContext|YourAppContext);
eaDialogManager.showEADialogWithThreeButtons(
        YourActivityContext, false, false,
        "Easy dialog with automatic callbacks (3)", null,
        "Okay", "No!", "What?",
        new EADialogManager.EADialogThreeButtonsClickListener() {
            @Override
            public void onPositiveButtonClick(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                Toast.makeText(YourActivityContext,
                        "onClick: positive button",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNegativeButtonClick(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                Toast.makeText(YourActivityContext,
                        "onClick: negative button",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNeutralButtonClick(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                Toast.makeText(YourActivityContext,
                        "onClick: neutral button",
                        Toast.LENGTH_LONG).show();
            }
        }
);
```

### Show easy AlertDialog with ANY context (Application|Base|Activity).
You can show this dialog from background (service), for example. Just create Activity for dialog and send its full name to this function.
1. Create new Activity class for your dialog (see sample).
2. In AndroidManifest.xml add new custom Activity:
```XML
<!--Activity for AlertDialog -->
<activity android:name="ru.rsit.easyalertdialogsample.DialogActivity"
    android:theme="@android:style/Theme.Dialog"/>
```
3. Init EasyAlertDialog and show your custom ActivityDialog:
```java
EADialogManager eaDialogManager = new EADialogManager(YourAppContext);
eaDialogManager.showEAActivityDialog(
    "ru.rsit.easyalertdialogsample.DialogActivity");
```
For more details see [Example](https://github.com/nikitoSha/Android-Easy-AlertDialog/tree/master/sample).


# MIT License

## Copyright (c) 2018 Nikita (nikitoSha (https://github.com/nikitoSha))

        Permission is hereby granted, free of charge, to any person obtaining a copy
        of this software and associated documentation files (the "Software"), to deal
        in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
        copies of the Software, and to permit persons to whom the Software is
        furnished to do so, subject to the following conditions:

        The above copyright notice and this permission notice shall be included in all
        copies or substantial portions of the Software.

        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
        SOFTWARE.
