package ru.rsit.easyalertdialogsample;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import java.util.Timer;
import java.util.TimerTask;


/**
 * @author nikitoSha (https://github.com/nikitoSha)
 */
public class MyService extends Service {

    /** Timer that runs AlertDialog from background at Home screen */
    static Timer showActivityAlertTimer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * Событие запуска сервиса
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Сохранить инстанс класса (сервиса)
        if (ThisApp.getMyServiceInstance() == null){
            ThisApp.setMyServiceInstance(this);
        }

        startTimer();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

    }

    /**
     * Timer: show AlerDialog from background at Home screen
     */
    public static void startTimer(){
        showActivityAlertTimer = new Timer();
        showActivityAlertTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    ThisApp.getEaDialogManager().showEAActivityDialog(
                            "ru.rsit.easyalertdialogsample.DialogActivity");
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                showActivityAlertTimer.cancel();
                ThisApp.stopMyService();
            }
        }, 4000);
    }

}
