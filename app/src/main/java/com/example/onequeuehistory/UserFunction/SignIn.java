package com.example.onequeuehistory.UserFunction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onequeuehistory.R;

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
        if(idInput.getText().toString().equals("")) {
            Toast.makeText(getApplication(), "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
        }
        else if (pwInput.getText().toString().equals("")) {
            Toast.makeText(getApplication(), "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
        }
        else if (nameInput.getText().toString().equals("")) {
            Toast.makeText(getApplication(), "이름를 입력하세요.", Toast.LENGTH_SHORT).show();
        }
        else {
            String id = idInput.getText().toString();
            String pw = pwInput.getText().toString();
            String name = nameInput.getText().toString();
            UserInfo newUser = new UserInfo(id, pw, name);
            //서버 연결
        }
    }

    public void onCancleClicked(View v) {
        finish();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menuNothing, menu);

        getSupportActionBar().setTitle("한끝한국사");

        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.action_bar_pen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        return true;
    }
}
