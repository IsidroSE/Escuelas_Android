package com.example.isidr.schoolsisidro.Model;

/*Created by Isidr on 28/11/2015.*/

public class School {
    private int Code;
    private String Name;
    private int Town;
    private String Kind_of_School;
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

    public int getTown() {
        return Town;
    }

    public void setTown(int town) {
        Town = town;
    }

    public String getKind_of_School() {
        return Kind_of_School;
    }

    public void setKind_of_School(String kind_of_School) {
        Kind_of_School = kind_of_School;
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
