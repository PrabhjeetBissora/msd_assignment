/*
fragment that implements add class functionality
 */

package com.example.msd_assignment;

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

import com.example.msd_assignment.databinding.AddClassBinding;

public class AddClass extends Fragment {

    private AddClassBinding binding;

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

//        binding = AddClassBinding.inflate(inflater, container, false);
//        return binding.getRoot();

    }

//    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        // declare title of applictaion
//        TextView textView = view.findViewById(R.id.textview_first);
//        // textView.setText("AbhiAndroid"); //set text for text view
//
//        // declare buttons in main page
//        Button addButton = view.findViewById(R.id.add_class);
//
//        if (addButton != null) {
//            addButton.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
//                public void onClick(View it) {
//                    // display button
//                    // playing a toast message - using requireContext() instead of typecasting Context
//                    Toast.makeText(requireContext(), "You just clicked on Add Button", Toast.LENGTH_LONG).show();
////                    NavHostFragment.findNavController(AddClass.this)
////                            .navigate(R.id.action_AddClass_to_DeleteClass);
//                }
//            }));
//        }
//
//        EditText classCode = (EditText) view.findViewById(R.id.names);
//        String output = classCode.getText().toString();
//        Toast.makeText(requireContext(), output, Toast.LENGTH_LONG).show();
//
//        binding.addClass.setOnClickListener(new View.OnClickListener() {
//
//            @Override // when button is clicked
//            public void onClick(View view) {
//                Toast.makeText(requireContext(), "You just clicked on Add Button", Toast.LENGTH_LONG).show();
//
//            }
//        });
//
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }

}