package com.bohan.n1g.test1.test1;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

public class MainActivity extends Activity {
    private ExitBroadcastReceiver minReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this,GuardService.class));
        minReceiver = new ExitBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("EXITAPP");
        registerReceiver(minReceiver, filter);
        // test
        // TEST

    }

    private class ExitBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            if ("EXITAPP".equals(intent.getAction())){
                finish();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(minReceiver);
        stopService(new Intent(this,GuardService.class));
        Log.e("~~~~","test1 go die");
    }
}
