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
import demo.example.com.pandalive.bean.GunGun;
import demo.example.com.pandalive.bean.MyThree;

/**
 * Created by 丁军明 on 2017/12/22.
 */

public class GunOne extends RecyclerView.Adapter<GunOne.ViewHoler> implements View.OnClickListener {

    private List<GunGun.ListBean> list;
    private Context mContext;

    public GunOne(List<GunGun.ListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public GunOne.ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.live_item, parent, false);
        GunOne.ViewHoler viewHoler = new GunOne.ViewHoler(view);
        view.setOnClickListener(this);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(GunOne.ViewHoler holder, int position) {
        holder.mDa.setText(list.get(position).getTitle());
        holder.mXiao.setText(list.get(position).getDatatype());
        Glide.with(mContext).load(list.get(position).getPicurl()).into(holder.mImg);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    class ViewHoler extends RecyclerView.ViewHolder {
        private ImageView mImg;
        private TextView mDa, mXiao;

        public ViewHoler(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.live_img);
            mDa = itemView.findViewById(R.id.live_title);
            mXiao = itemView.findViewById(R.id.live_xiao);
        }
    }


    public interface OnItem {
        void setData(View view, int position);
    }

    private OnItem onItem = null;

    @Override
    public void onClick(View v) {
        if (onItem != null) {
            onItem.setData(v, (int) v.getTag());
        }
    }

    public void OnItemClick(OnItem onItem) {
        this.onItem = onItem;
    }
}
