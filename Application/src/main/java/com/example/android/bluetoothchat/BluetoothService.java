package com.example.android.bluetoothchat;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by NickChung on 2017/4/27.
 */

public class BluetoothService extends Service  {
    private int sum = 0;
    private boolean running = true;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("ServiceProject","onCreate");
        thread.start();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ServiceProject","onDestroy");
        running = false;

    }

    Thread thread = new Thread(new Runnable(){

        @Override
        public void run() {
            while(running){
                sum++;
                Log.d("ServiceProject","ServiceSwe : "+sum);
                Intent intent=new Intent();
                intent.putExtra("Swe_sum", ""+sum);
                intent.setAction("android.intent.action.test");
                sendBroadcast(intent);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    running = false;
                    e.printStackTrace();
                }
            }
        }});


}
