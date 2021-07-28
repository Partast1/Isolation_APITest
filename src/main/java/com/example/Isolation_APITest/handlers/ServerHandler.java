package com.example.Isolation_APITest.handlers;

import Services.LocationService;


public  class ServerHandler implements Runnable {
//    CustomClassLoader<LocationService> customClassLoader = new CustomClassLoader<LocationService>();






        String deserializedLocations;
    public  String getLocations(){
        try {
            LocationService locationService;

            locationService = (LocationService) Class.forName("Services.LocationService").newInstance();
            System.out.println("test " + locationService.toString());

//            locationService = customClassLoader.LoadClass("C:\\Users\\asdf\\source\\repos\\Java\\Isolation_Backend\\out\\artifacts\\Isolation_Backend_jar",
//                    "com.example.Isolation_Backend",
//                    LocationService.class);


//            Class.forName("Services.LocationService");

             deserializedLocations = locationService.GetSerializedLocations();


//            Class.forName("Services.LocationService").newInstance();

        }catch (ClassNotFoundException e)
        {System.out.println(e);} catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return deserializedLocations;







    }



    @Override
    public void run() {

    }
}
