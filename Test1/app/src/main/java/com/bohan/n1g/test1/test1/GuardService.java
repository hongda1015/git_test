package com.bohan.n1g.test1.test1;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

public class GuardService extends Service {
    private MinBroadcastReceiver minReceiver;

    private class MinBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            Log.e("~~~~~","接收到广播 "+ intent.getAction());
            if (Intent.ACTION_TIME_TICK.equals(intent.getAction())){
                Log.e("I am egg","接收到时间广播");

            } else if ("KILL_1".equals(intent.getAction())){
                sendBroadcast(new Intent("EXITAPP"));
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        minReceiver = new MinBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);
        filter.addAction("KILL_1");
        registerReceiver(minReceiver, filter);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(minReceiver);
    }
}
