package com.example.Isolation_APITest.models;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class Location {
    //    @XmlAttribute
    private double latitude;
    //    @XmlAttribute
    private double longitude;
    //    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
////    @XmlElement
//    private Link link;

    //Getters
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    //Setters
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public Location(){

    }
    @Override
    public String toString() {
        return "Location{" +  " Latitude=" + latitude + ", longitude=" + longitude + '}';
    }


}

