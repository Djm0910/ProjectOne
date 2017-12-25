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
import demo.example.com.pandalive.bean.MyShi;

/**
 * Created by 丁军明 on 2017/12/20.
 */

public class GunAdapter extends RecyclerView.Adapter<GunAdapter.ViewHolde> {
    private List<MyShi.ListBean> list2;
    private Context mContext;

    public GunAdapter(List<MyShi.ListBean> list2, Context mContext) {
        this.list2 = list2;
        this.mContext = mContext;
    }

    @Override
    public ViewHolde onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.gungun_item, null);
        ViewHolde holde = new ViewHolde(view);
        return holde;
    }

    @Override
    public void onBindViewHolder(ViewHolde holder, int position) {
        Glide.with(mContext).load(list2.get(position).getImage()).into(holder.mImg);
        holder.mTitle.setText(list2.get(position).getTitle());
        holder.mTime.setText(list2.get(position).getDaytime());

    }

    @Override
    public int getItemCount() {
        return list2.isEmpty() ? 0 : list2.size();
    }

    class ViewHolde extends RecyclerView.ViewHolder {
        private ImageView mImg;
        private TextView mTitle, mTime;

        public ViewHolde(View itemView) {
            super(itemView);
            mTime = itemView.findViewById(R.id.time_gun);
            mTitle = itemView.findViewById(R.id.title_gun);
            mImg = itemView.findViewById(R.id.Img_gun);
        }
    }
}
