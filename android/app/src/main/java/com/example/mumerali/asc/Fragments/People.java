package com.example.mumerali.asc.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.mumerali.asc.Activities.PeopleActivity;
import com.example.mumerali.asc.R;

public class People extends Fragment {

    Spinner departmentSpin;
    String department;
    String departments[] = {"Select Department","Principal", "Arabic", "Botany", "Chemistry", "Chief Librarian", "Commerce", "Computer Application", "Economics", "Education", "Engineering", "English", "Env. Science", "Functional English", "Geography", "Geology", "Hindi", "History", "Islamic Studies", "Kashmiri", "Mathematics", "Philosophy", "Physics", "Political Science", "Psychology", "PTI", "Sociology", "Statistics", "Tourism", "Urdu", "Zoology" };




    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.people, container, false);


        departmentSpin = (Spinner) view.findViewById(R.id.departmentSpin);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, departments);
        departmentSpin.setAdapter(arrayAdapter);

        departmentSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {
                    if(isOnline())
                    {
                        String Selected = adapterView.getItemAtPosition(i).toString();
                        department = Selected;

                        Intent intent = new Intent(getActivity(), PeopleActivity.class);
                        intent.putExtra("department",department);
                        startActivity(intent);

                    }
                    else Toast.makeText(getActivity(),"No Internet",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }

    public boolean isOnline() {

        ConnectivityManager cm =
                (ConnectivityManager)getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

}