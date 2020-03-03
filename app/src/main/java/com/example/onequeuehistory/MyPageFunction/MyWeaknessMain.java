package com.example.onequeuehistory.MyPageFunction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onequeuehistory.R;
import com.example.onequeuehistory.ServerConnectionFunction.ServerConnectionManager;
import com.example.onequeuehistory.TestFunction.testItem;
import com.example.onequeuehistory.TestFunction.testItemAdapter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.GraphViewXML;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;

public class MyWeaknessMain extends AppCompatActivity {

    private MyWeakness[] myWeaknessList;
    private String userID;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_weakness_main);

        SharedPreferences pref = getSharedPreferences("userInfo", MODE_PRIVATE);
        userID = pref.getString("userID", "None");
        listview = findViewById(R.id.graphView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ServerConnectionManager scm = new ServerConnectionManager();
        myWeaknessList = scm.getWeakness(userID);

        //리스트 출력
        MyWeaknessAdapter ma = new MyWeaknessAdapter();
        listview.setAdapter(ma);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"길게 누르시면 강의가 재생됩니다.", Toast.LENGTH_SHORT).show();
            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Uri uri = Uri.parse(((MyWeakness) parent.getItemAtPosition(position)).getRecommendedVideo());
                Intent i  = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
                return false;
            }
        });
        ma.addItem(myWeaknessList);
    }
}