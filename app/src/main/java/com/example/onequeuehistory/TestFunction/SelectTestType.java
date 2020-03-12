package com.example.onequeuehistory.TestFunction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.onequeuehistory.MyPageFunction.MyPageActivity;
import com.example.onequeuehistory.OhDobfunction.OhDobMain;
import com.example.onequeuehistory.R;

public class SelectTestType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_test_type);
    }

    public void onClick(View v) {
        int id = v.getId();
        Intent i;
        switch(id) {
            case R.id.perTestBtn :
                i = new Intent(getApplicationContext(), SelectTestNum.class);
                startActivity(i);
                break;
            case R.id.randomBtn :
                i = new Intent(getApplicationContext(), StudyTest.class);
                i.putExtra("testType", 2);
                startActivity(i);
                break;
            case R.id.LSTMBtn :
                i = new Intent(getApplicationContext(), StudyLSTMTest.class);
                startActivity(i);
                break;
        }
    }
    //액션바
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mypage, menu);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menulogo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_Ohdob) {
            Intent i=new Intent(getApplicationContext(), OhDobMain.class);
            startActivity(i);
            return true;
        }
        else if (id == R.id.action_setting) {
            Intent i=new Intent(getApplicationContext(), MyPageActivity.class);
            startActivity(i);
            return true;
        }
        return false;
    }
}
