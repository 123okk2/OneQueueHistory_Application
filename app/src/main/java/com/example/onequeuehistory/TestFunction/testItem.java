package com.example.onequeuehistory.TestFunction;

public class testItem {
    private int testNum;
    private int score;
    private int questNum;

    public testItem(int testNum, int score, int questNum) {
        this.testNum = testNum;
        this.score = score;
        this.questNum = questNum;
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
    public int getQuestNum() { return questNum; }
    public void setQuestNum(int questNum) { this.questNum = questNum; }
}
