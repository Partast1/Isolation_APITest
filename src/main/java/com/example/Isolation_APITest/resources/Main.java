package com.example.Isolation_APITest.resources;

import com.example.Isolation_APITest.DAOImplementations.PlaceDAOImp;
import com.example.Isolation_APITest.handlers.CustomClassLoader;
import com.example.Isolation_APITest.handlers.DeSerializer;
import com.example.Isolation_APITest.handlers.ServerHandler;
import com.example.Isolation_APITest.handlers.dbHandlerTest;
import com.example.Isolation_APITest.models.Location;

import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        PlaceDAOImp place = new PlaceDAOImp();
        List<Location> locations = new ArrayList<>();
        locations = place.getLocations();


        String serializedLocation = null;
        ServerHandler handler = new ServerHandler();
        serializedLocation = handler.getLocations();
        System.out.println("Locations" + serializedLocation);


        CustomClassLoader customClassLoader = new CustomClassLoader();
//        Class<?> c = customClassLoader.findClass("com.concretepage.lang.Test");
//        Object ob = c.newInstance();
//        Method md = c.getMethod("show");
//        md.invoke(ob);
//
//       System.out.println(customClassLoader.findClass("LocationService")) ;

//
//        for (Location loc: locations){
//            System.out.println("Latitide" + loc.getLatitude());
//        }

//
//        // Create a neat value object to hold the URL
//        String url = new String("http://localhost/Isolation_Server-1.0-SNAPSHOT/location-servlet");
//
//        Connection conn = DriverManager.getConnection(url);
//
//        connection.setRequestProperty("accept", "application/json");
//
//
//// Open a connection(?) on the URL(??) and cast the response(???)
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//// Now it's "open", we can set the request method, headers etc.
//
//// This line makes the request
//        InputStream responseStream = connection.getInputStream();
//
//// Manually converting the response body InputStream to APOD using Jackson
//        ObjectMapper mapper = new ObjectMapper();
//        APOD apod = mapper.readValue(responseStream, APOD.class);


//        PlaceDAOImp placeimp = new PlaceDAOImp();
//        List<Location> locations = new ArrayList<Location>();
//
//        locations = placeimp.getLocations();
//        for (Location loc: locations) {
//            System.out.println("Latitudehej: " +loc.getLatitude() + " Longitude: " + loc.getLongitude());
//        }

    }



    public void locationTester(){

    }
}
