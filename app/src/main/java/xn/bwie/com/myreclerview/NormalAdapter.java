package xn.bwie.com.myreclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by zhiyuan on 16/10/5.
 */
public class NormalAdapter extends RecyclerView.Adapter<NormalHolder> {

    private final Context context;
    private final ArrayList<String> dataList;
    private OnItemClickListener onItmeClickListener;

    public NormalAdapter(Context context, ArrayList<String> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    /**
     * 实例化viewHolder，设置viewHolder的布局效果view，返回viewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public NormalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建view
        View view = View.inflate(context, R.layout.normal_item, null);


        //将view传递给holder
        NormalHolder normalHolder = new NormalHolder(view);
        return normalHolder;
    }

    /**
     * 展示数据到viewHolder
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(NormalHolder holder, final int position) {

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItmeClickListener != null) {
                    onItmeClickListener.onItemClick(position);
                }
            }
        });

        holder.item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(onItmeClickListener!=null){
                    onItmeClickListener.onItemLongClick(position);
                }
                return true;
            }
        });
        //设置数据
        holder.tv_normal_title.setText(dataList.get(position));

    }

    /**
     * 获取条目个数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItmeClickListener = onItemClickListener;
    }
}
