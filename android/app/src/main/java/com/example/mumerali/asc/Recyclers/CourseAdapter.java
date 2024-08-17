package com.example.mumerali.asc.Recyclers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mumerali.asc.R;
import com.example.mumerali.asc.Retrofit.Models.CoursesOffered;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter <CourseAdapter.MyViewHolder> {


    private List<CoursesOffered> coursesOffered;
    private Context context;


    public CourseAdapter(List<CoursesOffered> coursesOffered, Context context)
    {
        this.coursesOffered = coursesOffered;
        this.context = context;
    }

    @Override
    public CourseAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_courses,parent,false);

        return new CourseAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CourseAdapter.MyViewHolder holder, final int position) {

        holder.Programme.setText(coursesOffered.get(position).getProgramme());
        holder.Eligibility_Criteria.setText(coursesOffered.get(position).getEligibility_Criteria());

    }

    @Override
    public int getItemCount() {
        return coursesOffered.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView Eligibility_Criteria,Programme;

        public MyViewHolder(View itemView) {
            super(itemView);

            Programme = (TextView) itemView.findViewById(R.id.Programme);
            Eligibility_Criteria = (TextView) itemView.findViewById(R.id.Eligibility_Criteria);

        }
    }
}






