package com.example.onequeuehistory.TestFunction;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
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

    @Override
    protected void onResume() {
        super.onResume();

        //서버에서 시험 수랑 각 시험 점수
        int[][] tests = new ServerConnectionManager().getTestList(userID);

        testItemAdapter ta = new testItemAdapter();
        gridView.setAdapter(ta);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                i.putExtra("testNum", ((testItem) parent.getItemAtPosition(position)).getTestNum());
            }
        });

        for(int i=0;i<tests.length;i++) {
            ta.addItem(tests[i][0], tests[i][1]);
        }

    }

    private Intent i;
    public void onSelectTest(View v) {
        i = new Intent(getApplicationContext(), StudyTest.class);
        Button selectedTest = findViewById(v.getId());
        int test = Integer.parseInt(selectedTest.getText().toString().substring(0,2));
        i.putExtra("testNumber", test);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
}
