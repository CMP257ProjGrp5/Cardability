package com.cardability.application;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


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

    private int colorR;
    private int colorG;
    private int ColorB;

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

    public int getColorR() {
        return colorR;
    }

    public void setColorR(int colorR) {
        this.colorR = clampRGB(colorR);
    }

    public int getColorG() {
        return colorG;
    }

    public void setColorG(int colorG) {
        this.colorG = clampRGB(colorG);
    }

    public int getColorB() {
        return ColorB;
    }

    public void setColorB(int colorB) {
        ColorB = clampRGB(colorB);
    }
}
