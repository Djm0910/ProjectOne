package demo.example.com.pandalive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.bean.MyHome;

/**
 * Created by 丁军明 on 2017/12/20.
 */

public class ChinaAdapter extends RecyclerView.Adapter<ChinaAdapter.ViewHolder> {
    private List<MyHome.DataBean.ChinaliveBean.ListBeanX> list1;
    private Context mContext;

    public ChinaAdapter(List<MyHome.DataBean.ChinaliveBean.ListBeanX> list1, Context mContext) {
        this.list1 = list1;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.xiu_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTxetView.setText(list1.get(position).getTitle());
        Glide.with(mContext).load(list1.get(position).getImage()).into(holder.mImg);
    }

    @Override
    public int getItemCount() {
        return list1.isEmpty() ? 0 : list1.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImg;
        private TextView mTxetView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.Xiu_img);
            mTxetView = itemView.findViewById(R.id.Xiu_Text);
        }
    }
}
