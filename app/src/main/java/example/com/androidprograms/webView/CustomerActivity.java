package example.com.androidprograms.webView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import example.com.androidprograms.R;
import example.com.androidprograms.instance.CustomerAdapter;
import example.com.androidprograms.instance.Fruit;
//使用自定义的Adapter布局

public class CustomerActivity extends AppCompatActivity {
    private List<Fruit> list = new ArrayList<Fruit>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        initFruit();
        ListView listView = findViewById(R.id.custom_adapter);
        CustomerAdapter adapter = new CustomerAdapter(CustomerActivity.this,R.layout.fruit_item,list);
        listView.setAdapter(adapter);

    }


    public void initFruit(){
        for(int i=0;i<3;i++){

            list.add(new Fruit("香蕉",i+""));
            list.add(new Fruit("梨子",i+""));
            list.add(new Fruit("苹果",i+""));
            list.add(new Fruit("柿子",i+""));
            list.add(new Fruit("葡萄",i+""));
            list.add(new Fruit("芒果",i+""));
            list.add(new Fruit("火龙果",i+""));
            list.add(new Fruit("不够啊",i+""));
            list.add(new Fruit("现在呢",i+""));
            list.add(new Fruit("差不多",i+""));
            list.add(new Fruit("好了",i+""));

        }
    }
}
