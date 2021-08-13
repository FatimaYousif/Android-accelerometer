package com.example.accelerometer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    int[] images={
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five
    };
    ImageView img;

    /*
    1. Sensor Manager
    2. Sensor
    3. onResume- Register Sensor
    4. onPause- UnRegister Sensor

    OVERRIDE

    5. onSensorChanged (x,y,z) values of accelerometer
    6. onAccuracyChanged - leave this method
     */
    SensorManager mSensorManager;
    Sensor mAccelerometer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("change imgs on rotation");

        img = (ImageView)findViewById(R.id.imageView);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }
    @Override
    protected void onResume()
    {
        super.onResume();
        mSensorManager.registerListener(MainActivity.this, (android.hardware.Sensor) mAccelerometer,SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        mSensorManager.unregisterListener(MainActivity.this);
    }

    //SensorEventListener methods
    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        //5 rotations

        if(x>=7 && y>=-1)
        {
            img.setBackgroundResource(R.drawable.one);
        }
        else if(x>=10 && y>=1)
        {
            img.setBackgroundResource(R.drawable.two);
        }
        else if(x>=1 && y>=7)
        {
            img.setBackgroundResource(R.drawable.three);
        }
        //working
        else if(x>=-8 && y>=-2)
        {
            img.setBackgroundResource(R.drawable.four);
        }
        //working
        else if(x>=1 && y>=-9)
        {
            img.setBackgroundResource(R.drawable.five);
        }

    }

    @Override
    public void onAccuracyChanged(android.hardware.Sensor sensor, int accuracy) {

    }
}