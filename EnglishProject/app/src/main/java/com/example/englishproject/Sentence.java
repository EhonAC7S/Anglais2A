package com.example.englishproject;

public class Sentence {
    private int ID;
    private String PART1;
    private String PART2;
    private String PART3;
    private String ANSWER;
    public Sentence()
    {
        ID=0;
        PART1="";
        PART2="";
        PART3="";
        ANSWER="";
    }
    public Sentence(String pART1, String pART2, String pART3,
                    String aNSWER) {

        PART1 = pART1;
        PART2 = pART2;
        PART3 = pART3;
        ANSWER = aNSWER;
    }
    public int getID()
    {
        return ID;
    }
    public String getPART1() {
        return PART1;
    }
    public String getPART2() {
        return PART2;
    }
    public String getPART3() {
        return PART3;
    }
    public String getANSWER() {
        return ANSWER;
    }
    public void setID(int id)
    {
        ID=id;
    }
    public void setPART1(String pART1) {
        PART1 = pART1;
    }
    public void setPART2(String pART2) {
        PART2 = pART2;
    }
    public void setPART3(String pART3) {
        PART3 = pART3;
    }
    public void setANSWER(String aNSWER) {
        ANSWER = aNSWER;
    }

}