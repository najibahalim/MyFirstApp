package com.example.najib.manageapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> names=new ArrayList<>();
        final ArrayList<Project> list=new ArrayList<>(10);
        list.add(new Project("Sample"));
        names.add("Sample");

        //Spinner
        final Spinner s=(Spinner)findViewById(R.id.select);
        ArrayAdapter<String> data=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names);
        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(data);


        //Add Button
        Button add=(Button)findViewById(R.id.buttonAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText n1=(EditText)findViewById(R.id.editName);
                String n=n1.getText().toString();
                list.add(new Project(n));
                names.add(n);

            }
        });

        //Add Data
        Button get=(Button)findViewById(R.id.addData);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText kg=(EditText)findViewById(R.id.editTextData);
                int index=s.getSelectedItemPosition();
                Project px=list.get(index);
                px.kgs+=Integer.valueOf(kg.getText().toString());
                Toast.makeText(getApplicationContext(),"Operation Successful",Toast.LENGTH_SHORT).show();
            }
        });

        //Display Data
        Button put =(Button)findViewById(R.id.buttonDisplay);
        put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView op=(TextView)findViewById(R.id.textView4);
                int index=s.getSelectedItemPosition();
                Project px=list.get(index);
                op.setText(String.valueOf(px.kgs));



            }
        });








    }
}
