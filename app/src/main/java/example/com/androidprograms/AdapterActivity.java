package example.com.androidprograms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器的简单使用
 * ArrayAdapter适合显示字符串
 */
public class AdapterActivity extends AppCompatActivity {
    private  ListView listView; //装载适配器容器
    private ArrayAdapter<String> adapter;//适配器
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        listView = findViewById(R.id.list);
        //加载数据
        list = new ArrayList<String>();
        for(int i=0;i<40;i++){
            list.add("数据："+i);
        }
        //适配器的初始化，第二个参数为布局资源id,ArrayAdapter显示的item的布局根节点必须是TextView
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list);
        //将适配器放到listView上面
        listView.setAdapter(adapter);
        //listView设置点击事件
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            /**
             * @param parent  适配器设置到的AdapterView对象，这里就是listView
             * @param view     adapter适配器Item对应的view
             * @param position  索引位置
             * @param id    在listView中的item对应的行id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                TextView v = (TextView)view;
                v.getText();
                Log.d("AdapterActivity", "点击的索引是"+v.getText().toString()+",id是"+id);
                Toast.makeText(AdapterActivity.this,"点击的索引是"+id,Toast.LENGTH_LONG).show();
                Log.d("AdapterActivity", "点击的索引是"+position+",id是"+id);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //删除一项
                list.remove(position);
                //如果适配器发生了变化，需要更新listView
                adapter.notifyDataSetChanged();

                //返回值为true表示响应长按事件而不会触发单击事件，返回false怎click事件也会触发
                return true;
            }
        });


    }
}
