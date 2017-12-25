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
import demo.example.com.pandalive.bean.MyThree;

/**
 * Created by 丁军明 on 2017/12/21.
 */

public class ObsrAdapter extends RecyclerView.Adapter<ObsrAdapter.ViewHoler> implements View.OnClickListener{
    List<MyThree.ListBean> list;
    private Context mContext;

    public ObsrAdapter(List<MyThree.ListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.obse_two, parent, false);
        ViewHoler viewHoler = new ViewHoler(view);
        view.setOnClickListener(this);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {
        holder.mDa.setText(list.get(position).getTitle());
        holder.mXiao.setText(list.get(position).getBrief());
        holder.mTime.setText(list.get(position).getVideoLength());
        Glide.with(mContext).load(list.get(position).getImage()).into(holder.mImg);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    class ViewHoler extends RecyclerView.ViewHolder {
        private ImageView mImg;
        private TextView mDa, mXiao,mTime;

        public ViewHoler(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.obse_img);
            mDa = itemView.findViewById(R.id.obse_title);
            mXiao = itemView.findViewById(R.id.obse_xiao);
            mTime = itemView.findViewById(R.id.Time_obse);
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
