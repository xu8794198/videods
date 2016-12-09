package com.example.administrator.videomodeo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.administrator.videomodeo.entity.Url;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * 测试播放
 * Created by Administrator on 2016/12/8.
 */
public class PlayVideo extends Activity {
    private VideoView mVideoView;
    private MediaController mMediaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!io.vov.vitamio.LibsChecker.checkVitamioLibs(this))
            return;
        setContentView(R.layout.play_1);
        Intent intent = getIntent();
        String path = intent.getStringExtra("url_key");
        mVideoView = (VideoView) findViewById(R.id.surface_view);
        mVideoView.setVideoPath(Url.IP+path);//设置播放地址
        mMediaController = new MediaController(this);//实例化控制器
        mMediaController.show(5000);//控制器显示5s后自动隐藏
        mVideoView.setMediaController(mMediaController);//绑定控制器
        mVideoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);//设置播放画质 高画质
        mVideoView.requestFocus();//取得焦点

    }
}