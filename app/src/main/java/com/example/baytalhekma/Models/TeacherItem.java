package com.example.baytalhekma.Models;

public class TeacherItem {
    public int getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(int faceImage) {
        this.faceImage = faceImage;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherDescription() {
        return teacherDescription;
    }

    public void setTeacherDescription(String teacherDescription) {
        this.teacherDescription = teacherDescription;
    }

    private int faceImage;
    private String teacherName;
    private String teacherDescription;

}
