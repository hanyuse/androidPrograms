package example.com.androidprograms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * SimpleAdapter使用于展示多控件的适配器
 * 与ArrayAdapter相比
 * 1.支持item显示的控件要更多
 * 2，数据的格式比较复杂
 */

public class Simple_adapterActivity extends AppCompatActivity {
    private ListView listView;
    private SimpleAdapter adapter;
    private List<Map<String,Object>> list;
    private Map<String,Object> map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        listView = findViewById(R.id.list1);


        //定义数据源
        list = new ArrayList<Map<String,Object>>();
        for (int i=0;i<40;i++){
            map = new HashMap<String,Object>();
            map.put("data","data:"+i);
            map.put("intro","intro"+i);
            list.add(map);
        }
        String[] from = {"data","intro"};
        int[] to = {R.id.data,R.id.intro};

        /**
         * 数据源list<Map<String,Object>>,map的键要为String类型
         * resource item对应的布局文件
         * from 由map中定义的key组成的String 数组
         * to 由需要显示的控件id组件的int类型数组
         * from和to的顺序要一一对象
         */
        adapter = new SimpleAdapter(this,list,R.layout.simple_adapter_item,from,to);
        //设置适配器进行显示
        listView.setAdapter(adapter);

        //为adapterView添加Item点击事件
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //view.findViewById方法可以找到当前view下面对应id的view
                TextView textView =  view.findViewById(R.id.data);

                Log.d("Simple_adapterActivity", "onItemClick: "+textView.getText().toString());
            }
        };
        listView.setOnItemClickListener(onItemClickListener);

    }
}
