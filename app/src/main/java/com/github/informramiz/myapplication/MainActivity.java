package com.github.informramiz.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.github.informramiz.daypickerlibrary.views.PickerDialog;
import com.github.informramiz.daypickerlibrary.views.PickerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDayPickerDialog();
            }
        });

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });
    }

    void showDayPickerDialog() {
        ArrayList<Integer> selected = new ArrayList<Integer>();
        selected.add(1); selected.add(4); selected.add(5); selected.add(3);
        PickerDialog.Builder builder = new PickerDialog.Builder(this)
                .setWeeks(16, 2)
                .setInitialSelectedWeeks(selected)
                .setOnWeeksSelectedListener(new PickerDialog.OnWeeksSelectedListener() {
                    @Override
                    public void onWeeksSelected(PickerView dayPickerView, ArrayList<Integer> selectedWeeks) {
                        String text = "Selected Week ";
                        for(Integer week:selectedWeeks) {
                            text = text + week + " ";
                        }
                        TextView theview = findViewById(R.id.textView);
                        theview.setText(text);
                        //Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show();
                    }
                })
                ;
        builder.show();
    }

    void showTimePicker() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, null, 0, 0, false);
        timePickerDialog.show();
    }

    void showDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, null, 0, 0, 0);
        datePickerDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
