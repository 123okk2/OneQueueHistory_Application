package com.example.onequeuehistory.MyPageFunction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.onequeuehistory.R;
import com.example.onequeuehistory.TestFunction.testItem;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyWeaknessAdapter extends BaseAdapter {
    Context context;
    ArrayList<MyWeakness> arr = new ArrayList<>();
    // ListViewAdapter의 생성자
    public MyWeaknessAdapter() {}

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
            convertView = inflater.inflate(R.layout.graph, parent, false);
        }

        TextView chapterName = convertView.findViewById(R.id.chapterName);
        ProgressBar pgbar = convertView.findViewById(R.id.percent);
        TextView counts = convertView.findViewById(R.id.counts);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        chapterName.setText(arr.get(position).getChapter());
        pgbar.setMax(100);
        pgbar.setProgress((int)arr.get(position).getPercentage());
        counts.setText(arr.get(position).getCorrects() + "/" + arr.get(position).getSolved());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    public MyWeakness getItem(int position) {
        return arr.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String chapter, int solved, int corrects, String recommendedVideo) {
        arr.add(new MyWeakness(chapter, solved, corrects, recommendedVideo));
    }
    public void addItem(MyWeakness[] ar) {
        for(int i=0;i<ar.length;i++) arr.add(ar[i]);
    }
}
