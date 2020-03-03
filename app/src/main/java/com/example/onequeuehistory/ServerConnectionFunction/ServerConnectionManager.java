package com.example.onequeuehistory.ServerConnectionFunction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.widget.BaseAdapter;

import com.example.onequeuehistory.MyPageFunction.MyWeakness;
import com.example.onequeuehistory.R;
import com.example.onequeuehistory.TestFunction.question;
import com.example.onequeuehistory.TestFunction.testItem;
import com.example.onequeuehistory.UserFunction.UserInfo;

import java.util.Date;

public class ServerConnectionManager {
    private String URL;
    private int errCode;
    private int totalScore;
    //0. 메인 페이지
    public String[] getDate() {
        return new String[]{"20200523", "20200808", "20200919", "20201024"};
    }

    //1. 회원정보
    public String login(String id, String pw) {
        System.out.println("서버쪽" + id + " " + pw);
        Boolean chk = true;
        if(chk) return "이민우";
        errCode = 101;
        return "errOccure";
    }
    public Boolean register(UserInfo usr)  {

        System.out.println("서버" + usr.getId() + " " +usr.getPw() + " " +usr.getPw());
        Boolean chk = true;
        return chk;
    }
    public Boolean editUsrInfo(UserInfo usr) {
        Boolean chk = true;
        return chk;
    }
    public Boolean unRegister(String id, String pw) {
        Boolean chk = true;
        return chk;
    }

    //2. 문제풀이
    public int[][] getTestList(String id) {
        //회차별 문제풀이 - 개인 점수 및 회차 목록 반환
        int[][] tests = new int[40][];
        int k = 40;
        for(int i=0;i<40;i++) {
            tests[i][0] = k--;
            tests[i][1] = 0;
        }
        tests[39][1] = 97;
        tests[35][1] = 32;

        return tests;
    }
    public question getQuestion(String id, int testNum, Context context) {
        //문제 가져오기 1. 처음 시작시
        System.out.println("서버값 : " + id + " " + testNum);
        Bitmap q = BitmapFactory.decodeResource(context.getResources(), R.drawable.one);
        question newQuest = new question(
                39,
                1
                , "교사의 질문에 대한 답변으로 가장 적절한 것은?",
                1,
                q,
                "전삼국 - 생활",
                "전삼국 - 사회",
                "농경과 목축을 시작하여 식량을 생산하였습니다.",
                "가락바퀴를 이용하여 실을 뽑기 시작하였습니다.",
                "쟁기, 쇠스랑 등의 철제 농기구를 사용하였습니다.",
                "거푸집을 이용하여 비파형 동검을 제작하였습니다.",
                "정착 생활을 하게 되면서 움집이 처음 만들어졌습니다.",
                4,
                false,
                "사유 재산과 계급이 발생한 시대는 청동기 시대이고, 청동기 시대에는 거푸집을 이용하여 비파형동검을 제작하였다."
                );
        //int testNum, int questionNum, String qeust, int score, Bitmap image, String part1, String part2, String answer1, String answer2, String answer3, String answer4, String answer5, Boolean isPic

        return newQuest;
    }
    public question getQuestion(String id, int testNum, int questNum, int answer, Context context) {
        //문제 가져오기 2. 문제 풀고 다음 문제 반환
        System.out.println("서버값 : " + id + " " + testNum + " " + questNum + " " + answer);
        Bitmap q = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyone);

        Bitmap a1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyoneone);
        Bitmap a2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonetwo);
        Bitmap a3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonethree);
        Bitmap a4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonefour);
        Bitmap a5 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonefive);

        question newQuest = new question(
                39,
                31
                , "(가)에 들어갈 그림으로 가장 적절한 것은?,",
                2,
                q,
                "조선 후기 - 유물",
                "",
                a1, a2, a3, a4, a5,
                3,
                true,
                "혜원은 조선 후기의 대표적인 풍속화가인 신윤복의 호이다.\n" +
                        "대표적인 신윤복의 그림인 월하정인이다."
        );
        //int testNum, int questionNum, String qeust, int score, Bitmap image, String part1, String part2, String answer1, String answer2, String answer3, String answer4, String answer5, Boolean isPic

        Boolean chk = true;
        //if end, get false from server and get totalScore
        if(!chk) return new question(999);

        return newQuest;
    }
    public Boolean exitQuestion(String id, int testNum, int questNum, int testType) {
        //문제 중간종료시
        //testType 0:회차별 1:랜덤
        Boolean chk=true;
        if(!chk) errCode = 101;

        return chk;
    }
    public question[] finishQuestion(String id, int testNum, int questNum, int answer, Context context) {

        totalScore =96;

        Bitmap q1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.one);
        Bitmap q = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyone);
        Bitmap a1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyoneone);
        Bitmap a2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonetwo);
        Bitmap a3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonethree);
        Bitmap a4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonefour);
        Bitmap a5 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonefive);

        question[] wrongAnswers = {new question(
                        39,
                        1
                        , "교사의 질문에 대한 답변으로 가장 적절한 것은?",
                        1,
                        q1,
                        "전삼국 - 생활",
                        "전삼국 - 사회",
                        "농경과 목축을 시작하여 식량을 생산하였습니다.",
                        "가락바퀴를 이용하여 실을 뽑기 시작하였습니다.",
                        "쟁기, 쇠스랑 등의 철제 농기구를 사용하였습니다.",
                        "거푸집을 이용하여 비파형 동검을 제작하였습니다.",
                        "정착 생활을 하게 되면서 움집이 처음 만들어졌습니다.",
                        4,
                        false,
                        "사유 재산과 계급이 발생한 시대는 청동기 시대이고, 청동기 시대에는 거푸집을 이용하여 비파형동검을 제작하였다."
                ),
                new question(
                39,
                31
                , "(가)에 들어갈 그림으로 가장 적절한 것은?,",
                2,
                q,
                "조선 후기 - 유물",
                "",
                a1, a2, a3, a4, a5,
                3,
                true,
                "혜원은 조선 후기의 대표적인 풍속화가인 신윤복의 호이다.\n" +
                        "대표적인 신윤복의 그림인 월하정인이다."
                )};

        return wrongAnswers;
    }
    public question getRandomQuestion(String id, Context context) {
//문제 가져오기 1. 처음 시작시
        System.out.println("서버값 : " + id);
        Bitmap q = BitmapFactory.decodeResource(context.getResources(), R.drawable.one);
        question newQuest = new question(
                39,
                1
                , "교사의 질문에 대한 답변으로 가장 적절한 것은?",
                1,
                q,
                "전삼국 - 생활",
                "전삼국 - 사회",
                "농경과 목축을 시작하여 식량을 생산하였습니다.",
                "가락바퀴를 이용하여 실을 뽑기 시작하였습니다.",
                "쟁기, 쇠스랑 등의 철제 농기구를 사용하였습니다.",
                "거푸집을 이용하여 비파형 동검을 제작하였습니다.",
                "정착 생활을 하게 되면서 움집이 처음 만들어졌습니다.",
                4,
                false,
                "사유 재산과 계급이 발생한 시대는 청동기 시대이고, 청동기 시대에는 거푸집을 이용하여 비파형동검을 제작하였다."
        );
        //int testNum, int questionNum, String qeust, int score, Bitmap image, String part1, String part2, String answer1, String answer2, String answer3, String answer4, String answer5, Boolean isPic

        return newQuest;
    }
    public question getRandomQuestion(String id, int testNum, int questNum, int answer, Context context){
        System.out.println("서버값 : " + id + " " + testNum + " " + questNum + " " + answer);
        Bitmap q = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyone);

        Bitmap a1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyoneone);
        Bitmap a2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonetwo);
        Bitmap a3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonethree);
        Bitmap a4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonefour);
        Bitmap a5 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonefive);

        question newQuest = new question(
                39,
                31
                , "(가)에 들어갈 그림으로 가장 적절한 것은?,",
                2,
                q,
                "조선 후기 - 유물",
                "",
                a1, a2, a3, a4, a5,
                3,
                true,
                "혜원은 조선 후기의 대표적인 풍속화가인 신윤복의 호이다.\n" +
                        "대표적인 신윤복의 그림인 월하정인이다."
        );
        //int testNum, int questionNum, String qeust, int score, Bitmap image, String part1, String part2, String answer1, String answer2, String answer3, String answer4, String answer5, Boolean isPic

        Boolean chk = true;
        //if end, get false from server and get totalScore
        if(!chk) return new question(999);

        return newQuest;
    }
    public String[] getLSTMQuestion(String id) {
        //LSTM 문제
        String[] str = {"이방원은 두 차례에 걸친 ㅇㅇㅇㅇ을 일으켰다.","왕자의난"};

        return str;
    }

    //3. 오답노트
    public Boolean saveQuestion(String id, int testNum, int questNum) {
        System.out.println("서버쪽" + id + testNum + questNum);

        return true;
    }
    public question[] getSavedQuestionList(String id, Context context) {
        Bitmap q1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.one);
        Bitmap q = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyone);
        Bitmap a1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyoneone);
        Bitmap a2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonetwo);
        Bitmap a3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonethree);
        Bitmap a4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonefour);
        Bitmap a5 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonefive);


        question[] savedAnswers = {new question(
                39,
                1
                , "교사의 질문에 대한 답변으로 가장 적절한 것은?",
                1,
                q1,
                "전삼국 - 생활",
                "전삼국 - 사회",
                "농경과 목축을 시작하여 식량을 생산하였습니다.",
                "가락바퀴를 이용하여 실을 뽑기 시작하였습니다.",
                "쟁기, 쇠스랑 등의 철제 농기구를 사용하였습니다.",
                "거푸집을 이용하여 비파형 동검을 제작하였습니다.",
                "정착 생활을 하게 되면서 움집이 처음 만들어졌습니다.",
                4,
                false,
                "사유 재산과 계급이 발생한 시대는 청동기 시대이고, 청동기 시대에는 거푸집을 이용하여 비파형동검을 제작하였다."
        ),
                new question(
                        39,
                        31
                        , "(가)에 들어갈 그림으로 가장 적절한 것은?,",
                        2,
                        q,
                        "조선 후기 - 유물",
                        "",
                        a1, a2, a3, a4, a5,
                        3,
                        true,
                        "혜원은 조선 후기의 대표적인 풍속화가인 신윤복의 호이다.\n" +
                                "대표적인 신윤복의 그림인 월하정인이다."
                )};

        return savedAnswers;
    }
    public question solveSavedQuestion(String id, Context context) {
        Bitmap q = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyone);

        Bitmap a1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyoneone);
        Bitmap a2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonetwo);
        Bitmap a3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonethree);
        Bitmap a4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonefour);
        Bitmap a5 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonefive);

        question newQuest = new question(
                39,
                31
                , "(가)에 들어갈 그림으로 가장 적절한 것은?,",
                2,
                q,
                "조선 후기 - 유물",
                "",
                a1, a2, a3, a4, a5,
                3,
                true,
                "혜원은 조선 후기의 대표적인 풍속화가인 신윤복의 호이다.\n" +
                        "대표적인 신윤복의 그림인 월하정인이다."
        );
        //int testNum, int questionNum, String qeust, int score, Bitmap image, String part1, String part2, String answer1, String answer2, String answer3, String answer4, String answer5, Boolean isPic

        Boolean chk = true;
        //if end, get false from server and get totalScore
        if(!chk) return new question(999);

        return newQuest;
    }

    //4. 취약점
    public MyWeakness[] getWeakness(String id) {
        MyWeakness[] weaknesses = {
                new MyWeakness("조선-사회", 72, 100, "naver.com"),
                new MyWeakness("일제강점기-단체", 14, 84, "daum.net"),
                new MyWeakness("귀찮당", 31, 67, "google.com")
        };

        return weaknesses;
    }
    public question solveWeakness(String id, Context context) {
        //문제 가져오기 1. 처음 시작시
        System.out.println("서버값 : " + id);
        Bitmap q = BitmapFactory.decodeResource(context.getResources(), R.drawable.one);
        question newQuest = new question(
                39,
                1
                , "교사의 질문에 대한 답변으로 가장 적절한 것은?",
                1,
                q,
                "전삼국 - 생활",
                "전삼국 - 사회",
                "농경과 목축을 시작하여 식량을 생산하였습니다.",
                "가락바퀴를 이용하여 실을 뽑기 시작하였습니다.",
                "쟁기, 쇠스랑 등의 철제 농기구를 사용하였습니다.",
                "거푸집을 이용하여 비파형 동검을 제작하였습니다.",
                "정착 생활을 하게 되면서 움집이 처음 만들어졌습니다.",
                4,
                false,
                "사유 재산과 계급이 발생한 시대는 청동기 시대이고, 청동기 시대에는 거푸집을 이용하여 비파형동검을 제작하였다."
        );
        //int testNum, int questionNum, String qeust, int score, Bitmap image, String part1, String part2, String answer1, String answer2, String answer3, String answer4, String answer5, Boolean isPic

        return newQuest;
    }
    public question solveWeakness(String id, int testNum, int questNum, int answer, Context context) {
        //문제 가져오기 2. 문제 풀고 다음 문제 반환
        System.out.println("서버값 : " + id + " " + testNum + " " + questNum + " " + answer);
        Bitmap q = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyone);

        Bitmap a1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyoneone);
        Bitmap a2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonetwo);
        Bitmap a3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonethree);
        Bitmap a4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonefour);
        Bitmap a5 = BitmapFactory.decodeResource(context.getResources(), R.drawable.thirtyonefive);

        question newQuest = new question(
                39,
                31
                , "(가)에 들어갈 그림으로 가장 적절한 것은?,",
                2,
                q,
                "조선 후기 - 유물",
                "",
                a1, a2, a3, a4, a5,
                3,
                true,
                "혜원은 조선 후기의 대표적인 풍속화가인 신윤복의 호이다.\n" +
                        "대표적인 신윤복의 그림인 월하정인이다."
        );
        //int testNum, int questionNum, String qeust, int score, Bitmap image, String part1, String part2, String answer1, String answer2, String answer3, String answer4, String answer5, Boolean isPic

        Boolean chk = true;
        //if end, get false from server and get totalScore
        if(!chk) return new question(999);

        return newQuest;
    }
    public Boolean endWeakness(String id, int testNum, int questNum) {
        return true;
    }

    //5. 기타
    public int getErrCode() { return  errCode; }
    public int getTotalScore() { return totalScore; }
}
