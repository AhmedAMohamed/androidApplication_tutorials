package com.example.ahmeda.general_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class USDollarConverter extends AppCompatActivity {

    Button convert;
    EditText egText;
    EditText usText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);
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
        convert = (Button)findViewById(R.id.convertButton);
        egText = (EditText)findViewById(R.id.egTextValue);
        usText = (EditText)findViewById(R.id.usTextValue);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (egText.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Input Egyptian pounds first", Toast.LENGTH_LONG).show();
                }
                else {
                    double egVal = Double.parseDouble(egText.getText().toString());
                    double usVal = 10*egVal;
                    usText.setText("" + usVal);
                }
            }
        });
        registerForContextMenu(convert);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        convert.setText(item.getTitle().toString());
        return super.onContextItemSelected(item);
    }
}
