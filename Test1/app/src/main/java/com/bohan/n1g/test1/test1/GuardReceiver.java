package com.bohan.n1g.test1.test1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by liyin on 2017-11-30.
 */

public class GuardReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent mBootIntent = new Intent(context, GuardService.class);
        context.startService(mBootIntent);
    }
}
