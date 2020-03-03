package com.example.onequeuehistory.TestFunction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
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

        TextView testandQuestNum = convertView.findViewById(R.id.textView);
        testandQuestNum.setText(arr.get(position).getTestNum() + "-" + arr.get(position).getQuestionNum());
        TextView quest = convertView.findViewById(R.id.textView2);
        quest.setText(arr.get(position).getQuest());
        TextView score = convertView.findViewById(R.id.textView3);
        score.setText(arr.get(position).getScore());
        ImageView imageView = convertView.findViewById(R.id.imageView);
        imageView.setImageBitmap(arr.get(position).getImage());
        ListView answer4Normal = convertView.findViewById(R.id.answer4Normal);
        Button btn1 = convertView.findViewById(R.id.sel1), btn2 = convertView.findViewById(R.id.sel2),btn3 = convertView.findViewById(R.id.sel3),btn4 = convertView.findViewById(R.id.sel4),btn5 = convertView.findViewById(R.id.sel5);
        ListView answer4Pic = convertView.findViewById(R.id.answer4Image);
        ImageButton img1 = convertView.findViewById(R.id.imgsel1), img2 = convertView.findViewById(R.id.imgsel2), img3 = convertView.findViewById(R.id.imgsel3), img4 = convertView.findViewById(R.id.imgsel4), img5 = convertView.findViewById(R.id.imgsel5);
        if(arr.get(position).getPic()) {
            answer4Normal.setVisibility(View.GONE);
            answer4Pic.setVisibility(View.VISIBLE);
            img1.setImageBitmap(arr.get(position).getBitmapAnswer1());
            img2.setImageBitmap(arr.get(position).getBitmapAnswer2());
            img3.setImageBitmap(arr.get(position).getBitmapAnswer3());
            img4.setImageBitmap(arr.get(position).getBitmapAnswer4());
            img5.setImageBitmap(arr.get(position).getBitmapAnswer5());
        }
        else {
            answer4Normal.setVisibility(View.VISIBLE);
            answer4Pic.setVisibility(View.GONE);
            btn1.setText(arr.get(position).getAnswer1());
            btn2.setText(arr.get(position).getAnswer2());
            btn3.setText(arr.get(position).getAnswer3());
            btn4.setText(arr.get(position).getAnswer4());
            btn5.setText(arr.get(position).getAnswer5());
        }
        TextView answer = convertView.findViewById(R.id.answer);
        answer.setText(arr.get(position).getAnswer());
        //테스트 타입 추가하셈
        TextView testType = convertView.findViewById(R.id.testType);
        TextView solution = convertView.findViewById(R.id.solution);
        solution.setText(arr.get(position).getComment());

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
