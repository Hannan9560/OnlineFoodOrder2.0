package com.brishty.onlinefoodorder;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder customAddressDialog;
    private String HouseNumber, RoadNumber, PoliceStation, ZipCode;

    ArrayList<String> selection = new ArrayList<String>();
    private  String payment;
    private String location;
    private Spinner mSpinner;
    private int Year, Month, Day, Hour, Minute;
    private int y, m, d, h, mi;
    private Button mSubmit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSpinner = (Spinner) findViewById(R.id.myArea);
        mSubmit = (Button) findViewById(R.id.submit);

        customAddressDialog = new AlertDialog.Builder(this);

        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this,R.array.area_name
        ,android.R.layout.simple_spinner_item);

        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                location  = mSpinner.getSelectedItem().toString();

                //Toast.makeText(MainActivity.this, location, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void selectFood(View view) {
        switch (view.getId()){
            case R.id.chk_chicken:
                if(((CheckBox)view).isChecked()){
                    selection.add(((CheckBox)view).getText().toString());
                }
                else {
                    selection.remove(((CheckBox)view).getText().toString());
                }
                break;
            case R.id.chk_Pizza:
                if(((CheckBox)view).isChecked()){
                    selection.add(((CheckBox)view).getText().toString());
                }
                else {
                    selection.remove(((CheckBox)view).getText().toString());
                }
                break;
            case R.id.chk_beef:
                if(((CheckBox)view).isChecked()){
                    selection.add(((CheckBox)view).getText().toString());
                }
                else {
                    selection.remove(((CheckBox)view).getText().toString());
                }
                break;
            case R.id.chk_Biriany:
                if(((CheckBox)view).isChecked()){
                    selection.add(((CheckBox)view).getText().toString());
                }
                else {
                    selection.remove(((CheckBox)view).getText().toString());
                }
                break;
            case R.id.chk_drinks:
                if(((CheckBox)view).isChecked()){
                    selection.add(((CheckBox)view).getText().toString());
                }
                else {
                    selection.remove(((CheckBox)view).getText().toString());
                }
                break;
            case R.id.chk_beefbiriany:
                if(((CheckBox)view).isChecked()){
                    selection.add(((CheckBox)view).getText().toString());
                }
                else {
                    selection.remove(((CheckBox)view).getText().toString());
                }
                break;
            case R.id.chk_jouce:
                if(((CheckBox)view).isChecked()){
                    selection.add(((CheckBox)view).getText().toString());
                }
                else {
                    selection.remove(((CheckBox)view).getText().toString());
                }
                break;
            case R.id.chk_noodls:
                if(((CheckBox)view).isChecked()){
                    selection.add(((CheckBox)view).getText().toString());
                }
                else {
                    selection.remove(((CheckBox)view).getText().toString());
                }
                break;
            case R.id.chk_tehari:
                if(((CheckBox)view).isChecked()){
                    selection.add(((CheckBox)view).getText().toString());
                }
                else {
                    selection.remove(((CheckBox)view).getText().toString());
                }
                break;
        }
    }

    public void selectpayment(View view) {
        switch (view.getId()){
            case R.id.Cash_on_Delivery:
                if(((RadioButton)view).isChecked()){
                    payment = ((RadioButton)view).getText().toString();
                    /*Toast.makeText(this, ((RadioButton)view).getText().toString(), Toast.LENGTH_SHORT).show();*/
                }
                break;
            case R.id.online:
                if(((RadioButton)view).isChecked()){
                    payment = ((RadioButton)view).getText().toString();
                    /*Toast.makeText(this, ((RadioButton)view).getText().toString(), Toast.LENGTH_SHORT).show();*/
                }
                break;
        }
    }

    public void setdate(View view) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        Year = calendar.get(Calendar.YEAR);
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(this, dateListener, Year, Month, Day);
        dpd.show();
    }
    private DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            y = year;
            m = month;
            d = day;
            /*Toast.makeText(MainActivity.this, "Year: "+year, Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, "Month: "+(month+1), Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, "Day: "+day, Toast.LENGTH_SHORT).show();*/
        }
    };

    public void settime(View view) {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        Hour = calendar.get(Calendar.HOUR);
        Minute = calendar.get(Calendar.MINUTE);


        TimePickerDialog tpd = new TimePickerDialog(this, timeListener, Hour, Minute, true);
        tpd.show();
    }
    private TimePickerDialog.OnTimeSetListener timeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minute) {
            h = hour;
            mi = minute;

           /* Toast.makeText(MainActivity.this, "Hour: "+ hour, Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, "Minute: "+ minute, Toast.LENGTH_SHORT).show();*/
        }
    };


    public void setAddress(View view) {
        //Custom Layout Dialog Box;
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.address_layout,null);
        final EditText houseNumber = (EditText) v.findViewById(R.id.houseName);
        final EditText roadNumber = (EditText) v.findViewById(R.id.roadNumber);
        final EditText policeStation = (EditText) v.findViewById(R.id.policeSta);
        final EditText zipCode = (EditText) v.findViewById(R.id.zipCode);

        customAddressDialog.setTitle("Delivery Address");
        customAddressDialog.setIcon(R.drawable.delivery);
        customAddressDialog.setView(v);
        customAddressDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                HouseNumber = houseNumber.getText().toString();
                RoadNumber = roadNumber.getText().toString();
                PoliceStation = policeStation.getText().toString();
                ZipCode = zipCode.getText().toString();
            }
        });
        customAddressDialog.setNegativeButton("Cancel", null);
        customAddressDialog.show();

        //Dialog Box
        /*final EditText mAddress = new EditText(this);
        customAddressDialog.setTitle("Food Ordering");
        customAddressDialog.setIcon(R.mipmap.ic_launcher);
        customAddressDialog.setView(mAddress);

        customAddressDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                addreess = mAddress.getText().toString();


            }
        });
        customAddressDialog.setNegativeButton("Cancel", null);
        customAddressDialog.show();*/
    }

    public void Confirm(View view) {
        String selectedFood = "";
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
            for(String SelectionFood : selection)
            {
                selectedFood = selectedFood + SelectionFood + "\n";
            }
        intent.putExtra("food",selectedFood);
        intent.putExtra("payment",payment);
        intent.putExtra("location",location);
        intent.putExtra("year", y);
        intent.putExtra("month", m);
        intent.putExtra("day", d);
        intent.putExtra("hour", h);
        intent.putExtra("minute", mi);
        intent.putExtra("house",HouseNumber);
        intent.putExtra("road",RoadNumber);
        intent.putExtra("thana",PoliceStation);
        intent.putExtra("zipCode",ZipCode);

        startActivity(intent);
    }


}
