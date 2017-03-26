package com.brishty.onlinefoodorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



public class OrderActivity extends AppCompatActivity {
    private  TextView mFood;
    private  TextView mPayment;
    private TextView mLocation;
    private TextView mDate;
    private TextView mTime;
    private TextView mAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        mFood = (TextView) findViewById(R.id.foodlist);
        mPayment = (TextView) findViewById(R.id.paymentTV);
        mLocation = (TextView) findViewById(R.id.areaTV);
        mDate = (TextView) findViewById(R.id.dateTV);
        mAddress = (TextView) findViewById(R.id.addressTV);
        mTime = (TextView) findViewById(R.id.timeTV);


        String foodList = getIntent().getStringExtra("food");
        String payment = getIntent().getStringExtra("payment");
        String location_area = getIntent().getStringExtra("location");
        String Address = getIntent().getStringExtra("address");
        int Year = getIntent().getIntExtra("year",0);
        int Month = getIntent().getIntExtra("month",0);
        int Day = getIntent().getIntExtra("day",0);
        int Hour = getIntent().getIntExtra("hour",0);
        int Minute = getIntent().getIntExtra("minute",0);

        mFood.setText(foodList);
        mPayment.setText(payment);
        mLocation.setText(location_area);
        mAddress.setText(Address);
        mDate.setText(String.valueOf(Year+"/"+Month+"/"+Day));
        mTime.setText(String.valueOf(Hour+":"+Minute));



    }
}