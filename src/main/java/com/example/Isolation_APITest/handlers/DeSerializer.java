package com.example.Isolation_APITest.handlers;

import com.example.Isolation_APITest.models.Location;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class DeSerializer {

    public static List<Location> DeserializeLocations(String serializedLocations){
        Gson gson = new Gson();
        List<Location> locations = new ArrayList<Location>();


            locations.add(gson.fromJson(serializedLocations, Location.class));

        return locations;

    }
}
