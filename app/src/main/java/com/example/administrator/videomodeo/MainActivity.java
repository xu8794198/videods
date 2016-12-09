package com.example.administrator.videomodeo;


import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.videomodeo.entity.Bean;
import com.example.administrator.videomodeo.entity.Url;
import com.example.administrator.videomodeo.ui.Videob_frament;
import com.example.administrator.videomodeo.ui.Videodown_frament;
import com.example.administrator.videomodeo.ui.Videow_frament;
import com.google.gson.Gson;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private TextView  title_tv;
    private ViewPager viewPager;
    private Button bt_1,bt_2,bt_3;
   // private Button bt;

    private FragmentPagerAdapter adapter;
    private List<Fragment> datas;

    private Bean b;


    //接口
    public static String url = Url.IP+"appInterface/testInterface.ashx?action=movieDetail&paras=9|0|0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
  //      bt= (Button) findViewById(R.id.btnNews);
  //      bt.setOnClickListener(new View.OnClickListener() {
  //          @Override
   //
   //         public void onClick(View v) {
      //          Intent intent=new Intent(MainActivity.this,PlayVideo.class);
        //        intent.putExtra("url_key",b.getMsg().getItemUrl());
          //      startActivity(intent);
//            }

     //   });
        //创建RequestQueue对象
        RequestQueue mQueue = Volley.newRequestQueue(this);
        //创建StringRequest
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //成功
                Log.d("TAG", response);
                //获取数据，Gson解析
                Gson gson = new Gson();
                b = gson.fromJson(response,Bean.class);
              //  b.getMsg().getItemUrl();
                // Log.d("TAG", b.getMsg().getFmPic() + b.getMsg().getName());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //失败
                Log.d("TAG", error.getMessage(), error);
            }
        });
        //把请求添加到队列
        mQueue.add(stringRequest);
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        bt_1 = (Button) findViewById(R.id.btnNews);
        bt_2 = (Button) findViewById(R.id.btnLocal);
        bt_3 = (Button) findViewById(R.id.btnLikes);

        title_tv= (TextView) findViewById(R.id.tv_title);

        //为viewpager添加数据
        datas = new ArrayList<Fragment>();
        //初始化三个Fragment
        Videow_frament top_1 = new Videow_frament();
        Videob_frament top_2 = new Videob_frament();
        Videodown_frament top_3 = new Videodown_frament();

        //开始添加数据
        datas.add(top_1);
        datas.add(top_2);
        datas.add(top_3);

        //初始化适配器
        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return datas.size();
            }

            @Override
            public Fragment getItem(int position) {
                return datas.get(position);
            }
        };
        //给ViewPager添加滑动时间
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetTextView();
                switch (position) {
                    case 0:
                        bt_1.setTextColor(Color.GREEN);
                        //改变toopbar文本
                        title_tv.setText(R.string.online_news);
                        break;
                    case 1:
                        bt_2.setTextColor(Color.GREEN);
                        title_tv.setText(R.string.local_video);
                        break;
                    case 2:
                        bt_3.setTextColor(Color.GREEN);
                        title_tv.setText(R.string.likes);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
  //点击事件
    public void onClick(View view){
//        FragmentManager fm =activity getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.btnNews:
                viewPager.setCurrentItem(0,false);
                break;
            case R.id.btnLocal:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.btnLikes:
                viewPager.setCurrentItem(2,false);
                break;
            case R.id.pic_one:
                Intent intent=new Intent(MainActivity.this,PlayVideo.class);
                intent.putExtra("url_key",b.getMsg().getItemUrl());
                startActivity(intent);
                break;




        }

    }

    private void resetTextView() {
        //滑动改变字体
            bt_1.setTextColor(Color.BLACK);
            bt_2.setTextColor(Color.BLACK);
            bt_3.setTextColor(Color.BLACK);
    }
}