package example.com.androidprograms.saveData;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import example.com.androidprograms.R;

public class FileSaveActivity extends AppCompatActivity {
    private Button saveBtn,showBtn;
    private EditText editText;
    private TextView textView;
    private String TAG = "FileSaveActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_save);
        saveBtn = (Button)findViewById(R.id.save_data);
        showBtn = (Button)findViewById(R.id.show_data);
        editText = (EditText)findViewById(R.id.edit);
        textView = (TextView)findViewById(R.id.show_file);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击save button 将数据保存到文件中
                FileOutputStream out = null;
                BufferedWriter writer = null;
                String text;


                try {
                    text = editText.getText().toString();
                    if(!text.trim().equals("")){
                        out = openFileOutput("data",Context.MODE_PRIVATE);
                        //使用缓冲流处理
                        writer = new BufferedWriter(new OutputStreamWriter(out));
                        writer.write(text);

                    }else{
                        Toast.makeText(FileSaveActivity.this,"写输入要存储的内容",Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "没有输入内容 ");
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if(writer!=null){
                            writer.close();
                        }
                        if(out!=null){
                            out.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream in = null;
                BufferedReader reader = null;

                try {
                    in = openFileInput("data");
                    StringBuffer sb = new StringBuffer();
                    String line;
                    reader = new BufferedReader(new InputStreamReader(in));
                    while ((line = reader.readLine())!=null){
                        sb.append(line);
                    }
                    if(sb.toString().equals("")){
                        Log.d(TAG, "您未保存过数据");
                    }else{
                        textView.setText(sb.toString());
                        textView.setSelected(true);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
