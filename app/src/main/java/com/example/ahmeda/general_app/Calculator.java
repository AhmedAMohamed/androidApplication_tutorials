package com.example.ahmeda.general_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    TextView result;
    EditText firstNum;
    EditText secondNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_activity);
        result = (TextView)findViewById(R.id.result);
        registerForContextMenu(result);
        firstNum = (EditText)findViewById(R.id.num_1_value);
        secondNum = (EditText)findViewById(R.id.num_2_value);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.result_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle().toString().contains("Mul"))
        {
            Toast.makeText(getApplicationContext(),"Mul", Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle().toString().contains("Add")) {
            Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle().toString().contains("Sub")) {
            Toast.makeText(getApplicationContext(), "Sub", Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle().toString().contains("Di")) {
            Toast.makeText(getApplicationContext(), "Di", Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }

    private void resultMainHandler() {
        if(Double.parseDouble(firstNum.getText().toString()) >= 0 || Double.parseDouble(firstNum.getText().toString()) <= 0) {

        }
        else {

        }
    }
}
