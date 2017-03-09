package com.example.isidr.schoolsisidro.Model;

/*Created by Isidro on 28/11/2015.*/

public class Town {
    private int Code;
    private String Name;
    private long Lat;
    private long Lon;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getLat() {
        return Lat;
    }

    public void setLat(long lat) {
        Lat = lat;
    }

    public long getLon() {
        return Lon;
    }

    public void setLon(long lon) {
        Lon = lon;
    }
}
