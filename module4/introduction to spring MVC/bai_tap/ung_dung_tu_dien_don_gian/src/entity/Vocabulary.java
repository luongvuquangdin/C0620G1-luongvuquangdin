package entity;

public class Vocabulary {
    private String english;
    private String meanVietNamese;

    public Vocabulary(String english, String meanVietNamese) {
        this.english = english;
        this.meanVietNamese = meanVietNamese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getMeanVietNamese() {
        return meanVietNamese;
    }

    public void setMeanVietNamese(String meanVietNamese) {
        this.meanVietNamese = meanVietNamese;
    }
}
