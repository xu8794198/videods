package com.feicuiedu.videonews.videoplayer.full;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.feicuiedu.videonews.videoplayer.R;

import io.vov.vitamio.widget.MediaController;

/**
 * 作者：yuanchao on 2016/9/8 0008 14:44
 * 邮箱：yuanchao@feicuiedu.com
 */
public class CustorMediaController extends MediaController {

    private MediaPlayerControl mediaPlayerControl;//自定义视频控制器

    private final AudioManager audioManager;//音频管理
    private Window window;//视频亮度

    private final int maxVolume;//最大音量
    private int currentVolume;//当前音量
    private float currentBrightness;//当前亮度

    public CustorMediaController(Context context) {
        super(context);
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        window = ((Activity) context).getWindow();
    }

    // 通过重过此方法，来自定义layout
    @Override protected View makeControllerView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_custom_video_controller, this);
        initView(view);
        return view;
    }

    @Override public void setMediaPlayer(MediaPlayerControl player) {
        super.setMediaPlayer(player);
        mediaPlayerControl = player;
    }

    private void initView(View view) {
        // forward快进
        ImageButton btnFastForward = (ImageButton) view.findViewById(R.id.btnFastForward);
        btnFastForward.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                long postion = mediaPlayerControl.getCurrentPosition();
                postion += 10000;
                if (postion >= mediaPlayerControl.getDuration()) {
                    postion = mediaPlayerControl.getDuration();
                }
                mediaPlayerControl.seekTo(postion);
            }
        });
        // rewide
        ImageButton btnFastRewide = (ImageButton) view.findViewById(R.id.btnFastRewind);
        btnFastRewide.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                long postion = mediaPlayerControl.getCurrentPosition();
                postion -= 10000;
                if (postion < 0) postion = 0;
                mediaPlayerControl.seekTo(postion);
            }
        });
        // 调整视图(左边调整亮度,右边是音量)
        final View adjustView = view.findViewById(R.id.adjustView);
        //依赖GestureDetector来进行滑屏调整音量和亮度的手势处理
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                float startX = e1.getX();//开始的X轴
                float startY = e1.getY();//开始的Y轴
                float endX = e2.getX();//结束的X轴
                float endY = e2.getY();//结束的Y轴
                float width = adjustView.getWidth();//视图的宽
                float height = adjustView.getHeight();//视图的高
                float percentage = (startY - endY) / height;//高度滑动的百分比
                // 左侧: 亮度
                if (startX < width / 5) {
                    adjustbRrightness(percentage);//调整亮度
                }
                // 右侧: 音量
                else if (startX > width * 4 / 5) {
                    adjustVolume(percentage);//调整音量
                }
                return super.onScroll(e1, e2, distanceX, distanceY);
            }
        });
        // 对view进行touch监听
        // 但是，我们自己不去判读处理各种touch动用了,我们交给gesture去做
        adjustView.setOnTouchListener(new OnTouchListener() {
            @Override public boolean onTouch(View v, MotionEvent event) {
                if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
                    currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                    currentBrightness = window.getAttributes().screenBrightness;
                }
                gestureDetector.onTouchEvent(event);
                // 在调整过程中，一直显示
                show();
                return true;
            }
        });

    }

    //调整音量
    private void adjustVolume(float percentage) {
        //音量=最大音量*百分比+当前音量
        int volume = (int) ((percentage * maxVolume) + currentVolume);
        //如果音量大于最大音量，结果为最大音量
        volume = volume > maxVolume ? maxVolume : volume;
        //如果音量小于0，结果为0
        volume = volume < 0 ? 0 : volume;
        //设置音量
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, AudioManager.FLAG_SHOW_UI);
    }

    //调整亮度
    private void adjustbRrightness(float percentage) {
        //亮度=0.？+当前亮度0.？
        float brightness = percentage + currentBrightness;
        brightness = brightness > 1.0f ? 1.0f : brightness;
        brightness = brightness < 0 ? 0 : brightness;
        // 设置亮度
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.screenBrightness = brightness;
        window.setAttributes(layoutParams);
    }
}
