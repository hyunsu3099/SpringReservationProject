package com.springreservation.web.dto;

import com.springreservation.web.entity.Board;

public class BoardDto {
    private int id;
    private String userName;
    private String content;
    private String title;
    private String regDate;
    private String editDate;
    private int hit;
    private int publish;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

    public int getPublish() {
        return publish;
    }

    public void setPublish(int publish) {
        this.publish = publish;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Board getBoard(){
        Board board = new Board();
        board.setContent(content);
        if(publish==1)board.setPublish(true);
        board.setTitle(title);
        board.setUserName(userName);

        return board;
    }
    
}
