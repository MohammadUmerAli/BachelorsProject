package com.example.mumerali.asc.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mumerali.asc.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Maps extends Fragment {

    PDFView pdfView;

    View view;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.maps, container, false);

        pdfView = (PDFView) view.findViewById(R.id.pdfView);
        pdfView.fromAsset("Drawing7.pdf").load();

        return view;
    }
}
