package com.example.onequeuehistory.TestFunction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onequeuehistory.MyPageFunction.MyPageActivity;
import com.example.onequeuehistory.OhDobfunction.OhDobMain;
import com.example.onequeuehistory.R;
import com.example.onequeuehistory.ServerConnectionFunction.ServerConnectionManager;

public class StudyLSTMTest extends AppCompatActivity {

    private TextView questV;
    private EditText answerV;
    private ServerConnectionManager scm = new ServerConnectionManager();
    private String userID;
    private String[] quest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_lstmtest);

        questV = findViewById(R.id.qustionView);
        answerV = findViewById(R.id.answerView);

        SharedPreferences pref = getSharedPreferences("userInfo", MODE_PRIVATE);
        userID = pref.getString("userID", "None");
    }

    @Override
    protected void onResume() {
        super.onResume();
        quest = scm.getLSTMQuestion(userID);
        String question = quest[0];
        questV.setText(question);
    }

    public void onClick(View v) {
        if(answerV.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),"정답을 입력하세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            String answer = answerV.getText().toString();
            if(answer.equals(quest[1])) {
                Toast.makeText(getApplicationContext(),"정답입니다!", Toast.LENGTH_SHORT).show();
                onResume();
            }
            else Toast.makeText(getApplicationContext(),"오답입니다...", Toast.LENGTH_SHORT).show();
        }
    }

    private long backKeyPressedTime = 0;
    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(getApplicationContext(),
                    "뒤로 버튼을 한번 더 터치하시면 시험이 종료됩니다.",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finish();
        }
    }
    //액션바
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nothing, menu);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menulogo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        return true;
    }

}
