package com.example.onequeuehistory.OhDobfunction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.onequeuehistory.MyPageFunction.MyPageActivity;
import com.example.onequeuehistory.R;
import com.example.onequeuehistory.ServerConnectionFunction.ServerConnectionManager;
import com.example.onequeuehistory.TestFunction.question;
import com.example.onequeuehistory.TestFunction.questionAdapter;

public class OhDobMain extends AppCompatActivity {
    private String userID;
    private ListView ohdobSection;
    private ServerConnectionManager scm = new ServerConnectionManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oh_dob_main);
        userID = getIntent().getStringExtra("userID");
        ohdobSection = findViewById(R.id.ohdobSection);
    }

    @Override
    protected void onResume() {
        super.onResume();
        question[] qsts = scm.getSavedQuestionList(userID, getApplicationContext());
        questionAdapter qa = new questionAdapter();
        ohdobSection.setAdapter(qa);
        qa.addItem(qsts);
        ohdobSection.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"길게 누르시면 삭제됩니다.", Toast.LENGTH_SHORT).show();
            }
        });
        ohdobSection.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Boolean chk = scm.saveQuestion(userID, ((question) parent.getItemAtPosition(position)).getTestNum(), ((question) parent.getItemAtPosition(position)).getQuestionNum());
                if(chk) {
                    Toast.makeText(getApplicationContext(),"오답노트에서 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                    onResume();
                }
                else {
                    Toast.makeText(getApplicationContext(),"알 수 없는 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

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
            Intent i=new Intent(getApplicationContext(), OhDobTest.class);
            startActivity(i);
            return true;
        }
        return false;
    }
}
