package com.example.onequeuehistory.TestFunction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onequeuehistory.R;
import com.example.onequeuehistory.ServerConnectionFunction.ServerConnectionManager;

import java.util.ArrayList;

public class TestResult extends AppCompatActivity {

    private ServerConnectionManager scm = new ServerConnectionManager();
    private String userID;
    private int testNum, answer;

    TextView scoreSection;
    ListView ohdobSection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);
        //테스트 페이지 삭제 로직 추가하셈

        scoreSection = findViewById(R.id.scoreText);
        ohdobSection = findViewById(R.id.ohdobSection);
        userID = getIntent().getStringExtra("userID");

        question[] qsts = scm.finishQuestion(userID, getIntent().getIntExtra("testNum", 0), 50, getIntent().getIntExtra("answer", 0), getApplicationContext());
        scoreSection.setText(getIntent().getIntExtra("testNum", 0) +"회차 최종 점수 : " + scm.getTotalScore() +"점");
        questionAdapter qa = new questionAdapter();
        ohdobSection.setAdapter(qa);
        ohdobSection.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"길게 누르시면 오답노트에 저장됩니다.", Toast.LENGTH_SHORT).show();
            }
        });
        ohdobSection.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Boolean chk = scm.saveQuestion(userID, ((question) parent.getItemAtPosition(position)).getTestNum(), ((question) parent.getItemAtPosition(position)).getQuestionNum());
                if(chk) Toast.makeText(getApplicationContext(),"오답노트에 저장되었습니다.", Toast.LENGTH_SHORT).show();
                else {
                    int errCode = scm.getErrCode();
                    if(errCode == 101) Toast.makeText(getApplicationContext(),"이미 저장된 문제입니다.", Toast.LENGTH_SHORT).show();
                    else Toast.makeText(getApplicationContext(),"알 수 없는 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}
