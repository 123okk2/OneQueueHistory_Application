package com.example.onequeuehistory.MyPageFunction;

public class MyWeakness {
    private String chapter;
    private int solved;
    private int corrects;
    private String recommendedVideo;

    public MyWeakness(String chapter, int solved, int corrects, String recommendedVideo) {
        this.chapter = chapter;
        this.solved = solved;
        this.corrects = corrects;
        this.recommendedVideo = recommendedVideo;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public int getSolved() {
        return solved;
    }

    public void setSolved(int solved) {
        this.solved = solved;
    }

    public int getCorrects() {
        return corrects;
    }

    public void setCorrects(int corrects) {
        this.corrects = corrects;
    }

    public String getRecommendedVideo() {
        return recommendedVideo;
    }

    public void setRecommendedVideo(String recommendedVideo) {
        this.recommendedVideo = recommendedVideo;
    }

    public double getPercentage() { return ((double) corrects/solved)*100; }
}
