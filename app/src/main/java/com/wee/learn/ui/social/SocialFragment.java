package com.wee.learn.ui.social;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.wee.learn.R;
import com.wee.learn.model.user.instructor.Instructor;
import com.wee.learn.model.user.instructor.InstructorData;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SocialFragment extends Fragment {

    private static final String TAG = "Social Fragment" ;
    InstructorData instructorData = new InstructorData();

    Instructor instructor = new Instructor();

    private SocialViewModel socialViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        socialViewModel = new ViewModelProvider(this).get(SocialViewModel.class);
        View root = inflater.inflate(R.layout.fragment_social, container, false);

        final TextView textView = root.findViewById(R.id.social);
        final EditText first = root.findViewById(R.id.firstname);
        final EditText last = root.findViewById(R.id.lastname);
        final EditText email = root.findViewById(R.id.email);

        final Button write = root.findViewById(R.id.button);

        Map<String,Object> map = new HashMap<>();
        map.put("email", email.getText().toString());
        map.put("first_name",first.getText().toString());
        map.put("last_name",last.getText().toString());
        map.put("profile_picture","##############$$$$$$$$$$#################");

        write.setOnClickListener(v -> {
            instructorData.write(new Instructor(map));
            Toast.makeText(getContext(),"New data has been added to firebase database",Toast.LENGTH_SHORT).show();
        });

        socialViewModel.getText().observe(getViewLifecycleOwner(), s ->
                textView.setText(s));
        return root;
    }
}