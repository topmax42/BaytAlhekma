package com.example.baytalhekma.Models;

import java.io.Serializable;

public class Course implements Serializable {
    public int getImage() {
        return CourseImage;
    }

    public void setImage(int image) {
        this.CourseImage = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getSubBooks() {
        return subBooks;
    }

    public void setSubBooks(String[] subBooks) {
        this.subBooks = subBooks;
    }

    private int CourseImage;
    private int price;
    private String Name;
    private String description;
    private String[] subBooks;

}
