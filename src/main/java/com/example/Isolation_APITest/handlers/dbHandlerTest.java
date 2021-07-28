package com.example.Isolation_APITest.handlers;


import com.example.Isolation_APITest.models.Location;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dbHandlerTest {
    protected Connection Connect(){
        Connection con = null;
        try{
//            synchronized (this) {
//                Class.forName("com.mysql.jdbc.Driver");
//            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/BiografDB?useSSL=false", "root", "P@ssW0rd");
//            }

        }catch(Exception e){ System.out.println(e);}
        finally{
            return con;
        }


    }
    public Location ReadPosition(){

        Location location = null;

        Connection con = Connect();
        try{
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select Latitude, Longitude from Coordinates");

            while(rs.next())
                location = new Location(rs.getDouble("Latitude"),rs.getDouble("Longitude"));
            System.out.println("Lati:" + rs.getString(1)+"  "+ "Long:" + rs.getString(2));
            con.close();

        }
        catch(Exception e){ System.out.println(e);}
        finally{
            return location;

        }
    }
    //Retunere all Locations i listform
    public List<Location> ReadPositions(){

        List<Location> locations = new ArrayList<Location>();
//        synchronized (this) {
        try {
            Connection con = Connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select Latitude, Longitude from Coordinates");

            while (rs.next())
                locations.add(new Location(rs.getDouble("Latitude"), rs.getDouble("Longitude")));
            rs.close();
            stmt.close();
            con.close();

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }  finally {
            return locations;

        }
    }
}
