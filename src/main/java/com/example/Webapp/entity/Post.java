package com.example.Webapp.entity;

import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "createby")
    private String createBy;

    @Column(name = "creationdate")
    private String creationDate;

    public void setCreationDate() {
//    	現在日時の取得
    	java.util.Date nowDate = new java.util.Date();
//    	yyyy/MM/dd形式にフォーマットするオブジェクトを生成
    	SimpleDateFormat fomatter = new SimpleDateFormat("yyyy/MM/dd");
    	this.setCreationDate(fomatter.format(nowDate));
    }
}
