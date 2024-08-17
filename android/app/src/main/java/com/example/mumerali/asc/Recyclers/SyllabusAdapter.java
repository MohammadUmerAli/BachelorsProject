package com.example.mumerali.asc.Recyclers;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mumerali.asc.R;
import com.example.mumerali.asc.Retrofit.Models.Files;

import java.util.List;


public class SyllabusAdapter extends RecyclerView.Adapter <SyllabusAdapter.MyViewHolder> {

    private List<Files> files;
    private Context context;
    DownloadManager downloadManager;


    public SyllabusAdapter(List<Files> files, Context context)
    {
        this.files = files;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_syllabus,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        final String[] file_url = new String[1];
        holder.file_name.setText(files.get(position).getFile_name());
        holder.file_size.setText(files.get(position).getFile_size());
        holder.downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        file_url[0] = (String) files.get(position).getFile_url();
        downloadManager = (DownloadManager) context.getSystemService(context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(file_url[0]);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        Long reference = downloadManager.enqueue(request);


            }
        });
    }

    @Override
    public int getItemCount() {
        return files.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView file_name,file_size;
        ImageButton downloadButton;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView =(ImageView) itemView.findViewById(R.id.imageView);
            file_name = (TextView) itemView.findViewById(R.id.file_name);
            file_size = (TextView) itemView.findViewById(R.id.file_size);
            downloadButton = (ImageButton) itemView.findViewById(R.id.downloadButton);
        }
    }
}
