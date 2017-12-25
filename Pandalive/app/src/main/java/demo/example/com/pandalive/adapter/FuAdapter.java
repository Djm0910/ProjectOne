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
import demo.example.com.pandalive.bean.FuYong;

/**
 * Created by 丁军明 on 2017/12/23.
 */

public class FuAdapter extends RecyclerView.Adapter<FuAdapter.ViewHolder> {
    private List<FuYong.VideoBean> video;
    private Context mContext;

    public FuAdapter(List<FuYong.VideoBean> video, Context mContext) {
        this.video = video;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.culture_fuyong, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(video.get(position).getImg()).into(holder.mImg);
        holder.mTitle.setText(video.get(position).getT());
        holder.mName.setText(video.get(position).getPtime());
        holder.mTime.setText(video.get(position).getLen());
    }

    @Override
    public int getItemCount() {
        return video.isEmpty() ? 0 : video.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImg;
        private TextView mTitle, mTime, mName;

        public ViewHolder(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.FY_img);
            mTitle = itemView.findViewById(R.id.FY_title);
            mTime = itemView.findViewById(R.id.FY_time);
            mName = itemView.findViewById(R.id.FY_xiao);
        }
    }
}
