package example.com.androidprograms.broadCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"开机就这么拽",Toast.LENGTH_SHORT).show();
        Log.d("MyReceiver", "onReceive: 开机启动");



    }
}
