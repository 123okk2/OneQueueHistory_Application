package com.example.onequeuehistory.ServerConnectionFunction;

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

    public int getErrCode() { return  errCode; }
}
