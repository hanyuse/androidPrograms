package example.com.androidprograms.saveData;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import example.com.androidprograms.R;

public class SharePerferenceActivity extends AppCompatActivity {
    private Button saveBtn,showBtn;
    private EditText editText;
    private TextView textView;
    private String TAG = "SharePerferenceActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_perference);
        saveBtn = (Button)findViewById(R.id.save_data);
        showBtn = (Button)findViewById(R.id.show_data);
        editText = (EditText)findViewById(R.id.edit);
        textView = (TextView)findViewById(R.id.show_file);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if(!text.equals("")){


                }
            }
        });


    }


}
