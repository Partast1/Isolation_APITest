package com.example.Isolation_APITest.handlers;

import com.example.Isolation_Server.Services.LocationService;

import java.util.ArrayList;
import java.util.List;

public class ServerHandler {
    List<String> deserializedLocations = new ArrayList<String>();

    public List<String> getLocations(){

        LocationService lService = new LocationService();

        try {
            deserializedLocations = lService.GetSerializedLocations();}
        catch (Exception e){}
        finally{return deserializedLocations;}


    }


}
