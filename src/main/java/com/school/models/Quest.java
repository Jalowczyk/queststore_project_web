package com.school.models;

public class Quest {

    private String title;
    private String info;
    private Integer prize;
    private String category;
    private Integer id;

    public Quest(String title, String info, Integer prize, String questCategory){

        this.title = title;
        this.info = info;
        this.prize = prize;
        this.category = questCategory;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrize() {
        return prize;
    }

    public void setPrize(Integer prize) {
        this.prize = prize;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {

        return id;

    }
}
