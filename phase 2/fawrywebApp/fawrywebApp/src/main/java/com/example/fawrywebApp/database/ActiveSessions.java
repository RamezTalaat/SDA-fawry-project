package com.example.fawrywebApp.database;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.fawrywebApp.model.IGeneralUser;
import com.example.fawrywebApp.model.Person;
import com.example.fawrywebApp.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.Vector;

public class ActiveSessions {
    public static Map<UUID, IGeneralUser> sessions;
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

    public void addSession (UUID uuid , IGeneralUser user){
        sessions.put(uuid , user);
      
    }
    public void removeSession(UUID uuid){
        sessions.remove(uuid);
    }
    public boolean checkSession (UUID uuid){
        return sessions.containsKey(uuid);
        
    }
    public IGeneralUser checkSessionByUser (User user){
    	for(Map.Entry<UUID, IGeneralUser> s : sessions.entrySet()) {
    		if(s.getValue().getMail().equals(user.getMail()) && s.getValue().getPassword().equals(user.getPassword())) {
    			return s.getValue();
    		}
    	}
    	return null;
        
    }
    public IGeneralUser getUser (UUID uuid){
        return sessions.get(uuid);
    }
    public UUID getUUID (IGeneralUser user){
        for (Map.Entry mp : sessions.entrySet()) {
            User tmp = (User) mp.getValue();
            if(tmp.getMail().equals(user.getMail()) ){
                return (UUID) mp.getKey();
            }
        }
        return null;
    }
    public boolean checkUserSession(IGeneralUser user){

        System.out.println("checking request owner : " + user.getName());
        for (Map.Entry mp : sessions.entrySet()) {
            User tmp = (User) mp.getValue();
            if(tmp.getMail().equals(user.getMail()) ){
                return true;
            }
        }

        return false;
    }

    public void printDatabase() {
        IGeneralUser tmpUser;
        for (Map.Entry mp : sessions.entrySet()) {
            tmpUser =  (IGeneralUser) mp.getValue();
            System.out.println(mp.getKey() + "-> " + tmpUser.getName());
        }

    }
}
