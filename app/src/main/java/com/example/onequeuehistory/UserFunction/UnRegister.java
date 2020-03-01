package com.example.onequeuehistory.UserFunction;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onequeuehistory.MainActivity;
import com.example.onequeuehistory.R;
import com.example.onequeuehistory.ServerConnectionFunction.ServerConnectionManager;

public class UnRegister extends AppCompatActivity {

    EditText inputPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_un_register);

        inputPW = findViewById(R.id.pwdInput);
    }

    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("회원 탈퇴를 진행하시겠습니까?").setMessage("회원 정보는 복구되지 않습니다.");
        builder.setPositiveButton("취소", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                finish();
            }
        });
        builder.setNegativeButton("탈퇴", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                //탈퇴 진행
                SharedPreferences pref = getSharedPreferences("userInfo", MODE_PRIVATE);
                String userID = pref.getString("userID", "None");
                String userPW = inputPW.getText().toString();
                ServerConnectionManager scm = new ServerConnectionManager();
                Boolean chk = scm.unRegister(userID, userPW);

                if(chk) {
                    Toast.makeText(getApplication(), "회원탈퇴가 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    SharedPreferences pref2 = getSharedPreferences("loginInfo", MODE_PRIVATE);
                    pref2.getString("id","SYS_NONE");
                    pref2.getString("pwd","");
                    Intent i=new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
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
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }
}
