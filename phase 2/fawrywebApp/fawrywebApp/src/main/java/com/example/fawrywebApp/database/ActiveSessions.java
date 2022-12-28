package com.example.fawrywebApp.database;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.fawrywebApp.model.Person;
import com.example.fawrywebApp.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

public class ActiveSessions {
    public static Map<UUID, User> sessions;
    //public Vector<UUID> sessions ;
    private static ActiveSessions instance = null;
    private ActiveSessions(){
        sessions = new HashMap<>();
    }

    public static ActiveSessions getInstance() {
        if(instance == null) {
            instance = new ActiveSessions();
        }
        return instance;
    }

    public void addSession (UUID uuid , User user){
        sessions.put(uuid , user);
        //sessions.add(uuid);
    }
    public void removeSession(UUID uuid){
        sessions.remove(uuid);
    }
    public boolean checkSession (UUID uuid){
        return sessions.containsKey(uuid);
        //return sessions.contains(uuid);
    }
    public User getUser (UUID uuid){
        return sessions.get(uuid);
    }
    public UUID getUUID (User user){
        for (Map.Entry mp : sessions.entrySet()) {
            User tmp = (User) mp.getValue();
            if(tmp.getMail().equals(user.getMail()) ){
                return (UUID) mp.getKey();
            }
        }
        return null;
    }
    public boolean checkUserSession(User user){

        System.out.println("checking user + " + user.getName());
        for (Map.Entry mp : sessions.entrySet()) {
            User tmp = (User) mp.getValue();
            if(tmp.getMail().equals(user.getMail()) ){
                return true;
            }
        }

        return false;
    }

    public void printDatabase() {
        for (Map.Entry mp : sessions.entrySet()) {
           System.out.println(mp.getKey() + "-> " + mp.getValue());
        }

    }
}
