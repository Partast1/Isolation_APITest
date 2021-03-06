package com.example.Isolation_APITest.resources;

import com.example.Isolation_APITest.CORSAllow;
import com.example.Isolation_APITest.DAOImplementations.PlaceDAOImp;
import com.example.Isolation_APITest.handlers.DeSerializer;
import com.example.Isolation_APITest.handlers.ServerHandler;


import com.example.Isolation_APITest.DAO.LocationDAO;
import com.example.Isolation_APITest.handlers.dbHandlerTest;
import com.example.Isolation_APITest.models.Location;


import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Path("/locations")
//@ApplicationPath("/resources")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LocationResource implements Runnable {
    private LocationDAO dao = LocationDAO.getInstance();

    PlaceDAOImp placeDAOImp = new PlaceDAOImp();
    CORSAllow corsAllow = new CORSAllow();

//public LocationResource(){
//    placeDAOImp.locations = placeDAOImp.getLocations();
//}


    String testString = null;
    DeSerializer deSerializer = new DeSerializer();
    //http://localhost:8080/Isolation_API-1.0-SaNAPSHOT/api/resources/laocations/getlocations


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getLocations() {
        ServerHandler handler = new ServerHandler();
        List<Location> locations = new ArrayList<Location>();
//        locations = placeDAOImp.getLocations();
        testString= handler.getLocations();

        return "Test: " + testString;
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response NewLocation(Location location){
        return Response.status(201).entity(location).build();


//        placeDAOImp.NewLocation(locations);
    }

    @Override
    public void run() {

    }


//        locations = DeSerializer.DeserializeLocations(deserializedLocations);
//        for (Location location:locations) {
//            System.out.println("Latitudehej: " +location.getLatitude() + " Longitude: " + location.getLongitude());
//
//        }

}



