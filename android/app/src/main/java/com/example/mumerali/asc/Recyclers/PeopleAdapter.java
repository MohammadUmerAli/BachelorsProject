package com.example.mumerali.asc.Recyclers;


import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mumerali.asc.R;
import com.example.mumerali.asc.Retrofit.Models.Profiles;
import com.squareup.picasso.Picasso;

import java.util.List;


public class PeopleAdapter extends RecyclerView.Adapter <PeopleAdapter.MyViewHolder> {

    private List<Profiles> profiles;
    private Context context;


    public PeopleAdapter(List<Profiles> profiles, Context context)
    {
        this.profiles = profiles;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_people,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.teacher_name.setText(profiles.get(position).getTeacher_name());
        holder.teacher_qualification.setText(profiles.get(position).getTeacher_qualification());
        holder.teacher_email.setText(profiles.get(position).getTeacher_email());
        holder.position_held.setText(profiles.get(position).getPosition_held());
        Picasso.get().setLoggingEnabled(true);
        Picasso.get().load(profiles.get(position).getImage_url()).placeholder(R.drawable.placeholder).fit().into(holder.imageViewPic);
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView teacher_name,teacher_qualification,teacher_email,position_held;
        ImageView imageViewPic;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageViewPic =(ImageView) itemView.findViewById(R.id.imageViewPic);
            teacher_name = (TextView) itemView.findViewById(R.id.teacher_name);
            teacher_qualification = (TextView) itemView.findViewById(R.id.teacher_qualification);
            teacher_email = (TextView) itemView.findViewById(R.id.teacher_email);
            position_held = (TextView) itemView.findViewById(R.id.position_held);

        }
    }
}
