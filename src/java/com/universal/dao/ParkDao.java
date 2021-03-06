package com.universal.dao;

import com.universal.common.CommonToolClass;
import com.universal.dto.Park;
import com.universal.dto.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 */
public class ParkDao {

    

    
    public static Park getParkRecord(int id) {
         Session session = CommonToolClass.getSession();
         System.out.println("=================&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&====================");
         Park park=(Park)session.get(Park.class, id);
         System.out.println("======================"+park+"=============================");
         System.out.println(park.getCity());
         System.out.println(park.getAfees());
         System.out.println(park.getCfees());
         System.out.println(park.getCtime());
         System.out.println(park.getEmail());
         System.out.println(park.getImagename());
         System.out.println(park.getLocation());
         System.out.println(park.getSotime());
         return park;
    }
    
    
    public static ArrayList<Park> getParkList(){
        ArrayList<Park> parkList=new ArrayList<>();
         Session session = CommonToolClass.getSession();
        Query query = session.createQuery("from Park");
        List list = query.list();
        for(Object object : list) {
            Park park=(Park)object;
        parkList.add(park);
        }
        return parkList;
    
}
       
    public static void addParkRecord(Park park) {
       Session session = CommonToolClass.getSession();
         session.save(park);
        session.beginTransaction().commit();
       }
}