package com.example.englishproject;

import android.os.Parcel;
import android.os.Parcelable;

import static android.os.UserHandle.readFromParcel;

public class Sentence implements Parcelable{
    private int ID;
    private String PART1;
    private String PART2;
    private String PART3;
    private String ANSWER;
    private String RULE;
    public Sentence()
    {
        ID=0;
        PART1="";
        PART2="";
        PART3="";
        ANSWER="";
        RULE="";
    }
    public Sentence(String pART1, String pART2, String pART3,
                    String aNSWER, String rULE) {

        PART1 = pART1;
        PART2 = pART2;
        PART3 = pART3;
        ANSWER = aNSWER;
        RULE = rULE;
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
    public String getRULE() { return RULE; }
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
    public void setRULE(String rULE) { RULE = rULE; }


    public Sentence(Parcel in){
        super();
        readFromParcel(in);
    }

    public static final Parcelable.Creator<Sentence> CREATOR = new Parcelable.Creator<Sentence>() {
        public Sentence createFromParcel(Parcel in){
            return new Sentence(in);
        }

        public Sentence[] newArray(int size){
            return new Sentence[size];
        }
    };

    public void readFromParcel(Parcel in){
        ID=in.readInt();
        PART1=in.readString();
        PART2=in.readString();
        PART3=in.readString();
        ANSWER=in.readString();
        RULE=in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(PART1);
        dest.writeString(PART2);
        dest.writeString(PART3);
        dest.writeString(ANSWER);
        dest.writeString(RULE);
    }
}