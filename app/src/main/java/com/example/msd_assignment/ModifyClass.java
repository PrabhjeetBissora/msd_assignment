/*
        fragment that implements modify class functionality
*/
package com.example.msd_assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.msd_assignment.databinding.ModifyClassBinding;

public class ModifyClass extends Fragment {


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.add_class, container, false);

        Button addButton = view.findViewById(R.id.add_class);
        EditText classNameEditText = view.findViewById(R.id.names);

        // retrieved from: https://www.tabnine.com/code/java/methods/android.widget.Button/setOnClickListener
        // assign data to database
        addButton.setOnClickListener(v ->{
            // declare and assign attributes to be used in insert statement
            String className = classNameEditText.getText().toString();

            if (!className.isEmpty()){
                // initialise new Class to use encapsulates
                ClassEntity classEntity = new ClassEntity();
                classEntity.setName(className);

                // insert into database
                ClassApplication.classDatabase.classDao().insertClass(classEntity);

                Toast.makeText(requireContext(), "Class added to the database", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(requireContext(), "Please enter a class name", Toast.LENGTH_LONG).show();
            }
        });
        return view;

    }
}