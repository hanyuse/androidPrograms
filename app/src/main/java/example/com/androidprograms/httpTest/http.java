package example.com.androidprograms.httpTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import example.com.androidprograms.R;

public class http extends AppCompatActivity {
    private String TAG = "http_test";
    private TextView textView;
    StringBuffer sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        Button button = (Button) findViewById(R.id.send_http);
        textView = (TextView)findViewById(R.id.text_http);
        Log.d(TAG, "onCreate: start");
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sendHttp();

            }
        });
    }

    private void sendHttp(){
        //发送请求需要新建子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "onClick: onclick excute");
                try {
                    //1.新建URL
                    URL url = new URL("https://www.baidu.com");
                    //2.通过URL获取HttpURLConnection（需要转型）
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    //3.response 是从connection.getInputStream()获得。
                    InputStream in = connection.getInputStream();
                    //4.建立缓冲区读取返回的数据
                    BufferedReader bf = new BufferedReader(new InputStreamReader(in));
                     sb = new StringBuffer();
                    String line;
                    while((line = bf.readLine())!=null){
                        sb.append(line);
                    }

                    //子线程中不允许更新ui，需要切回到主线程里面更新ui
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //更新数据
                            textView.setText(sb.toString());
                        }
                    });

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



}
