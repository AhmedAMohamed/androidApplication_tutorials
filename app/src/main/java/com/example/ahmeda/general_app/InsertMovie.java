package com.example.ahmeda.general_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class InsertMovie extends AppCompatActivity {

    EditText name;
    EditText desc;
    Button add;
    Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        name = (EditText)findViewById(R.id.name_value);
        desc = (EditText)findViewById(R.id.desc_value);
        add = (Button)findViewById(R.id.add_button_m);
        show = (Button)findViewById(R.id.show_button_m);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler db = new DBHandler(getApplicationContext());
                ArrayList<String> values = new ArrayList<String>();
                values.add(name.getText().toString());
                values.add(desc.getText().toString());
                db.insertCol(values);
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showMovieIntent = new Intent(InsertMovie.this, ShowList.class);
                startActivity(showMovieIntent);
            }
        });

    }

}
