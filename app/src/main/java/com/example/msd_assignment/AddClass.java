package com.example.msd_assignment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.example.msd_assignment.databinding.AddClassBinding;

import java.util.ArrayList;

public class AddClass extends Fragment {

    private AddClassBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = AddClassBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // declare title of applictaion
        TextView textView = view.findViewById(R.id.textview_first);
        // textView.setText("AbhiAndroid"); //set text for text view

        // declare buttons in main page
        Button addButton = view.findViewById(R.id.add_class);

        if (addButton != null) {
            addButton.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public void onClick(View it) {
                    // dis
                    // playing a toast message - using requireContext() instead of typecasting Context
                    Toast.makeText(requireContext(), "You just clicked on Add Button", Toast.LENGTH_LONG).show();
//                    NavHostFragment.findNavController(AddClass.this)
//                            .navigate(R.id.action_AddClass_to_DeleteClass);
                }
            }));
        }

        EditText classCode = (EditText) view.findViewById(R.id.names);
        String output = classCode.getText().toString();
        Toast.makeText(requireContext(), output, Toast.LENGTH_LONG).show();

        binding.addClass.setOnClickListener(new View.OnClickListener() {

            @Override // when button is clicked
            public void onClick(View view) {
                Toast.makeText(requireContext(), "You just clicked on Add Button", Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}