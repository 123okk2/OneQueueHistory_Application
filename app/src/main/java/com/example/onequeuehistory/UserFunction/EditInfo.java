package com.example.onequeuehistory.UserFunction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onequeuehistory.MainActivity;
import com.example.onequeuehistory.MyPageFunction.MyPageActivity;
import com.example.onequeuehistory.OhDobfunction.OhDobMain;
import com.example.onequeuehistory.R;
import com.example.onequeuehistory.ServerConnectionFunction.ServerConnectionManager;
import com.example.onequeuehistory.UserFunction.UserInfo;

public class EditInfo extends AppCompatActivity {

    EditText id, pw, name;
    String userID, userName, userPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        //usr 초기화

        id=findViewById(R.id.idInput);
        pw = findViewById(R.id.pwdInput);
        name = findViewById(R.id.nameInput);

        SharedPreferences pref = getSharedPreferences("userInfo", MODE_PRIVATE);
        String userID = pref.getString("userID", "None");
        String userName = pref.getString("userName", "None");

        id.setText(userID);
        id.setEnabled(false);
        name.setText(userName);
    }

    public void onClickBtn(View v) {
        int sel = v.getId();
        userName = name.getText().toString();
        userPW = pw.getText().toString();
        switch(sel) {
            case R.id.editBtn :
                //로직
                ServerConnectionManager scm = new ServerConnectionManager();
                Boolean chk =  scm.editUsrInfo(new UserInfo(userID,  userPW, userName));
                if(chk) {
                    Toast.makeText(getApplication(), "회원정보 수정이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    SharedPreferences pref = getSharedPreferences("userInfo", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("userName", userName);
                    editor.commit();
                    finish();
                }
                else {
                    switch(scm.getErrCode()){
                        case 101 :
                            Toast.makeText(getApplication(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(getApplication(), "알 수 없는 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.cancle :
                finish();
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
