package com.example.onequeuehistory.TestFunction;

public class testItem {
    private int testNum;
    private int score;

    testItem(int testNum, int score) {
        this.testNum = testNum;
        this.score = score;
    }

    public int getTestNum() {
        return testNum;
    }
    public void setTestNum(int testNum) {
        this.testNum = testNum;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
