package example.com.androidprograms.instance;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import example.com.androidprograms.R;
import java.util.List;

public class CustomerAdapter extends ArrayAdapter<Fruit> {
    private String TAG =  "CustomerAdapter";
    private int resourceId;

    public CustomerAdapter(Context context,int textViewResourceId,List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    //getView方法在每个子项被滚动到屏幕上的时候被调用

    /**
     *
     * @param position 位置
     * @param convertView  用于缓存之前加载的布局
     * @param parent  adapterView
     * @return
     */
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        Fruit fruit = getItem(position);

        //性能优化
        View view;
        if(convertView == null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else{
            view = convertView;
        }


        Log.d(TAG, convertView.toString());
        TextView idView = (TextView) view.findViewById(R.id.fruit_id);
        TextView nameView = (TextView)view.findViewById(R.id.fruit_name);

        idView.setText("水果："+fruit.getId());
        nameView.setText("名称："+fruit.getName());
        return view;
    }
}
