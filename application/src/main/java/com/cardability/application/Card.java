package com.cardability.application;

import jakarta.persistence.*;

@Table(schema = "Card")
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    private String description;

    public static int clampRGB(int val) {
        return (int) Math.max(0, Math.min(255, val));
    }

    private int r;
    private int g;
    private int b;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = clampRGB(r);
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = clampRGB(g);
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = clampRGB(b);
    }
}
