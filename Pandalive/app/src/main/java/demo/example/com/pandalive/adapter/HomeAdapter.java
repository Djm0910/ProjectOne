package demo.example.com.pandalive.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.bean.MyHome;
import demo.example.com.pandalive.bean.MyJc;
import demo.example.com.pandalive.bean.MyShi;

/**
 * Created by 丁军明 on 2017/12/20.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private List<MyJc.ListBean> list1;
    private List<MyShi.ListBean> list2;
    private MyHome.DataBean data;

    public HomeAdapter(Context mContext, List<MyJc.ListBean> list1, List<MyShi.ListBean> list2, MyHome.DataBean data) {
        this.mContext = mContext;
        this.list1 = list1;
        this.list2 = list2;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder holder = null;
        if (viewType == 0) {
            View view = inflater.inflate(R.layout.home_banner, parent, false);
            holder = new ViewOne(view);
            view.setOnClickListener(this);
        } else if (viewType == 1) {
            View view = inflater.inflate(R.layout.home_two, parent, false);
            holder = new ViewTwo(view);
            view.setOnClickListener(this);
        } else if (viewType == 2) {
            View view = inflater.inflate(R.layout.home_three, parent, false);
            holder = new ViewThree(view);
            view.setOnClickListener(this);
        } else if (viewType == 3) {
            View view = inflater.inflate(R.layout.home_four, parent, false);
            holder = new ViewFour(view);
            view.setOnClickListener(this);
        } else if (viewType == 4) {
            View view = inflater.inflate(R.layout.home_five, parent, false);
            holder = new ViewFive(view);
            view.setOnClickListener(this);
        } else if (viewType == 5) {
            View view = inflater.inflate(R.layout.home_six, parent, false);
            holder = new ViewSix(view);
            view.setOnClickListener(this);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewOne) {
            List<MyHome.DataBean.BigImgBean> bigImg = data.getBigImg();
            List<String> images = new ArrayList<>();
            List<String> titles = new ArrayList<>();
            for (int i = 0; i < bigImg.size(); i++) {
                images.add(bigImg.get(i).getImage());
                titles.add(bigImg.get(i).getTitle());
            }
            class GlideImage extends ImageLoader {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context.getApplicationContext()).load(path).into(imageView);
                }
            }
            ((ViewOne) holder).banner.setImages(images)
                    .setBannerTitles(titles)
                    .setBannerAnimation(Transformer.DepthPage)
                    .setDelayTime(2000)//设置轮播时间
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                    .setImageLoader(new GlideImage())//加载图片
                    .setIndicatorGravity(BannerConfig.RIGHT)//设置指示器位置
                    .start();
            holder.itemView.setTag(position);
        } else if (holder instanceof ViewTwo) {
            List<MyHome.DataBean.PandaeyeBean.ItemsBean> items = data.getPandaeye().getItems();
            Glide.with(mContext).load(data.getPandaeye().getPandaeyelogo()).into(((ViewTwo) holder).mTwo);
            ((ViewTwo) holder).mTwo_a.setText(items.get(0).getBrief());
            ((ViewTwo) holder).mTwo_b.setText(items.get(0).getTitle());
            ((ViewTwo) holder).mTwo_c.setText(items.get(1).getBrief());
            ((ViewTwo) holder).mTwo_d.setText(items.get(1).getTitle());
            holder.itemView.setTag(position);
        } else if (holder instanceof ViewThree) {
            List<MyHome.DataBean.PandaliveBean.ListBean> list = data.getPandalive().getList();
            ((ViewThree) holder).mText_three.setText(data.getPandalive().getTitle());
            ((ViewThree) holder).mRecyA.setLayoutManager(new GridLayoutManager(mContext, 3));
            ((ViewThree) holder).mRecyA.setAdapter(new XiuAdapter(list, mContext));
            holder.itemView.setTag(position);
        } else if (holder instanceof ViewFour) {
            ((ViewFour) holder).mText_four.setText(data.getCctv().getTitle());
            ((ViewFour) holder).mRecyB.setLayoutManager(new GridLayoutManager(mContext, 2));
            ((ViewFour) holder).mRecyB.setAdapter(new JingAdapter(mContext, list1));
            holder.itemView.setTag(position);
        } else if (holder instanceof ViewFive) {
            ((ViewFive) holder).mText_five.setText(data.getList().get(0).getTitle());
            ((ViewFive) holder).mRecyC.setLayoutManager(new LinearLayoutManager(mContext));
            ((ViewFive) holder).mRecyC.setAdapter(new GunAdapter(list2, mContext));
        } else if (holder instanceof ViewSix) {
            ((ViewSix) holder).mText_six.setText(data.getChinalive().getTitle());
            ((ViewSix) holder).mRecyD.setLayoutManager(new GridLayoutManager(mContext, 3));
            ((ViewSix) holder).mRecyD.setAdapter(new ChinaAdapter(data.getChinalive().getList(), mContext));
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else if (position == 3) {
            return 3;
        } else if (position == 4) {
            return 4;
        } else if (position == 5) {
            return 5;
        }
        return super.getItemViewType(position);
    }

    class ViewOne extends RecyclerView.ViewHolder {
        private Banner banner;

        public ViewOne(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.Banner);
        }
    }

    class ViewTwo extends RecyclerView.ViewHolder {
        private ImageView mTwo;
        private TextView mTwo_a, mTwo_b, mTwo_c, mTwo_d;

        public ViewTwo(View itemView) {
            super(itemView);
            mTwo = itemView.findViewById(R.id.Img_two);
            mTwo_a = itemView.findViewById(R.id.Text_two_a);
            mTwo_b = itemView.findViewById(R.id.Text_two_b);
            mTwo_c = itemView.findViewById(R.id.Text_two_c);
            mTwo_d = itemView.findViewById(R.id.Text_two_d);
        }
    }

    class ViewThree extends RecyclerView.ViewHolder {
        private RecyclerView mRecyA;
        private TextView mText_three;

        public ViewThree(View itemView) {
            super(itemView);
            mRecyA = itemView.findViewById(R.id.Recy_three);
            mText_three = itemView.findViewById(R.id.Text_three);
        }
    }

    class ViewFour extends RecyclerView.ViewHolder {
        private RecyclerView mRecyB;
        private TextView mText_four;

        public ViewFour(View itemView) {
            super(itemView);
            mRecyB = itemView.findViewById(R.id.Recy_four);
            mText_four = itemView.findViewById(R.id.Text_four);
        }
    }

    class ViewFive extends RecyclerView.ViewHolder {
        private RecyclerView mRecyC;
        private TextView mText_five;

        public ViewFive(View itemView) {
            super(itemView);
            mText_five = itemView.findViewById(R.id.Text_five);
            mRecyC = itemView.findViewById(R.id.Recy_five);
        }
    }

    class ViewSix extends RecyclerView.ViewHolder {
        private RecyclerView mRecyD;
        private TextView mText_six;

        public ViewSix(View itemView) {
            super(itemView);
            mRecyD = itemView.findViewById(R.id.Recy_six);
            mText_six = itemView.findViewById(R.id.Text_six);
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
