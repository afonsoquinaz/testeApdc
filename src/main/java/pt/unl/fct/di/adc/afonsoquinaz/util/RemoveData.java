package pt.unl.fct.di.adc.afonsoquinaz.util;

import java.util.UUID;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class RemoveData {
	
	public String username1;
	public String username2;

	
	//public static final long EXPIRATION_TIME = 1000*60*60*2; //2h
	
	public RemoveData() {
		
	}
	
	public RemoveData(String username1 , String username2) {
		this.username1 = username1;
		this.username2 = username2;

	}
	
	public boolean canRemove(String username1 , String username2, String role1 , String role2) {
		
		
		if(username1.equals("USER") && !(username1.equals(username2))) {
			return false;
		}
		
		
		if(username1.equals("GBO") && !(username1.equals(username2))) {
			return false;
		}
		
		if(username1.equals("GA") && (username2.equals("GA") ||  username2.equals("SU")) && !(username1.equals(username2))) {
			return false;
		}
		
		
		return true;
	}
	
	
}
