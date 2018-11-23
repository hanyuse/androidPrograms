package example.com.androidprograms.broadCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import example.com.androidprograms.R;

/**
 * 测试广播接收器
 */
public class BroadCastActivity extends AppCompatActivity {
    private Button button;
    private NewWorkChange newWorkChange;
    private String TAG = "BroadCastActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);
        button = (Button)findViewById(R.id.broadcast);




        //创建IntentFilter实例，添加网络变化action
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTTIVITY_CHANGE");
        //注册广播接收器
        newWorkChange = new NewWorkChange();
        registerReceiver(newWorkChange,intentFilter);


       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = isMobileConnected(BroadCastActivity.this);
                if(b){
                    Log.d(TAG, "onClick: 有网络");
                    Toast.makeText(BroadCastActivity.this,"有网络",Toast.LENGTH_SHORT).show();
                }else {
                    Log.d(TAG, "onClick: 无网络");
                    Toast.makeText(BroadCastActivity.this,"无网络",Toast.LENGTH_SHORT).show();
                }
                //发送广播
                Intent intent = new Intent("com.example.broadCast.MyReceiver");
                sendBroadcast(intent);

            }
        });
    }

    @Override
    protected void onDestroy() {
        //广播需要注销
        unregisterReceiver(newWorkChange);
        super.onDestroy();
    }

    class NewWorkChange extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("BroadCastActivity", "net changed ");
            Toast.makeText(context,"net changed",Toast.LENGTH_SHORT).show();
        }
    }

    //判断手机是否具有网络
    public boolean isMobileConnected(Context context) {
        if (context != null) {
            //getSystemService方法获得系统管理类
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo mMobileNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }


}
