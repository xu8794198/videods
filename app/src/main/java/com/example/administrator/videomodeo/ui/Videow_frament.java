package com.example.administrator.videomodeo.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.videomodeo.MainActivity;
import com.example.administrator.videomodeo.PlayVideo;
import com.example.administrator.videomodeo.R;
import com.example.administrator.videomodeo.entity.Bean;


/**
 * Created by Administrator on 2016/12/9.
 */
public class Videow_frament extends Fragment {
    MainActivity activity = (MainActivity) getActivity();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frament_one, container, false);
    }


}