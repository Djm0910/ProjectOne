package demo.example.com.pandalive.ui.acctivity.Button2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import demo.example.com.pandalive.R;
import demo.example.com.pandalive.ui.acctivity.MainActivity;


public class Login extends AppCompatActivity {


    private ImageView imageview_personal_back1;

    private RelativeLayout big_1;
    private RelativeLayout big_2;
    private RelativeLayout big_3;
    private RelativeLayout big_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_anay);
        initView();//获取控件
        initClik();//点击事件  点击每一个item跳转页面

    }

    private void initClik() {
        imageview_personal_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回就返回到主页面
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });
        big_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录设置页面跳转到登录的详情页面
                Intent intent = new Intent(Login.this, Login_One.class);
                startActivity(intent);
            }
        });
        big_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录设置页面跳转到观看历史的页面
                Intent intent1 = new Intent(Login.this, Login_Two.class);
                startActivity(intent1);
            }
        });
        big_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录设置页面跳转到收藏的页面
                Intent intent = new Intent(Login.this, Login_Threee.class);
                startActivity(intent);
            }
        });
        big_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录设置页面跳转到设置的页面
                Intent intent = new Intent(Login.this, Login_Four.class);
                startActivity(intent);
            }
        });


    }

    private void initView() {


        imageview_personal_back1 = (ImageView) findViewById(R.id.imageview_personal_back1);
        big_1 = (RelativeLayout) findViewById(R.id.big_1);
        big_2 = (RelativeLayout) findViewById(R.id.big_2);
        big_3 = (RelativeLayout) findViewById(R.id.big_3);
        big_4 = (RelativeLayout) findViewById(R.id.big_4);

    }

}
