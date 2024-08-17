package com.example.mumerali.asc.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mumerali.asc.R;


public class AboutCollege extends Fragment {

    View view;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.aboutcollege, container, false);



        return view;
    }
}

