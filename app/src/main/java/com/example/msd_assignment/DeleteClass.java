/*
fragment that implements add class functionality
 */

package com.example.msd_assignment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class DeleteClass extends Fragment {

    Button b;
    EditText classNameEditText1;
    EditText classNameEditText2;
    EditText classNameEditText3;
    EditText classNameEditText4;
    EditText classNameEditText5;
    EditText classNameEditText6;
    EditText classNameEditText7;

    static ClassEntity c = new ClassEntity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.add_class, container, false);

        classNameEditText1 = v.findViewById(R.id.names1);
        classNameEditText2 = v.findViewById(R.id.names2);
        classNameEditText3 = v.findViewById(R.id.names3);
        classNameEditText4 = v.findViewById(R.id.names4);
        classNameEditText5 = v.findViewById(R.id.names5);
        classNameEditText6 = v.findViewById(R.id.names6);
        classNameEditText7 = v.findViewById(R.id.names7);
        // classNameEditText1.setText("CMPU2034");


        b = (Button) v.findViewById(R.id.save_data);

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

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                b.setOnClickListener(v -> {

                    Log.e("AddClass", "LINE1");

                    // declare and assign attributes to be used in insert statement
                    String classCode = classNameEditText1.getText().toString();
                    String className = classNameEditText2.getText().toString();
                    String classType = classNameEditText3.getText().toString();
                    String location = classNameEditText4.getText().toString();
                    String date = classNameEditText5.getText().toString();
                    String startTime = classNameEditText6.getText().toString();
                    String endTime = classNameEditText7.getText().toString();

                    Log.e("AddClass", "LINE2");

                    Log.e("AddClass", "LINE3");

                    // set class c variables
                    c.setCode(classCode);
                    c.setName(className);
                    c.setType(classType);
                    c.setLocation(location);
                    c.setDate(date);
                    c.setStartTime(startTime);
                    c.setEndTime(endTime);

                    Log.e("AddClass", "LINE4 - insert into database");

                    MainActivity.insertIntoDB(c);

                    Log.e("AddClass", "LINE5");

                });
            }
        });
        return v;
    }
}