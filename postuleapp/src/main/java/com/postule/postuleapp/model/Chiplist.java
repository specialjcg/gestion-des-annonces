package com.postule.postuleapp.model;

import java.io.Serializable;

import javax.persistence.*;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@Table(name = "Chiplist")
@EntityListeners(AuditingEntityListener.class)
public class Chiplist implements Serializable{

    public Chiplist() {
    }

    private static final long serialVersionUID = 1L;

	public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChip1() {
        return this.chip1;
    }

    public void setChip1(String chip1) {
        this.chip1 = chip1;
    }

    public String getChip2() {
        return this.chip2;
    }

    public void setChip2(String chip2) {
        this.chip2 = chip2;
    }

    public String getChip3() {
        return this.chip3;
    }

    public void setChip3(String chip3) {
        this.chip3 = chip3;
    }

    public String getChip4() {
        return this.chip4;
    }

    public void setChip4(String chip4) {
        this.chip4 = chip4;
    }

    public String getChip5() {
        return this.chip5;
    }

    public void setChip5(String chip5) {
        this.chip5 = chip5;
    }

    public String getChip6() {
        return this.chip6;
    }

    public void setChip6(String chip6) {
        this.chip6 = chip6;
    }

    public String getChip7() {
        return this.chip7;
    }

    public void setChip7(String chip7) {
        this.chip7 = chip7;
    }

    public String getChip8() {
        return this.chip8;
    }

    public void setChip8(String chip8) {
        this.chip8 = chip8;
    }

    public String getChip9() {
        return this.chip9;
    }

    public void setChip9(String chip9) {
        this.chip9 = chip9;
    }

    public Chiplist(Long id,
String chip1,
String chip2,
String chip3,
String chip4,
String chip5,
String chip6,
String chip7,
String chip8,
String chip9) {
;
        this.chip1 = chip1;
        this.chip2 = chip2;
        this.chip3 = chip3;
        this.chip4 = chip4;
        this.chip5 = chip5;
        this.chip6 = chip6;
        this.chip7 = chip7;
        this.chip8 = chip8;
        this.chip9 = chip9;
    }

   
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @OneToOne(mappedBy = "chips")
    private ListePostule listePostule;
    @Column(name="chip1")
    private String chip1;

    @Column(name="chip2")
    private String chip2;

    @Column(name="chip3")
    private String chip3;

    @Column(name="chip4")
    private String chip4;

    @Column(name="chip5")
    private String chip5;

    @Column(name="chip6")
    private String chip6;

    @Column(name="chip7")
    private String chip7;

    @Column(name="chip8")
    private String chip8;

    @Column(name="chip9")
    private String chip9;


}