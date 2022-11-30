package com.springreservation.web.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.springreservation.web.dto.BoardDto;

public class Board {
    private int id;
    private String title;
    private String userName;
    private Date regDate;
    private Date editDate;
    private boolean publish;
    private String content;
    private int hit;
    @Override
    public String toString() {
        return "Board [id=" + id + ", title=" + title + ", userName=" + userName + ", regDate=" + regDate
                + ", editDate=" + editDate + ", publish=" + publish + ", content=" + content + ", hit=" + hit + "]";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    public Date getEditDate() {
        return editDate;
    }
    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }
    public boolean isPublish() {
        return publish;
    }
    public void setPublish(boolean publish) {
        this.publish = publish;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getHit() {
        return hit;
    }
    public void setHit(int hit) {
        this.hit = hit;
    }

    public BoardDto getBoardDto(){
        BoardDto boardDto = new BoardDto();
        boardDto.setId(id);
        boardDto.setContent(content);
        boardDto.setPublish((publish) ? 1 : 0);
        boardDto.setTitle(title);
        boardDto.setUserName(userName);
        boardDto.setHit(hit);
        if(editDate!=null) boardDto.setEditDate(dateToStringyyyymmdd(editDate));
        if(regDate!=null) boardDto.setRegDate(dateToStringyyyymmdd(regDate));
        return boardDto;
    }



    private String dateToStringyyyymmdd(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
}
