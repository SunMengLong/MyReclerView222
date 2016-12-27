package xn.bwie.com.myreclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zhiyuan on 16/10/5.
 */
public class NormalHolder extends RecyclerView.ViewHolder {

    public ImageView iv_normal_icon;
    public TextView tv_normal_title;
  public  View item;

    /**
     * @param itemView 实例化布局所转化成的view
     */
    public NormalHolder(View itemView) {

        super(itemView);
        //找控件
        iv_normal_icon = (ImageView) itemView.findViewById(R.id.iv_normal_icon);
        tv_normal_title = (TextView) itemView.findViewById(R.id.tv_normal_title);
        item = itemView.findViewById(R.id.item);

    }
}
