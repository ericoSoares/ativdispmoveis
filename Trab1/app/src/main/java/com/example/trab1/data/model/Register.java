package com.example.trab1.data.model;

import java.util.ArrayList;

public class Register {
    public String date;
    public String place;
    public ArrayList<GeolocalPoint> points;

    public Register() {
        this.date = "";
        this.place = "";
        this.points = new ArrayList<GeolocalPoint>();
    }

    public Register(String date, String place, ArrayList<GeolocalPoint> points) {
        this.date = date;
        this.place = place;
        this.points = points;
    }
}
