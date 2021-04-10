package com.wee.learn.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.wee.learn.R;
import com.wee.learn.model.user.instructor.Instructor;
import com.wee.learn.model.user.instructor.InstructorData;

import java.util.LinkedList;
import java.util.Map;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private InstructorData instructorData = new InstructorData();
    private LinkedList<Map<String,Object>> list = new LinkedList<>();
    private Instructor instructor = new Instructor();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        final TextView textView = root.findViewById(R.id.text_dashboard);
        final Button read = root.findViewById(R.id.button2);
        final TextView newTextview = root.findViewById(R.id.textView);

        read.setOnClickListener(v -> {

            list = instructorData.read();



            newTextview.setText(
                    "" //+ instructor.toString()
            );
        });

        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}