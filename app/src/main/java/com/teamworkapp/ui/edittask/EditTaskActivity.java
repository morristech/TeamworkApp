package com.teamworkapp.ui.edittask;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.SeekBar;
import android.widget.TextView;

import com.teamworkapp.R;

import java.util.Calendar;


public class EditTaskActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView seekbarPercentage;

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView startDate;
    private TextView dueDate;

    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        //showDate(year, month+1, day);


        startDate = (TextView) findViewById(R.id.start_date);
        dueDate = (TextView) findViewById(R.id.due_date);

        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.notify_switch);
        seekbarPercentage = (TextView) findViewById(R.id.seekbar_percentage);


        seekBar = (SeekBar) findViewById(R.id.progress_seekbar );
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarPercentage.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }



    @SuppressWarnings("deprecation")
    public void setStartDate(View view) {
        showDialog(999);
    }

    @SuppressWarnings("deprecation")
    public void setDueDate(View view) {
        showDialog(888);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    startDateListener, year, month, day);
        }
        if (id == 888) {
            return new DatePickerDialog(this,
                    dueDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener startDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showStartDate(arg1, arg2+1, arg3);
                }
            };


    private DatePickerDialog.OnDateSetListener dueDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDueDate(arg1, arg2+1, arg3);
                }
            };

    private void showStartDate(int year, int month, int day) {
        startDate.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    private void showDueDate(int year, int month, int day) {
        dueDate.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


    public void saveTask() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit_task_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_edit_task:
                saveTask();
        }
        return super.onOptionsItemSelected(item);
    }

}