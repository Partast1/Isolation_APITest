package com.example.Isolation_APITest.DAOImplementations;

import com.example.Isolation_APITest.DAO.PlaceDao;
import com.example.Isolation_APITest.handlers.DeSerializer;
import com.example.Isolation_APITest.handlers.ServerHandler;
import com.example.Isolation_APITest.models.Location;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class PlaceDAOImp implements PlaceDao {

    public static List<Location> locations = new ArrayList<>();

    @Override
    public List<Location> getLocations() {


        ServerHandler sHandler = new ServerHandler();
        DeSerializer deserializer = new DeSerializer();

        String sLocations = null;
        List<Location> templocations = new ArrayList<>();

        try {
            sLocations = sHandler.getLocations();
            templocations = deserializer.DeserializeLocations(sLocations);
        } catch (Exception e) {

        } finally {
            return templocations;

        }
    }
//    public Response getPlaces() {
//
//        List<Location> locations = new ArrayList<>();
//
//        locations.add(new Location(55.545545, 35.353535));
//        locations.add(new Location(23.414141, 89.131315));
//        locations.add(new Location(23.232323, 81.123564));
//
//        return Response
//                .status(Response.Status.OK)
//                .entity(locations)
//                .build();
//    }

    @Override
    public List<Location> ListAll() {
        List<Location> locations = new ArrayList();

        locations = getLocations();
        return new ArrayList<Location>(locations);
    }

    @Override
    public void NewLocation(List<Location> locations) {
        for (Location loc: locations) {
            apiLocations.add(loc);
        }
    }
}
