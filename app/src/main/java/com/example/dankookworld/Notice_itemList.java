package com.example.dankookworld;

import java.util.Date;

public class Notice_itemList {

    private int profile_image;
    private String nickname;
    private String title;
    private String write_date;
    private String content;

    public Notice_itemList(int profile_image, String nickname, String title, String write_date, String content) {
        this.profile_image = profile_image;
        this.nickname = nickname;
        this.title = title;
        this.write_date = write_date;
        this.content = content;
    }

    public int getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWrite_date() {
        return write_date;
    }

    public void setWrite_date(String write_date) {
        this.write_date = write_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
