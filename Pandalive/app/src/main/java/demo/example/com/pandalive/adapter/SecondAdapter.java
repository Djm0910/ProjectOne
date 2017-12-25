package demo.example.com.pandalive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.bean.MySecond;

/**
 * Created by 丁军明 on 2017/12/23.
 */

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder> {
    private List<MySecond.DataBean.ContentBean> content;
    private Context mContext;

    public SecondAdapter(List<MySecond.DataBean.ContentBean> content, Context mContext) {
        this.content = content;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mContent.setText(content.get(position).getMessage());
        holder.mTitle.setText(content.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return content.isEmpty() ? 0 : content.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle, mContent;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.Title_second);
            mContent = itemView.findViewById(R.id.Content_Second);
        }
    }

}
