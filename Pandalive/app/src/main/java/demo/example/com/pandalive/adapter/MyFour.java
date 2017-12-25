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

import com.bumptech.glide.Glide;

import java.util.List;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.bean.Gun;
import demo.example.com.pandalive.bean.GunGun;
import demo.example.com.pandalive.ui.acctivity.WebActivity;

/**
 * Created by 丁军明 on 2017/12/22.
 */

public class MyFour extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Gun gun;
    private List<GunGun.ListBean> list;
    private Context mContext;

    public MyFour(Gun gun, List<GunGun.ListBean> list, Context mContext) {
        this.gun = gun;
        this.list = list;
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
            List<Gun.DataBean.BigImgBean> bigImg = gun.getData().getBigImg();
            Glide.with(mContext).load(bigImg.get(0).getImage()).into(((ViewOne) holder).mImg);
            ((ViewOne) holder).mTitle.setText(bigImg.get(0).getTitle());
        } else if (holder instanceof ViewTwo) {
            ((ViewTwo) holder).mRceyTwo.setLayoutManager(new LinearLayoutManager(mContext));
            GunOne gunOne = new GunOne(list, mContext);
            ((ViewTwo) holder).mRceyTwo.setAdapter(gunOne);
            gunOne.OnItemClick(new GunOne.OnItem() {
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

