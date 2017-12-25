package demo.example.com.pandalive.ui.acctivity;

import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;


import demo.example.com.pandalive.R;
import demo.example.com.pandalive.base.BaseActivity;
import demo.example.com.pandalive.net.NetContract;
import demo.example.com.pandalive.net.NetModel;
import demo.example.com.pandalive.net.NetPresenter;

/**
 * Created by 丁军明 on 2017/12/24.
 */

public class VideoActivity extends BaseActivity<NetPresenter, NetModel> implements NetContract.View {
    @Override
    public void show(String ss, String type) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_video);
        VideoView videoView = (VideoView) findViewById(R.id.videossss);

        // 指定需要播放的视频的地址
        videoView.setVideoURI(Uri.parse("http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/14/bfe0d8eaad33462d8a6346820100f91b_h264818000nero_aac32.mp4"));

        // 设置播放器的控制条
        videoView.setMediaController(new MediaController(this));
        // 开始播放视频
        videoView.start();
    }


}
