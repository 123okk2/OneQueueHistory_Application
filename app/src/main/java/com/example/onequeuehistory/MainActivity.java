package com.example.onequeuehistory;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onequeuehistory.MyPageFunction.MyPageActivity;
import com.example.onequeuehistory.TestFunction.SelectTestType;
import com.example.onequeuehistory.UserFunction.LogIn;

public class MainActivity extends AppCompatActivity {

    private TextView Dday;
    Button startBtn;
    private long backKeyPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(getApplicationContext(), LogIn.class);
        startActivity(i);

        String str = "다음 한국사 시험까지 D-5 남았습니다.";
        Dday = (TextView)findViewById(R.id.Dday);
        SpannableStringBuilder ssb = new SpannableStringBuilder(str);
        if (str.length() == 22) ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")), 12, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        else ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")), 12, 16, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Dday.setText(ssb);

        String startBtnTxt = "문제 풀기\nSTART!";
        startBtn = (Button)findViewById(R.id.startBtn);
        SpannableStringBuilder ssb2 = new SpannableStringBuilder(startBtnTxt);
        System.out.println(startBtnTxt.length());
        ssb2.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")),8,13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        startBtn.setText(startBtnTxt);

    }

    public void onClickBtn(View v) {
        Intent i = new Intent(getApplicationContext(), SelectTestType.class);
        startActivity(i);
    }

    //액션바
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menuMyPage, menu);

        getSupportActionBar().setTitle("IFind");

        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.action_bar_pen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent i = new Intent();
        if (id == R.id.action_Ohdob) {
            i=new Intent(getApplicationContext(), OhDobActivity.class);
            return true;
        }
        else if (id == R.id.action_setting) {
            i=new Intent(getApplicationContext(), MyPageActivity.class);
            return true;
        }
        startActivity(i);
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
}
