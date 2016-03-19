package com.example.ahmeda.general_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle().toString().contains("Mul"))
        {
            if(item.getItemId() == R.id.mul_sub_item_menu_1) {
                resultMainHandler("mul2");
            }
            else {
                resultMainHandler("mul3");
            }
            Toast.makeText(getApplicationContext(),"Mul", Toast.LENGTH_SHORT).show();
        }
        else if(item.getTitle().toString().contains("Add")) {
            resultMainHandler("add");
            Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_SHORT).show();
        }
        else if(item.getTitle().toString().contains("Sub")) {
            resultMainHandler("sub");
            Toast.makeText(getApplicationContext(), "Sub", Toast.LENGTH_SHORT).show();
        }
        else if(item.getTitle().toString().contains("Di")) {
            resultMainHandler("div");
            Toast.makeText(getApplicationContext(), "Di", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.action_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle().toString().contains("Mul"))
        {

            Toast.makeText(getApplicationContext(),"Mul", Toast.LENGTH_SHORT).show();
        }
        else if(item.getTitle().toString().contains("Add")) {
            Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_SHORT).show();
        }
        else if(item.getTitle().toString().contains("Sub")) {
            Toast.makeText(getApplicationContext(), "Sub", Toast.LENGTH_SHORT).show();
        }
        else if(item.getTitle().toString().contains("Di")) {
            Toast.makeText(getApplicationContext(), "Di", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    private void resultMainHandler(String op) {
        if(Double.parseDouble(firstNum.getText().toString()) >= 0 || Double.parseDouble(firstNum.getText().toString()) <= 0) {
            if(Double.parseDouble(secondNum.getText().toString()) >= 0 || Double.parseDouble(secondNum.getText().toString()) <= 0) {
                if(op == "mul2") {
                    result.setText(Double.parseDouble(firstNum.getText().toString()) * Double.parseDouble(secondNum.getText().toString()) * 2 + " ");
                }
                if(op == "mul3") {
                    result.setText(Double.parseDouble(firstNum.getText().toString()) * Double.parseDouble(secondNum.getText().toString()) * 3 + " ");
                }
                if(op == "add") {
                    result.setText(Double.parseDouble(firstNum.getText().toString()) + Double.parseDouble(secondNum.getText().toString())+ " ");
                }
                if(op == "sub") {
                    result.setText(Double.parseDouble(firstNum.getText().toString()) - Double.parseDouble(secondNum.getText().toString()) + " ");
                }
                if(op == "div") {
                    result.setText(Double.parseDouble(firstNum.getText().toString()) / Double.parseDouble(secondNum.getText().toString())  + " ");
                }
            }
            else {

            }
        }
        else {

        }
    }
}
