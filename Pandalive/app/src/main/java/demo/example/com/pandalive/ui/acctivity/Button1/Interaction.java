package demo.example.com.pandalive.ui.acctivity.Button1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import demo.example.com.pandalive.ui.acctivity.Button1.Retrofit.inter;
import demo.example.com.pandalive.ui.acctivity.Button1.Retrofit.interfase;
import demo.example.com.pandalive.R;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

//解析第一个button的recycleview的解析
public class Interaction extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView RecyleView_interaction;
    private RecycleviewAdapter recycleviewAdapter;
    private List<interaactionbean.InteractiveBean> interactive = new ArrayList<>();


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction);
        initView();
        initdata();
    }

    private void initdata() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(inter.URL_one)
                .build();
        interfase interfase = retrofit.create(interfase.class);
        Call<ResponseBody> url = interfase.getURL();
        url.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    interaactionbean interaactionbean = JSON.parseObject(string, interaactionbean.class);

                    interactive = interaactionbean.getInteractive();
                    for (int i = 0; i < interactive.size(); i++) {
                        LinearLayoutManager lin = new LinearLayoutManager(Interaction.this);
                        RecyleView_interaction.setLayoutManager(lin);
                        recycleviewAdapter = new RecycleviewAdapter(Interaction.this, interactive);
                        RecyleView_interaction.setAdapter(recycleviewAdapter);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                /**
                 * 解析recycleview   利用接口回调的方式把url  用Intent传过去到列一个页面
                 */
                recycleviewAdapter.setName1(new RecycleviewAdapter.name() {
                    @Override
                    public void name1(View vi, int i) {
                        Intent intent = new Intent(Interaction.this, Webview.class);
                        intent.putExtra("name", interactive.get(i).getUrl());
                        startActivity(intent);

                    }
                });


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }

    private void initView() {
        RecyleView_interaction = (RecyclerView) findViewById(R.id.RecyleView_interaction);
    }

    @Override
    public void onClick(View v) {

    }
}
