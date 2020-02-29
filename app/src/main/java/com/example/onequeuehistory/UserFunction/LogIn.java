package com.example.onequeuehistory.UserFunction;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onequeuehistory.R;

public class LogIn extends AppCompatActivity {
    //뒤로가기시 종료
    private long backKeyPressedTime = 0;
    private Toast toast;
    private Activity activity;

    Context context = LogIn.this;

    String id;
    String pwd;

    EditText idInput;
    EditText pwdInput;

    CheckBox autoLogin;

    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        checkPermiss();

        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        SharedPreferences pref = getSharedPreferences("loginInfo", MODE_PRIVATE);

        idInput = (EditText) findViewById(R.id.idInput);
        pwdInput = (EditText) findViewById(R.id.pwdInput);
        autoLogin = (CheckBox) findViewById(R.id.checkBox);
        loginBtn = (Button) findViewById(R.id.logInBtn);

        String id = pref.getString("id", "SYS_NONE");
        String pw = pref.getString("pwd", "");

        System.out.println(id.equals("SYS_NONE"));
        System.out.println("id:"+idInput.getText());

        if(id.equals("SYS_NONE")) {
            idInput.setText("");
            autoLogin.setChecked(false);
        }
        else{
            idInput.setText(id);
            autoLogin.setChecked(true);
        }

        pwdInput.setText(pw);
        System.out.println(idInput.getText() + " " + pwdInput.getText());
        if(!idInput.getText().equals("") && autoLogin.isChecked()) {
            autoLogin.setChecked(true);
            loginBtn.performClick();
        }

    }

    public void checkPermiss() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)== PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this,
                    new String[] { Manifest.permission.INTERNET}, 0);
        }
    }

    public void onClickLogin(View v) {
        id = idInput.getText().toString();
        pwd = pwdInput.getText().toString();
        if(id.equals("")) {
            Toast.makeText(getApplication(), "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
        }
        else if (pwd.equals("")) {
            Toast.makeText(getApplication(), "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
        }
        else {
            //new JSONParse().execute();
        }
    }

    public void onRegisterClicked(View v) {
        Intent i = new Intent(getApplicationContext(), SignIn.class);
        startActivity(i);
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
            toast.cancel();
        }
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

    /*
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu4, menu);

        getSupportActionBar().setTitle("IFind");

        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent i;
        if (id == R.id.action_search) {
            return true;
        } else if (id == R.id.action_setting) {
            i=new Intent(getApplicationContext(), SettingMain.class);
            startActivity(i);
            return true;
        }
        else if (id == R.id.action_camera) {
            i=new Intent(getApplicationContext(), ComparePictureList.class);
            startActivity(i);
            return true;
        }
        return false;
    }
    */
}
