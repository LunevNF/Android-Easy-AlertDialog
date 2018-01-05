package ru.rsit.easyalertdialogsample;

import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;

import java.util.Timer;
import java.util.TimerTask;

import ru.rsit.easyalertdialog.EADialogManager;

/**
 * ThisApp class
 * @author nikitoSha (https://github.com/nikitoSha)
 */

public class ThisApp extends Application {
    /** Контекст приложения */
    private static ThisApp appContext;

    /**
     * Easy AlertDialog Manager
     * {@link EADialogManager}
     */
    private static EADialogManager eaDialogManager;

    public static MyService myService;
    private static Intent myServiceIntent;

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = this;
        eaDialogManager = new EADialogManager(appContext);
        //startMyService();
    }

    /**
     * Get this App context
     * @return Context of App
     */
    public static ThisApp getAppContext() {
        return appContext;
    }

    /**
     * Get object of {@link EADialogManager}
     * @return object of {@link EADialogManager}
     */
    public static EADialogManager getEaDialogManager(){
        return eaDialogManager;
    }

    /**
     * Get {@link MyService}
     * @return service instance {@link MyService}
     */
    public static MyService getMyServiceInstance() {
        return myService;
    }

    /**
     * Save {@link MyService} instance
     * @param instance {@link MyService} instance
     */
    public static void setMyServiceInstance(MyService instance) {
        myService = instance;
    }

    /**
     * Start {@link MyService}
     */
    public static void stopMyService(){
        if (myServiceIntent != null) {
            ThisApp.getAppContext().stopService(myServiceIntent);
        }
    }

    /**
     * Stop {@link MyService}
     */
    public static void startMyService(){
        myServiceIntent = new Intent(appContext, MyService.class);
        ThisApp.getAppContext().startService(myServiceIntent);
    }
}
