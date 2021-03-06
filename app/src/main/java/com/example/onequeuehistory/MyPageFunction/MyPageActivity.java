package com.example.onequeuehistory.MyPageFunction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onequeuehistory.MainActivity;
import com.example.onequeuehistory.OhDobfunction.OhDobMain;
import com.example.onequeuehistory.R;
import com.example.onequeuehistory.ServerConnectionFunction.ServerConnectionManager;
import com.example.onequeuehistory.UserFunction.EditInfo;
import com.example.onequeuehistory.UserFunction.UnRegister;

public class MyPageActivity extends AppCompatActivity {
    private TextView nameBox;
    private ServerConnectionManager scm = new ServerConnectionManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
        nameBox = findViewById(R.id.userName);
        SharedPreferences pref = getSharedPreferences("userInfo", MODE_PRIVATE);
        String userID = pref.getString("userID", "None");
        String name = pref.getString("userName", "None");
        int averageScore = scm.getAverageScore(userID);
        if(averageScore == 0) nameBox.setText("환영합니다 " + name + "님\n" + "평균점수 : " + averageScore);
        else nameBox.setText("환영합니다 " + name + "님");
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

    //액션바
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ohdob, menu);
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
        return false;
    }
}
