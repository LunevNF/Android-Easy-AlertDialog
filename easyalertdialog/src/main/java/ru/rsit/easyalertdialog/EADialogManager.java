package ru.rsit.easyalertdialog;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;


/**
 * Easy AlertDialog Manager
 * @author nikitoSha (https://github.com/nikitoSha)
 */
public class EADialogManager {

    /** context (Application|Base|Activity) */
    Context appContext;

    public EADialogManager(Context thisAppContext){
        appContext = thisAppContext;
    }

    /**
     * EADialog OnClick listener for one positive button
     */
    public interface EADialogOneButtonClickListener {
        public void onButtonClick(DialogInterface dialogInterface);
    }
    /**
     * EADialog OnClick listener for positive and negative buttons
     */
    public interface EADialogTwoButtonsClickListener {
        public void onPositiveButtonClick(DialogInterface dialogInterface);
        public void onNegativeButtonClick(DialogInterface dialogInterface);
    }
    /**
     * EADialog OnClick listener for positive, negative and neutral buttons
     */
    public interface EADialogThreeButtonsClickListener {
        public void onPositiveButtonClick(DialogInterface dialogInterface);
        public void onNegativeButtonClick(DialogInterface dialogInterface);
        public void onNeutralButtonClick(DialogInterface dialogInterface);
    }

    /**
     * Create simple standart AlertDialog with Activity's context. You need to set buttons and show dialog after return.
     * @param parentContext context of parent Activity
     * @param withTitle with or without title?
     * @param messageText text of message
     * @param title title, if enabled
     * @return object of AlertDialog (v.7)
     */
    @Deprecated
    public AlertDialog createStandartDialog(
            Context parentContext, Boolean withTitle, String messageText, @Nullable String title){
        AlertDialog alertDialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(parentContext);
        if ((withTitle) && (title != null)) {
            builder.setTitle(title);
        }
        builder.setMessage(messageText);

        alertDialog = builder.create();
        alertDialog.setCancelable(false);
        return alertDialog;
    }

    /**
     * Show easy AlertDialog with Activity's context and positive button's callback
     * @param parentContext context of parent Activity
     * @param withTitle with or without title?
     * @param cancelable can close alert by backpress?
     * @param messageText text of message
     * @param title title, if enabled
     * @param buttonText name for button
     * @param buttonClickListener onClick listener
     * @return object of AlertDialog (v.7)
     */
    public AlertDialog showEADialogWithOneButton(
            Context parentContext, Boolean withTitle, Boolean cancelable,
            String messageText, @Nullable String title,
            String buttonText,
            final EADialogOneButtonClickListener buttonClickListener){

        AlertDialog alertDialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(parentContext);
        if ((withTitle) && (title != null)) {
            builder.setTitle(title);
        }
        builder.setMessage(messageText);

        builder.setPositiveButton(buttonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                buttonClickListener.onButtonClick(dialog);
            }
        });

        alertDialog = builder.create();
        alertDialog.setCancelable(cancelable);
        alertDialog.show();
        return alertDialog;
    }

    /**
     * Show easy AlertDialog with Activity's context and positive and negative button's callback
     * @param parentContext context of parent Activity
     * @param withTitle with or without title?
     * @param cancelable can close alert by backpress?
     * @param messageText text of message
     * @param title title, if enabled
     * @param positiveButtonText name for positive button
     * @param negativeButtonText name for negative button
     * @param buttonsClickListener onClick listener
     * @return object of AlertDialog (v.7)
     */
    public AlertDialog showEADialogWithTwoButtons(
            Context parentContext, Boolean withTitle, Boolean cancelable,
            String messageText, @Nullable String title,
            String positiveButtonText, String negativeButtonText,
            final EADialogTwoButtonsClickListener buttonsClickListener){

        AlertDialog alertDialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(parentContext);
        if ((withTitle) && (title != null)) {
            builder.setTitle(title);
        }
        builder.setMessage(messageText);

        builder.setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                buttonsClickListener.onPositiveButtonClick(dialog);
            }
        });

        builder.setNegativeButton(negativeButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                buttonsClickListener.onNegativeButtonClick(dialog);
            }
        });

        alertDialog = builder.create();
        alertDialog.setCancelable(cancelable);
        alertDialog.show();
        return alertDialog;
    }

    /**
     * Show easy AlertDialog with Activity's context and positive, negative and neutral button's callback
     * @param parentContext context of parent Activity
     * @param withTitle with or without title?
     * @param cancelable can close alert by backpress?
     * @param messageText text of message
     * @param title title, if enabled
     * @param positiveButtonText name for positive button
     * @param negativeButtonText name for negative button
     * @param neutralButtonText name for neutral button
     * @param buttonsClickListener onClick listener
     * @return object of AlertDialog (v.7)
     */
    public AlertDialog showEADialogWithThreeButtons(
            Context parentContext, Boolean withTitle, Boolean cancelable,
            String messageText, @Nullable String title,
            String positiveButtonText, String negativeButtonText, String neutralButtonText,
            final EADialogThreeButtonsClickListener buttonsClickListener){

        AlertDialog alertDialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(parentContext);
        if ((withTitle) && (title != null)) {
            builder.setTitle(title);
        }
        builder.setMessage(messageText);

        builder.setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                buttonsClickListener.onPositiveButtonClick(dialog);
            }
        });

        builder.setNegativeButton(negativeButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                buttonsClickListener.onNegativeButtonClick(dialog);
            }
        });

        builder.setNeutralButton(neutralButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                buttonsClickListener.onNeutralButtonClick(dialog);
            }
        });

        alertDialog = builder.create();
        alertDialog.setCancelable(cancelable);
        alertDialog.show();
        return alertDialog;
    }

    /**
     * Show easy AlertDialog with ANY context (Application|Base|Activity).
     * You can show this dialog from background (service), for example.
     * Just create Activity for dialog and send its full name to this function
     * @param targetDialogActivityClassName name of Activity (from AndroidManifest).
     *                                      Example: ru.rsit.megashare.controllers.activities.DialogActivity
     * @throws PackageManager.NameNotFoundException Activity with such name not found
     */
    public void showEAActivityDialog(String targetDialogActivityClassName)
            throws PackageManager.NameNotFoundException {
        String packageName = appContext.getPackageName();
        PackageManager pm = appContext.getPackageManager();
        PackageInfo packageInfo = pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
        for(ActivityInfo activity : packageInfo.activities){
            if (activity.name.equals(targetDialogActivityClassName)){
                ComponentName componentName = new ComponentName(
                        packageName,
//                        activity.applicationInfo.packageName,
                        activity.name);
                Intent i=new Intent(Intent.ACTION_MAIN);

                i.addCategory(Intent.CATEGORY_LAUNCHER);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                        //Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                i.setComponent(componentName);
                appContext.startActivity(i);
                break;
            }
        }
    }

}
