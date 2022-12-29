package com.example.fawrywebApp.database;
import java.util.Vector;

import com.example.fawrywebApp.model.RefundRequest;


public class RefundRequestDatabase {
	private static RefundRequestDatabase instance = null;
	public Vector<RefundRequest> refundRequests ;
	
	private RefundRequestDatabase() {   // to implement singleton pattern , to only be able to make instance of DB 
		// TODO Auto-generated constructor stub
		refundRequests = new Vector <RefundRequest> ();
	}
	
	public static RefundRequestDatabase  getInstance() {
		if(instance == null) {
			instance = new RefundRequestDatabase();
		}
		return instance;
	}
	
	

}

