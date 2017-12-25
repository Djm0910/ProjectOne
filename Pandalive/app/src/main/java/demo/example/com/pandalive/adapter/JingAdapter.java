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
import demo.example.com.pandalive.bean.MyJc;

/**
 * Created by 丁军明 on 2017/12/20.
 */

public class JingAdapter extends RecyclerView.Adapter<JingAdapter.ViewHolder> {
    private Context mContext;
    private List<MyJc.ListBean>  list1;

    public JingAdapter(Context mContext, List<MyJc.ListBean> list1) {
        this.mContext = mContext;
        this.list1 = list1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jingcai_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(list1.get(position).getImage()).into(holder.mImg);
        holder.mTitle.setText(list1.get(position).getTitle());
        holder.mTime.setText(list1.get(position).getDaytime());
    }

    @Override
    public int getItemCount() {
        return list1.isEmpty() ? 0 : list1.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImg;
        private TextView mTitle,mTime;
        public ViewHolder(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.Img_jingcai);
            mTitle = itemView.findViewById(R.id.title_jingcai);
            mTime = itemView.findViewById(R.id.time_jingcai);
        }
    }
}
