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
import demo.example.com.pandalive.bean.ZhiBo;

/**
 * Created by 丁军明 on 2017/12/22.
 */

public class ZbAdapter extends RecyclerView.Adapter<ZbAdapter.ViewHolder> {
    private List<ZhiBo.ListBean> list;
    private Context mContext;

    public ZbAdapter(List<ZhiBo.ListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.xiu_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTxetView.setText(list.get(position).getTitle());
        Glide.with(mContext).load(list.get(position).getImage()).into(holder.mImg);
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
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

