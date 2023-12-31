///*
//        fragment that implements view class functionality
//*/
//
//package com.example.msd_assignment;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.navigation.fragment.NavHostFragment;
//
//import com.example.msd_assignment.databinding.ModifyClassBinding;
//import com.example.msd_assignment.databinding.ViewClassBinding;
//
//public class ViewClass extends Fragment {
//
//    @Override
//    public View onCreateView(
//            LayoutInflater inflater, ViewGroup container,
//            Bundle savedInstanceState
//    ) {
//        View view = inflater.inflate(R.layout.add_class, container, false);
//
//        Button addButton = view.findViewById(R.id.add_class);
//        EditText classNameEditText = view.findViewById(R.id.names);
//
//        // retrieved from: https://www.tabnine.com/code/java/methods/android.widget.Button/setOnClickListener
//        // assign data to database
//        addButton.setOnClickListener(v ->{
//            // declare and assign attributes to be used in insert statement
//            String className = classNameEditText.getText().toString();
//
//            if (!className.isEmpty()){
//                // initialise new Class to use encapsulates
//                ClassEntity classEntity = new ClassEntity();
//                classEntity.setName(className);
//
//                // insert into database
//                ClassApplication.classDatabase.classDao().insertClass(classEntity);
//
//                Toast.makeText(requireContext(), "Class added to the database", Toast.LENGTH_LONG).show();
//            }
//            else{
//                Toast.makeText(requireContext(), "Please enter a class name", Toast.LENGTH_LONG).show();
//            }
//        });
//        return view;
//
//    }
//}

/*
fragment that implements add class functionality
 */

package com.example.msd_assignment;

import androidx.appcompat.app.AppCompatActivity.*;
import com.example.msd_assignment.databinding.AddClassBinding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.msd_assignment.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class ViewClass extends Fragment  {

    Button b;
    EditText classNameEditText1;

    AppCompatActivity appCompatActivity;

    AddClassBinding binding;

    ClassDatabase classDatabase;
    private ClassDao classDao;
    static ClassEntity c = new ClassEntity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        super.onCreate(savedInstanceState);
//        appCompatActivity = new AppCompatActivity();
//        appCompatActivity.setContentView(R.layout.add_class);
//
//        binding = AddClassBinding.inflate(getLayoutInflater());
//        appCompatActivity.setContentView(binding.getRoot());
//
//        RoomDatabase.Callback myCallBack = new RoomDatabase.Callback() {
//            @Override
//            public void onCreate(@NonNull SupportSQLiteDatabase db) {
//                super.onCreate(db);
//            }
//
//            @Override
//            public void onOpen(@NonNull SupportSQLiteDatabase db) {
//                super.onOpen(db);
//            }
//        };
//
//        classDatabase = Room.databaseBuilder(appCompatActivity.getApplicationContext(), ClassDatabase.class, "ClassDB")
//                .addCallback(myCallBack)
//                .allowMainThreadQueries()
//                .build();





        View v = inflater.inflate(R.layout.view_class, container, false);
//        EditText classNameEditText1 = v.findViewById(R.id.names1);
        //classNameEditText1 = v.findViewById(R.id.names1);
        // classNameEditText1.setText("CMPU2034");

//        Button b = (Button) v.findViewById(R.id.save_data);
        b = (Button) v.findViewById(R.id.view_class);

        //classDatabase = ClassDatabase.getInstance((getFragmentContext());

        //retrieved from: https://www.youtube.com/watch?v=ChD4GkS5Kds
        RoomDatabase.Callback myCallBack = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };

        //classDatabase = Room.databaseBuilder(Context, )

        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                b.setOnClickListener(v -> {

                    //Toast.makeText(requireContext(), "IN setOnClickListener", Toast.LENGTH_LONG).show();

                    Log.e("AddClass", "VIEWLINE1");

                    // declare and assign attributes to be used in insert statement
                    // String classCode = classNameEditText1.getText().toString();

                    Log.e("AddClass", "LINE2");

                    // initialise new Class to use encapsulates
                    //ClassEntity classEntity = new ClassEntity();

                    Log.e("AddClass", "LINE3");

                    // c.setCode(classCode);

                    Log.e("AddClass", "LINE4 - insert into database");

                    // insert into database
                    //ClassApplication.classDatabase.getClassDao().insertClass(classEntity);

//                    Intent intent = new Intent(this, MainActivity.class);
//                    intent.putExtra('my_key', 'My String');
                    //classDatabase.getClassDao().insertClass(c);

                    List<ClassEntity> classList = new ArrayList<>();

                    classList = MainActivity.viewDB();

                    Log.e("AddClass", "LINE5");

                    StringBuilder sb = new StringBuilder();
                    for(ClassEntity c : classList){
                        sb.append(c.getCode());
                        sb.append("\n");
                    }
                    String output = sb.toString();
                    Toast.makeText(requireContext(), output, Toast.LENGTH_LONG).show();

//                    if (!className.isEmpty()) {
//                        // initialise new Class to use encapsulates
//                        ClassEntity classEntity = new ClassEntity();
//                        classEntity.setName(className);
//
//                        // insert into database
//                        ClassApplication.classDatabase.classDao().insertClass(classEntity);
//
//                        Toast.makeText(requireContext(), "Class added to the database", Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(requireContext(), "Please enter a class name", Toast.LENGTH_LONG).show();
//                    }
                });
            }
        });
        return v;
    }


    //retrieved from: https://developer.android.com/reference/android/app/Fragment#onAttach(android.content.Context)
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//    }

//    private void sendDataToActivity(String data) {
//        Intent intent = new Intent(getActivity(), MyActivity.class);
//        intent.putExtra("KEY_DATA", data);
//        startActivity(intent);
//    }

//    @Override
//    public void onClick(View v1) {
//        b.setOnClickListener(v -> {
//
//        // declare and assign attributes to be used in insert statement
//            String className = classNameEditText1.getText().toString();
//
//            if (!className.isEmpty()) {
//                // initialise new Class to use encapsulates
//                ClassEntity classEntity = new ClassEntity();
//                classEntity.setName(className);
//
//                // insert into database
//                ClassApplication.classDatabase.classDao().insertClass(classEntity);
//
//                Toast.makeText(requireContext(), "Class added to the database", Toast.LENGTH_LONG).show();
//            } else {
//                Toast.makeText(requireContext(), "Please enter a class name", Toast.LENGTH_LONG).show();
//            }
//        });
//    }
}