package jp.takke.datastats;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import jp.takke.util.MyLog;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        
        MyLog.i("BootReceiver.onReceive");

        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            // 端末起動時の処理
            
            // 自動起動の確認
            final SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
            final boolean startOnBoot = pref.getBoolean(C.PREF_KEY_START_ON_BOOT, false);
            
            MyLog.i("start on boot[" + (startOnBoot ? "YES" : "NO") + "]");
            
            if (startOnBoot) {
                // サービス起動
                final Intent serviceIntent = new Intent(context, LayerService.class);
                context.startService(serviceIntent);
            }
        }
        
    }
}
