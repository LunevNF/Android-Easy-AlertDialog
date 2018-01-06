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
