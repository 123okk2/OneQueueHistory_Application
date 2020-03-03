package com.example.onequeuehistory.TestFunction;

import android.graphics.Bitmap;

public class question {
    private int testNum; //회차
    private int questionNum; //문제 번호
    private String quest; //문제
    private int score; //점수
    private Bitmap image; //지문 사진
    private String part1, part2; //문제유형 1,2
    private String answer1, answer2, answer3, answer4, answer5; //지문 1~5
    private int answer; //정답
    private Bitmap BitmapAnswer1, BitmapAnswer2, BitmapAnswer3, BitmapAnswer4, BitmapAnswer5;
    private Boolean isPic; //문제 유형 (보기가 사진인지 아닌지) 사진 : 1 아님 : 0
    private String comment;

    public question(int testNum, int questionNum, String quest, int score, Bitmap image, String part1, String part2, String answer1, String answer2, String answer3, String answer4, String answer5, int answer, Boolean isPic, String comment) {
        this.testNum = testNum;
        this.questionNum = questionNum;
        this.quest = quest;
        this.score = score;
        this.image = image;
        this.part1 = part1;
        this.part2 = part2;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;
        this.answer = answer;
        this.isPic = isPic;
        this.comment = comment;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public question(int testNum) {
        //끝을 알리기 용.
        this.testNum = testNum;
    }


    public question(int testNum, int questionNum, String quest, int score, Bitmap image, String part1, String part2, Bitmap bitmapAnswer1, Bitmap bitmapAnswer2, Bitmap bitmapAnswer3, Bitmap bitmapAnswer4, Bitmap bitmapAnswer5, int answer, Boolean isPic, String comment) {
        this.testNum = testNum;
        this.questionNum = questionNum;
        this.quest = quest;
        this.score = score;
        this.image = image;
        this.part1 = part1;
        this.part2 = part2;
        BitmapAnswer1 = bitmapAnswer1;
        BitmapAnswer2 = bitmapAnswer2;
        BitmapAnswer3 = bitmapAnswer3;
        BitmapAnswer4 = bitmapAnswer4;
        BitmapAnswer5 = bitmapAnswer5;
        this.answer = answer;
        this.isPic = isPic;
        this.comment = comment;
    }

    public int getTestNum() {
        return testNum;
    }

    public void setTestNum(int testNum) {
        this.testNum = testNum;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public Bitmap getBitmapAnswer1() {
        return BitmapAnswer1;
    }

    public void setBitmapAnswer1(Bitmap bitmapAnswer1) {
        BitmapAnswer1 = bitmapAnswer1;
    }

    public Bitmap getBitmapAnswer2() {
        return BitmapAnswer2;
    }

    public void setBitmapAnswer2(Bitmap bitmapAnswer2) {
        BitmapAnswer2 = bitmapAnswer2;
    }

    public Bitmap getBitmapAnswer3() {
        return BitmapAnswer3;
    }

    public void setBitmapAnswer3(Bitmap bitmapAnswer3) {
        BitmapAnswer3 = bitmapAnswer3;
    }

    public Bitmap getBitmapAnswer4() {
        return BitmapAnswer4;
    }

    public void setBitmapAnswer4(Bitmap bitmapAnswer4) {
        BitmapAnswer4 = bitmapAnswer4;
    }

    public Bitmap getBitmapAnswer5() {
        return BitmapAnswer5;
    }

    public void setBitmapAnswer5(Bitmap bitmapAnswer5) {
        BitmapAnswer5 = bitmapAnswer5;
    }

    public Boolean getPic() {
        return isPic;
    }

    public void setPic(Boolean pic) {
        isPic = pic;
    }
}
