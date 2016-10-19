package com.example.nguyen.weaver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    public final static String Extra = "com.example.nguyen.weaver.message";

    // Objekts for calculating the temperature are initialized
    Wheat w = new Wheat();
    Clothes c = new Clothes();
    String temp = "";
    //Android Objekts
    Spinner spinner;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner = (Spinner) findViewById(R.id.spinner);
        button = (Button) findViewById(R.id.button);

        // a new page will be opened once user clicks the button
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switchpage();
            }

        });

    }

    /**
     * the moethod creates new intent and carries the chosen city name
     * as an extra message
     */
    public void switchpage()
    {
        Intent intent = new Intent(this, Second.class);
        String message = spinner.getSelectedItem().toString();
        intent.putExtra(Extra,message);
        startActivity(intent);
    }

}
