package com.example.onequeuehistory.TestFunction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onequeuehistory.MyPageFunction.MyPageActivity;
import com.example.onequeuehistory.OhDobfunction.OhDobMain;
import com.example.onequeuehistory.R;
import com.example.onequeuehistory.ServerConnectionFunction.ServerConnectionManager;

public class SelectTestNum extends AppCompatActivity {

    GridView gridView;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per_test_study);

        gridView = findViewById(R.id.testGrid);

        SharedPreferences pref = getSharedPreferences("userInfo", MODE_PRIVATE);
        userID = pref.getString("userID", "None");
    }

    private Intent i;
    @Override
    protected void onResume() {
        super.onResume();

        //서버에서 시험 수랑 각 시험 점수
        testItem[] tests = new ServerConnectionManager().getTestList(userID);

        testItemAdapter ta = new testItemAdapter();
        gridView.setAdapter(ta);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i = new Intent(getApplicationContext(), StudyTest.class);
                int test = ((testItem) parent.getItemAtPosition(position)).getTestNum();
                i.putExtra("testNum ", test);

                AlertDialog.Builder builder = new AlertDialog.Builder(SelectTestNum.this);
                builder.setTitle("시험 유형을 선택해주세요");
                builder.setPositiveButton("전체 풀기", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        i.putExtra("testType", 0);
                        startActivity(i);
                    }
                });
                builder.setNegativeButton("하나씩 풀기", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        i.putExtra("testType", 1);
                        startActivity(i);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        for(int i=0;i<tests.length;i++) {
            ta.addItem(tests[i].getTestNum(), tests[i].getScore(), tests[i].getQuestNum());
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
