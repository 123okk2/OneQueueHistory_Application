package com.example.onequeuehistory.UserFunction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onequeuehistory.R;
import com.example.onequeuehistory.ServerConnectionFunction.ServerConnectionManager;

public class SignIn extends AppCompatActivity {

    TextView idInput, pwInput, nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        idInput = (TextView) findViewById(R.id.idInput);
        pwInput = (TextView) findViewById(R.id.pwdInput);
        nameInput = (TextView) findViewById(R.id.nameInput);
    }

    public void onRegisterClicked(View v) {
        if(idInput.getText().toString().equals("")) Toast.makeText(getApplication(), "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
        else if (pwInput.getText().toString().equals("")) Toast.makeText(getApplication(), "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
        else if (nameInput.getText().toString().equals("")) Toast.makeText(getApplication(), "이름를 입력하세요.", Toast.LENGTH_SHORT).show();
        else {
            String id = idInput.getText().toString();
            String pw = pwInput.getText().toString();
            String name = nameInput.getText().toString();
            UserInfo newUser = new UserInfo(id, pw, name);
            System.out.println("회원가입" + id + " " +pw + " " +name);
            //서버 연결
            ServerConnectionManager scm = new ServerConnectionManager();
            Boolean chk = scm.register(newUser);
            if(chk) {
                Toast.makeText(getApplication(), "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
            else {
                switch(scm.getErrCode()){
                    case 101 :
                        Toast.makeText(getApplication(), "존재하는 아이디입니다.", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getApplication(), "알 수 없는 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void onCancleClicked(View v) {
        finish();
    }

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
