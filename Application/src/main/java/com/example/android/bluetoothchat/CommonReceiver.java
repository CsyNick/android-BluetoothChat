package com.example.android.bluetoothchat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CommonReceiver extends BroadcastReceiver {
 

@Override
 

public void onReceive(Context coNtext, Intent intent) {
 

String action = intent.getAction();




if(action.equals(Intent.ACTION_BOOT_COMPLETED)) {
    Toast.makeText(coNtext,"Starting Bluetooth Connect Service...",Toast.LENGTH_LONG).show();
    Intent startIntent = new Intent();
 
    startIntent.setClass(coNtext, TempService.class);
 
    coNtext.startService(startIntent);

}
 

}


}
 