package com.wee.learn.model.user.instructor;


import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class InstructorData {

    private String TAG = "InstructorData File";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private LinkedList<Map<String, Object>> instructors = new LinkedList<>();


    public InstructorData()
    {
    }
    public LinkedList<Map<String, Object>> read()
    {
        db.collection("user").document("WoW4mXdA8bBB0SHAgwdW").collection("instructor")
                .get()
                .addOnCompleteListener(task -> {
                    LinkedList<Map<String,Object> > list = new LinkedList<>();
                    if (task.isSuccessful()) {


                        for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {

                            Log.d(TAG, document.getId() + " => " + document.getData().toString());

                            list.add(document.getData());
                        }
                    }
                    else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                    }
                    instructors.addAll(list);
                });

        return instructors;

    }

    public void write(Instructor inst) {
        // Create a new user with a first and last name
        Map<String, String> instructor = new HashMap<>();
        instructor.put("first_name", inst.getFirst_name());
        instructor.put("last_name", inst.getLast_name());
        instructor.put("email", inst.getEmail());
        instructor.put("profile_picture", inst.getProfile_picture());


        // Add a new document with a generated ID
        db.collection("user").document("WoW4mXdA8bBB0SHAgwdW").collection("instructor")
                .add(instructor)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);


                    }
                });

    }



}
