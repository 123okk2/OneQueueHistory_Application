package com.example.onequeuehistory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onequeuehistory.MyPageFunction.MyPageActivity;
import com.example.onequeuehistory.MyPageFunction.MyWeakness;
import com.example.onequeuehistory.MyPageFunction.MyWeaknessAdapter;
import com.example.onequeuehistory.MyPageFunction.MyWeaknessMain;
import com.example.onequeuehistory.OhDobfunction.OhDobMain;
import com.example.onequeuehistory.ServerConnectionFunction.ServerConnectionManager;
import com.example.onequeuehistory.TestFunction.SelectTestType;
import com.example.onequeuehistory.TestFunction.TestResult;
import com.example.onequeuehistory.UserFunction.LogIn;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView Dday;
    Button startBtn;
    private long backKeyPressedTime = 0;
    private MyWeakness[] myWeaknessList;
    private String userID;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(getApplicationContext(), LogIn.class);
        startActivity(i);
        listview = findViewById(R.id.myWeaknessList);
    }

    @Override
    protected void onResume() {
        super.onResume();

        try {
            String[] examDates = new ServerConnectionManager().getDate();
            Date recentExam = new SimpleDateFormat("yyyyMMdd").parse(examDates[0]);
            long leftDate = (recentExam.getTime() - new Date().getTime()) / (24*60*60*1000);
            String str = "다음 한국사 시험까지 D-" + leftDate +" 남았습니다.";
            Dday = (TextView)findViewById(R.id.Dday);
            SpannableStringBuilder ssb = new SpannableStringBuilder(str);
            if (str.length() == 22) ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")), 12, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            else ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")), 12, 16, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            Dday.setText(ssb);

            System.out.println("머징");

            TextView txtView = findViewById(R.id.ExamDates);
            String dates = "\n";
            for (String dat:examDates) dates += dat.substring(0,4) + "년 " + dat.substring(4,6) + "월 " + dat.substring(6,8) +"일\n";
            System.out.println(dates);
            txtView.setText(dates);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String startBtnTxt = "문제 풀기\nSTART!";
        startBtn = (Button)findViewById(R.id.startBtn);
        SpannableStringBuilder ssb2 = new SpannableStringBuilder(startBtnTxt);
        ssb2.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")),6,11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        startBtn.setText(ssb2);

        SharedPreferences pref = getSharedPreferences("userInfo", MODE_PRIVATE);
        String name = pref.getString("userName", "None");
        userID = pref.getString("userID", "None");
        if(!name.equals("None")) {
            TextView txv = findViewById(R.id.textV);
            txv.setText(name + "님께서 가장 취약하신 파트들이에요.\n남은 기간, 이 부분들을 집중적으로 공부하세요! :)");
        }

        myWeaknessList = new ServerConnectionManager().getWeakness(userID);
        //리스트 출력
        MyWeaknessAdapter ma = new MyWeaknessAdapter();
        listview.setAdapter(ma);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), MyWeaknessMain.class);
                startActivity(i);
            }
        });
        for(int i=0; i<3; i++) ma.addItem(myWeaknessList[i]);
    }

    public void onClickBtn(View v) {
        Intent i = new Intent(getApplicationContext(), SelectTestType.class);
        startActivity(i);
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

    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(getApplicationContext(),
                    "뒤로 버튼을 한번 더 터치하시면 종료됩니다.",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            ActivityCompat.finishAffinity(this);
            System.runFinalizersOnExit(true);
            System.exit(0);
        }
    }

    public void onClick(View v) {
        Intent i = new Intent(getApplicationContext(), SelectTestType.class);
        startActivity(i);
    }
}
