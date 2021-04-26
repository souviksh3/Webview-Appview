package com.example.demo_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView medt1;
    Button mbtn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        medt1 = findViewById(R.id.edt1);
        mbtn1 = findViewById(R.id.btn1);

        mbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                String u = medt1.getText().toString();
                intent.putExtra("url",u);
                startActivity(intent);

            }
        });




        }
    }
