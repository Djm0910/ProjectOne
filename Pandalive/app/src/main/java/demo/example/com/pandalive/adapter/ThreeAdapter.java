package demo.example.com.pandalive.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.app.App;
import demo.example.com.pandalive.bean.MyThree;
import demo.example.com.pandalive.ui.acctivity.WebActivity;
import demo.example.com.pandalive.utils.FragmentBuilder;

/**
 * Created by 丁军明 on 2017/12/21.
 */

public class ThreeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private MyThree myThree;
    private Context mContext;

    public ThreeAdapter(MyThree myThree, Context mContext) {
        this.myThree = myThree;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder holder = null;
        if (viewType == 0) {
            View view = inflater.inflate(R.layout.obser_item, parent, false);
            holder = new ViewOne(view);
        } else if (viewType == 1) {
            View view = inflater.inflate(R.layout.obsr_one, parent, false);
            holder = new ViewTwo(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewOne) {
            List<MyThree.BigImgBean> bigImg = myThree.getBigImg();
            Glide.with(mContext).load(bigImg.get(0).getImage()).into(((ViewOne) holder).mImg);
            ((ViewOne) holder).mTitle.setText(bigImg.get(0).getTitle());
        } else if (holder instanceof ViewTwo) {
            final List<MyThree.ListBean> list = myThree.getList();

            ((ViewTwo) holder).mRceyTwo.setLayoutManager(new LinearLayoutManager(mContext));
            ObsrAdapter obsrAdapter = new ObsrAdapter(list, mContext);
            ((ViewTwo) holder).mRceyTwo.setAdapter(obsrAdapter);
            obsrAdapter.OnItemClick(new ObsrAdapter.OnItem() {
                @Override
                public void setData(View view, int position) {
                    Intent intent = new Intent(mContext, WebActivity.class);
                    intent.putExtra("url", list.get(position).getUrl());
                    mContext.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        }
        return super.getItemViewType(position);
    }

    class ViewOne extends RecyclerView.ViewHolder {
        private ImageView mImg;
        private TextView mTitle;

        public ViewOne(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.obsr_Img);
            mTitle = itemView.findViewById(R.id.obsr_Text);
        }
    }

    class ViewTwo extends RecyclerView.ViewHolder {
        private RecyclerView mRceyTwo;

        public ViewTwo(View itemView) {
            super(itemView);
            mRceyTwo = itemView.findViewById(R.id.Recy_obsr);
        }
    }

}
