package com.example.onequeuehistory.MyPageFunction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.onequeuehistory.MainActivity;
import com.example.onequeuehistory.R;
import com.example.onequeuehistory.UserFunction.EditInfo;
import com.example.onequeuehistory.UserFunction.UnRegister;

public class MyPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
    }

    public void onClickBtn(View v) {
        int id = v.getId();
        Intent i = new Intent();
        switch(id) {
            case R.id.myInfo :
                //회원정보 수정
                i = new Intent(getApplicationContext(), EditInfo.class);
                break;
            case R.id.unregister :
                //회원탈퇴
                i =  new Intent(getApplicationContext(), UnRegister.class);
                break;
            case R.id.logOut :
                //로그아웃
                Toast.makeText(getApplicationContext(),"로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
                SharedPreferences pref = getSharedPreferences("loginInfo", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("id", "SYS_NONE");
                editor.putString("pwd", "");
                editor.commit();
                i = new Intent(getApplicationContext(), MainActivity.class);
                break;
            case R.id.myWeakness :
                //취약점 분석
                i = new Intent(getApplicationContext(),MyWeaknessMain.class);
                break;
        }
        startActivity(i);
    }
}
