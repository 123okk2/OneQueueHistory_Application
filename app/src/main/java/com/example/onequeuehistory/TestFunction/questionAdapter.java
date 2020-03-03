package com.example.onequeuehistory.TestFunction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.onequeuehistory.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class questionAdapter extends BaseAdapter {
    Context context;
    ArrayList<question> arr = new ArrayList<>();
    // ListViewAdapter의 생성자
    public questionAdapter() {}

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    public int getCount() {
        return arr.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.testsheet, parent, false);
        }


        Button btn = (Button) convertView.findViewById(R.id.btn);
        TextView score = (TextView) convertView.findViewById(R.id.scoreText);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        btn.setText(arr.get(position).getTestNum());
        if(arr.get(position).getScore() == 0) score.setText("미응시");
        else score.setText(arr.get(position).getScore());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    public question getItem(int position) {
        return arr.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(question[] questions) {
        for (int i=0; i<questions.length; i++) arr.add(questions[i]);
    }
}
