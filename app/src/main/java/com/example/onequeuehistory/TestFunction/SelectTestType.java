package com.example.onequeuehistory.TestFunction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.onequeuehistory.R;

public class SelectTestType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_test_type);
    }

    public void onClick(View v) {
        int id = v.getId();
        Intent i = new Intent();

        switch(id) {
            case R.id.perTestBtn :
                break;
            case R.id.randomBtn :
                break;
            case R.id.LSTMBtn :
                break;
        }

        startActivity(i);
    }
}
