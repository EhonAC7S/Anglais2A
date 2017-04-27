package com.example.englishproject.courses.dataelement;

import android.os.Parcel;
import android.os.Parcelable;

public class CourseContents implements Parcelable{
    private String ID;
    private String Title;
    private String desc;
    private String Exemple1;
    private String Exemple2;
    private String RULE;
    public CourseContents()
    {
        ID="";
        Title ="";
        desc ="";
        Exemple1 ="";
        Exemple2 ="";
        RULE="";
    }
    public CourseContents(String title, String descr, String exmpl1,
                          String exmpl2, String rULE) {

        ID = rULE;
        Title = title;
        desc = descr;
        Exemple1 = exmpl1;
        Exemple2 = exmpl2;
        RULE = rULE;
    }
    public String getID()
    {
        return ID;
    }
    public String getTitle() {
        return Title;
    }
    public String getDesc() {
        return desc;
    }
    public String getExemple1() {
        return Exemple1;
    }
    public String getExemple2() {
        return Exemple2;
    }

    public String getRULE() { return RULE; }
    public void setID(String id)
    {
        ID=id;
    }
    public void setTitle(String pART1) {
        Title = pART1;
    }
    public void setDesc(String pART2) {
        desc = pART2;
    }
    public void setExemple1(String pART3) {
        Exemple1 = pART3;
    }
    public void setExemple2(String pART3) {
        Exemple2 = pART3;
    }
    public void setRULE(String rULE) { RULE = rULE; }


    public CourseContents(Parcel in){
        super();
        readFromParcel(in);
    }

    public static final Creator<CourseContents> CREATOR = new Creator<CourseContents>() {
        public CourseContents createFromParcel(Parcel in){
            return new CourseContents(in);
        }

        public CourseContents[] newArray(int size){
            return new CourseContents[size];
        }
    };

    public void readFromParcel(Parcel in){
        ID=in.readString();
        Title =in.readString();
        desc =in.readString();
        Exemple1 =in.readString();
        Exemple2 = in.readString();
        RULE=in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ID);
        dest.writeString(Title);
        dest.writeString(desc);
        dest.writeString(Exemple1);
        dest.writeString(Exemple2);
        dest.writeString(RULE);
    }
}