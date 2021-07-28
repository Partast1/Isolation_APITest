package com.example.Isolation_APITest.DAO;

import com.example.Isolation_APITest.handlers.DeSerializer;
import com.example.Isolation_APITest.handlers.ServerHandler;
import com.example.Isolation_APITest.models.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationDAO {
    private static LocationDAO instance;
    private List<Location> locations = new ArrayList<>();



    public List<Location> getLocations() {
        ServerHandler sHandler = null;
        sHandler = new ServerHandler();
        DeSerializer deserializer = new DeSerializer();

        String sLocations = null;
        List<Location> locations = new ArrayList<>();

        try {
            sLocations = sHandler.getLocations();
            locations = deserializer.DeserializeLocations(sLocations);
        } catch (Exception e) {

        } finally {
            return locations;

        }
    }

    public List<Location> ListAll()
    {
        List<Location> locations = new ArrayList();

        locations = getLocations();
        return new ArrayList<Location>(locations);
    }

//        locations = DeSerializer.DeserializeLocations(deserializedLocations);




    public static LocationDAO getInstance() {
        if (instance == null) {
            instance = new LocationDAO();
        }

        return instance;
    }
//
//    public Location get(int id) {
//        id = locations.indexOf(productToFind);
//        if (id >= 0) {
//            return locations.get(id);
//        }
//        return null;
//    }

}
