package com.example.Isolation_APITest.DAO;

import com.example.Isolation_APITest.models.Location;

import java.util.ArrayList;
import java.util.List;

public interface PlaceDao {
    List<Location> apiLocations = null;

     List<Location> getLocations() ;
     List<Location> ListAll();
     void NewLocation(List<Location> location);
}
