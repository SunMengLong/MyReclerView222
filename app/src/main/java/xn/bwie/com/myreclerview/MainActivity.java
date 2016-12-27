package xn.bwie.com.myreclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    ArrayList<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.main_lv);
        initDate();
        //设置数据适配器
        setMyAdapter();
    }

    private void setMyAdapter() {
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        enterActivity(NormalActivity.class);
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void initDate() {
        list.add("普通条目展示");
        list.add("多条目展示");
    }

    public void enterActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
