package pt.unl.fct.di.adc.afonsoquinaz.util;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class UpdateRole {

	public String username1;
	public String username2;
	public String newRole;
	
	public UpdateRole() {
		
	}
	
	public UpdateRole(String username1, String username2, String newRole) {
		this.username1 = username1;
		this.username2 = username2;
		this.newRole = newRole;

	}
	
	public boolean canUpdate(String role1, String role2, String finalRole) {

		if( role1.equals("SU") || ( (role1.equals("GA") || role1.equals("GBO") )&& role2.equals("USER") && finalRole.equals("GBO"))) {
			return true;
		}
		return false;	
	}
}