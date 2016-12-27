package xn.bwie.com.myreclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import xn.bwie.com.myreclerview.refrash.PullBaseView;

public class NormalActivity extends AppCompatActivity implements View.OnClickListener,PullBaseView.OnHeaderRefreshListener,
        PullBaseView.OnFooterRefreshListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();

        initDate();

        //设置布局管理器，制定管理器类型以及排列方式
        //设置排列方式LinearLayoutManager.VERTICAL  竖直
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //设置数据适配器
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        NormalAdapter normalAdapter = new NormalAdapter(this, list);
        recyclerView.setAdapter(normalAdapter);


//        recyclerView.setOnHeaderRefreshListener(this);//设置下拉监听
//        recyclerView.setOnFooterRefreshListener(this);//设置上拉监
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置点击事件的监听
        normalAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(NormalActivity.this, "position==" + position, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(int position) {
                Toast.makeText(NormalActivity.this, "长安了==" + list.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }


    ArrayList<String> list=new ArrayList<>();
    private void initDate() {
        for (int i = 0; i < 100; i++) {
            list.add("我是"+i);
        }
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        findViewById(R.id.bt_normal_back).setOnClickListener(this);
        findViewById(R.id.bt_normal_grid).setOnClickListener(this);
        findViewById(R.id.bt_normal_hori).setOnClickListener(this);
        findViewById(R.id.bt_normal_grid_hori).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_normal_back:
                recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                break;
            case R.id.bt_normal_grid:
                recyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
                break;
            case R.id.bt_normal_hori:
                recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                break;
            case R.id.bt_normal_grid_hori:
                recyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, false));
                break;
        }
    }

    @Override
    public void onFooterRefresh(PullBaseView view) {

    }

    @Override
    public void onHeaderRefresh(PullBaseView view) {

    }
}
