package com.example.Isolation_APITest.handlers;

import com.example.Isolation_APITest.models.Location;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class DeSerializer {

    public static List<Location> DeserializeLocations(List<String> serializedLocations){
        Gson gson = new Gson();
        List<Location> locations = new ArrayList<Location>();
        for (String sLocations: serializedLocations) {
            Location location = gson.fromJson(sLocations, Location.class);
            locations.add(location);
        }
        return locations;

    }
}
