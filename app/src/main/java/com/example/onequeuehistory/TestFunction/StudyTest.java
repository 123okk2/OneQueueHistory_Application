package com.example.onequeuehistory.TestFunction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.ActivityCompat;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onequeuehistory.MyPageFunction.MyPageActivity;
import com.example.onequeuehistory.OhDobfunction.OhDobMain;
import com.example.onequeuehistory.R;
import com.example.onequeuehistory.ServerConnectionFunction.ServerConnectionManager;

public class StudyTest extends AppCompatActivity {
    private int testType; // 0:회차별 1:랜덤
    private int testNum; //회차별일 경우 회차
    private String userID; //사용자 아이디

    private int answer;
    private TextView testNumView, questView, scoreView;
    private ImageView questImg;
    private LinearLayout answer4Normal, answer4Img;
    private ImageButton img1, img2, img3, img4, img5;
    private Button btn1, btn2, btn3, btn4, btn5;

    private Boolean isFirst = true;
    private question quest;
    private ServerConnectionManager scm = new ServerConnectionManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_test);

        testType = getIntent().getIntExtra("testType", 3);
        if(testType != 2) testNum = getIntent().getIntExtra("testNum", 9999);
        SharedPreferences pref = getSharedPreferences("userInfo", MODE_PRIVATE);
        userID = pref.getString("userID", "None");

        testNumView = findViewById(R.id.testNum); questView = findViewById(R.id.quest); scoreView = findViewById(R.id.score); questImg = findViewById(R.id.questImg);
        answer4Img = findViewById(R.id.answer4Image); answer4Normal = findViewById(R.id.answer4Normal);
        img1 = findViewById(R.id.imgsel1); img2 = findViewById(R.id.imgsel2);img3 = findViewById(R.id.imgsel3);img4 = findViewById(R.id.imgsel4);img5 = findViewById(R.id.imgsel5);
        btn1 = findViewById(R.id.sel1); btn2 = findViewById(R.id.sel2);btn3 = findViewById(R.id.sel3);btn4 = findViewById(R.id.sel4);btn5 = findViewById(R.id.sel5);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btn3.setBackgroundResource(R.drawable.whitebox);
        btn2.setBackgroundResource(R.drawable.whitebox);
        btn1.setBackgroundResource(R.drawable.whitebox);
        btn4.setBackgroundResource(R.drawable.whitebox);
        btn5.setBackgroundResource(R.drawable.whitebox);
        img3.setBackgroundResource(R.drawable.whitebox);
        img2.setBackgroundResource(R.drawable.whitebox);
        img1.setBackgroundResource(R.drawable.whitebox);
        img4.setBackgroundResource(R.drawable.whitebox);
        img5.setBackgroundResource(R.drawable.whitebox);

        if(isFirst) {
            if(testType == 0) quest = scm.getQuestion(userID, testNum, getApplicationContext());
            else quest = scm.getRandomQuestion(userID, getApplicationContext());

            isFirst = !isFirst;
        }
        else {
            if (testType == 0)
                quest = scm.getQuestion(userID, testNum, quest.getQuestionNum(), answer, getApplicationContext());
            else
                quest = scm.getRandomQuestion(userID, quest.getTestNum(), quest.getQuestionNum(), answer, getApplicationContext());
        }

        testNumView.setText(quest.getTestNum() + "-" + quest.getQuestionNum());
        questView.setText(quest.getQuest());
        scoreView.setText(Integer.toString(quest.getScore()));
        questImg.setImageBitmap(quest.getImage());
        if(quest.getPic()) {
            answer4Img.setVisibility(View.VISIBLE);
            answer4Normal.setVisibility(View.GONE);
            img1.setImageBitmap(quest.getBitmapAnswer1());
            img2.setImageBitmap(quest.getBitmapAnswer2());
            img3.setImageBitmap(quest.getBitmapAnswer3());
            img4.setImageBitmap(quest.getBitmapAnswer4());
            img5.setImageBitmap(quest.getBitmapAnswer5());
        }
        else {
            answer4Img.setVisibility(View.GONE);
            answer4Normal.setVisibility(View.VISIBLE);
            btn1.setText(quest.getAnswer1());
            btn2.setText(quest.getAnswer2());
            btn3.setText(quest.getAnswer3());
            btn4.setText(quest.getAnswer4());
            btn5.setText(quest.getAnswer5());
        }

        answer = 999;
    }

    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.sel1 || id == R.id.imgsel1) {
            answer = 1;
            btn1.setBackgroundResource(R.drawable.graybox);
            btn2.setBackgroundResource(R.drawable.whitebox);
            btn3.setBackgroundResource(R.drawable.whitebox);
            btn4.setBackgroundResource(R.drawable.whitebox);
            btn5.setBackgroundResource(R.drawable.whitebox);
            img1.setBackgroundResource(R.drawable.graybox);
            img2.setBackgroundResource(R.drawable.whitebox);
            img3.setBackgroundResource(R.drawable.whitebox);
            img4.setBackgroundResource(R.drawable.whitebox);
            img5.setBackgroundResource(R.drawable.whitebox);
        }
        else if(id == R.id.sel2 || id == R.id.imgsel2) {
            answer = 2;
            btn2.setBackgroundResource(R.drawable.graybox);
            btn1.setBackgroundResource(R.drawable.whitebox);
            btn3.setBackgroundResource(R.drawable.whitebox);
            btn4.setBackgroundResource(R.drawable.whitebox);
            btn5.setBackgroundResource(R.drawable.whitebox);
            img2.setBackgroundResource(R.drawable.graybox);
            img1.setBackgroundResource(R.drawable.whitebox);
            img3.setBackgroundResource(R.drawable.whitebox);
            img4.setBackgroundResource(R.drawable.whitebox);
            img5.setBackgroundResource(R.drawable.whitebox);
        }
        else if(id == R.id.sel3 || id == R.id.imgsel3) {
            answer = 3;
            btn3.setBackgroundResource(R.drawable.graybox);
            btn2.setBackgroundResource(R.drawable.whitebox);
            btn1.setBackgroundResource(R.drawable.whitebox);
            btn4.setBackgroundResource(R.drawable.whitebox);
            btn5.setBackgroundResource(R.drawable.whitebox);
            img3.setBackgroundResource(R.drawable.graybox);
            img2.setBackgroundResource(R.drawable.whitebox);
            img1.setBackgroundResource(R.drawable.whitebox);
            img4.setBackgroundResource(R.drawable.whitebox);
            img5.setBackgroundResource(R.drawable.whitebox);
        }
        else if(id == R.id.sel4 || id == R.id.imgsel4) {
            answer = 4;
            btn4.setBackgroundResource(R.drawable.graybox);
            btn2.setBackgroundResource(R.drawable.whitebox);
            btn3.setBackgroundResource(R.drawable.whitebox);
            btn1.setBackgroundResource(R.drawable.whitebox);
            btn5.setBackgroundResource(R.drawable.whitebox);
            img4.setBackgroundResource(R.drawable.graybox);
            img2.setBackgroundResource(R.drawable.whitebox);
            img3.setBackgroundResource(R.drawable.whitebox);
            img1.setBackgroundResource(R.drawable.whitebox);
            img5.setBackgroundResource(R.drawable.whitebox);
        }
        else if(id == R.id.sel5 || id == R.id.imgsel5) {
            answer = 5;
            btn5.setBackgroundResource(R.drawable.graybox);
            btn2.setBackgroundResource(R.drawable.whitebox);
            btn3.setBackgroundResource(R.drawable.whitebox);
            btn4.setBackgroundResource(R.drawable.whitebox);
            btn1.setBackgroundResource(R.drawable.whitebox);
            img5.setBackgroundResource(R.drawable.graybox);
            img2.setBackgroundResource(R.drawable.whitebox);
            img3.setBackgroundResource(R.drawable.whitebox);
            img4.setBackgroundResource(R.drawable.whitebox);
            img1.setBackgroundResource(R.drawable.whitebox);
        }
        else if(id == R.id.submitBtn) {
            boolean chk = false;
            if(answer == 999) {
                Toast.makeText(getApplicationContext(),"정답을 골라주세요.", Toast.LENGTH_SHORT).show();
                return;
            }
            if(quest.getQuestionNum() == 50 && testType != 2) {
                Intent i = new Intent(getApplicationContext(), TestResult.class);
                i.putExtra("userID", userID);
                i.putExtra("testNum", testNum);
                i.putExtra("answer", answer);
                startActivity(i);
                //액티비티 종료해야됨
            }
            if(testType == 1 || testType == 2) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                if(answer == quest.getAnswer()) {
                    builder.setTitle("정답입니다!").setMessage(quest.getComment());
                    chk = true;
                }
                else builder.setTitle("틀렸습니다...").setMessage(quest.getComment());
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        onResume();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
            else onResume();
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
            int type = 0;
            if(testType == 2) type = 1;
            scm.exitQuestion(userID, quest.getTestNum(), quest.getQuestionNum(), type);
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
