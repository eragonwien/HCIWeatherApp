package com.example.nguyen.weaver;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    // initializing of objekts in the second activity
    TextView city, temperatur;
    ImageView tipp;
    String cityname;
    String temp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        city = (TextView) findViewById(R.id.city);
        temperatur = (TextView) findViewById(R.id.temp);
        tipp = (ImageView) findViewById(R.id.tipp);

        // the intent including its message of the read city name is called
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.Extra);
        cityname = message;
        //execute an asynctask
        new MyTask().execute(message);


    }
    private class MyTask extends AsyncTask<String, Void, Void> {
        String result;

        @Override
        protected Void doInBackground(String... city) {
            //aquiring temperature from the openweather api
            //the result is saved for later use
            Wheat w = new Wheat();
            try {
                result = Integer.toString(w.getTemp(city[0]));

            } catch (Exception e) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            //the result is called here and shown on the screen
            city.setText(cityname);
            temperatur.setText(result+"°C");
            //default background
            RelativeLayout layout =(RelativeLayout)findViewById(R.id.background2);
            Clothes c = new Clothes();
            String season = c.getAdvise(Integer.parseInt(result));
            //background will be changed after the result of the advise
            //same the the recommended clothes
            if(season.equals("cold"))
            {
                layout.setBackgroundResource(R.drawable.winter);
                tipp.setBackgroundResource(R.drawable.pink);
            }
            else if(season.equals("hot"))
            {
                layout.setBackgroundResource(R.drawable.desert);
                tipp.setBackgroundResource(R.drawable.teamcap);
            }
            else
            {
                layout.setBackgroundResource(R.drawable.green);
                tipp.setBackgroundResource(R.drawable.f4);
            }
            super.onPostExecute(aVoid);
        }
    }
}
