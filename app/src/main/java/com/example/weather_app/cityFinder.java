package com.example.weather_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class cityFinder extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_finder);
        editText=findViewById(R.id.nameCity);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                String cityName=editText.getText().toString();
                Intent intent =new Intent(cityFinder.this,MainActivity.class);
                intent.putExtra("City",cityName);
                startActivity(intent);
                return false;
            }
        });
    }

    public void back(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}