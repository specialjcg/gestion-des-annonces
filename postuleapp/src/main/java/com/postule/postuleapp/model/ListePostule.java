package com.postule.postuleapp.model;

import java.io.Serializable;

import java.util.Date;


import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "ListePostule")
@EntityListeners(AuditingEntityListener.class)
public class ListePostule implements Serializable {

    public ListePostule() {
    }

    private static final long serialVersionUID = 1L;
	public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return this.time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSrcimg() {
        return this.srcimg;
    }

    public void setSrcimg(String srcimg) {
        this.srcimg = srcimg;
    }

    public Chiplist getFeatures() {
        return this.features;
    }

    public void setFeatures(Chiplist features) {
        this.features = features;
    }

    public String getTarget() {
        return this.target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public ListePostule(Long id,
String text,
Date time,
String srcimg,
Chiplist features,
String target) {

        this.text = text;
        this.time = time;
        this.srcimg = srcimg;
        this.features = features;
        this.target = target;
    }
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id  
    @Column(name="id")
    private Long id;
    @Column(name="text")
    private String text;
    @Column(name="time")
    private Date time;
    @Column(name="srcimg")
    private String srcimg;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "features", referencedColumnName = "id")
    private Chiplist features;
    @Column(name="target")
    private String target;

}