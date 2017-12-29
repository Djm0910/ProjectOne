package demo.example.com.pandalive.ui.acctivity.Button1;

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

/**
 * Created by 郝可心 on 2017/12/22.
 * recycleview的适配器
 */

public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.ViewHouder> implements View.OnClickListener {
    private Context context;

    public RecycleviewAdapter(Context context, List<interaactionbean.InteractiveBean> interactive) {
        this.context = context;
        this.interactive = interactive;
    }

    private List<interaactionbean.InteractiveBean> interactive;


    @Override
    public ViewHouder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycleadapter, null);
        ViewHouder viewHouder = new ViewHouder(view);
        view.setOnClickListener(this);
        return viewHouder;
    }

    @Override
    public void onBindViewHolder(ViewHouder holder, int position) {
        holder.itemView.setTag(position);
        holder.Text_adapter.setText(interactive.get(position).getTitle());
        Glide.with(context).load(interactive.get(position).getImage()).into(holder.Image_adapter);

    }

    @Override
    public int getItemCount() {
        return interactive.isEmpty() ? 0 : interactive.size();
    }


    public interface name {
        void name1(View vi, int i);
    }


    public name name1 = null;
    @Override
    public void onClick(View v) {
        if (name1 != null) {
            name1.name1(v, (int) v.getTag());

        }
    }

    public void setName1(name lister) {
        this.name1 = lister;
    }

    class ViewHouder extends RecyclerView.ViewHolder {
        public ImageView Image_adapter;
        public TextView Text_adapter;

        public ViewHouder(View itemView) {
            super(itemView);
            Text_adapter = itemView.findViewById(R.id.Text_adapter);
            Image_adapter = itemView.findViewById(R.id.Image_adapter);
        }
    }
}
