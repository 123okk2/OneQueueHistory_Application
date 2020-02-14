package com.example.onequeuehistory;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Dday;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String str = "다음 한국사 시험까지 D-5 남았습니다.";
        Dday = (TextView)findViewById(R.id.Dday);
        SpannableStringBuilder ssb = new SpannableStringBuilder(str);
        if (str.length() == 22) ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")), 12, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        else ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")), 12, 16, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Dday.setText(ssb);

        String startBtnTxt = "랜덤 문제 풀기\nSTART!";
        startBtn = (Button)findViewById(R.id.startBtn);
        SpannableStringBuilder ssb2 = new SpannableStringBuilder(startBtnTxt);
        System.out.println(startBtnTxt.length());
        ssb2.setSpan(new ForegroundColorSpan(Color.parseColor("#D81B60")),8,13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        startBtn.setText(startBtnTxt);

    }
}
