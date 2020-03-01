package com.example.onequeuehistory.ServerConnectionFunction;

import com.example.onequeuehistory.TestFunction.question;
import com.example.onequeuehistory.TestFunction.testItem;
import com.example.onequeuehistory.UserFunction.UserInfo;

import java.util.Date;

public class ServerConnectionManager {
    private String URL;
    private int errCode;
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
    public int[][] getTestList() {
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
    public question getQuestion(String id, int testNum) {
        //문제 가져오기 1. 처음 시작시
        question newQuest = new question();
        //int testNum, int questionNum, String qeust, int score, Bitmap image, String part1, String part2, String answer1, String answer2, String answer3, String answer4, String answer5, Boolean isPic
    }
    public question getQuestion(String id, int testNum, int questNum, int answer) {
        //문제 가져오기 2. 문제 풀고 다음 문제 반환
    }
    public Boolean exitQuestion(String id, int testNum, int questNum) {
        //문제 중간종료시
    }
    public String[] getLSTMQuestion(String id) {
        //LSTM 문제
        String[] str = {"이방원은 두 차례에 걸친 ㅇㅇㅇㅇ을 일으켰다.","왕자의난"};

        return str;
    }


    public int getErrCode() { return  errCode; }
}
