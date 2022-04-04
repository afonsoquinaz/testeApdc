package pt.unl.fct.di.adc.afonsoquinaz.util;

public class UpdatePass {

	public String username;
	public String password;
	public String confirmation;
	
	public String email;
	
	
	public String tMovel;
	public UpdatePass() {
		
	}
	
	public UpdatePass(String username, String password, String confirmation) {
		this.password = password;
		this.username = username;
		this.confirmation = confirmation;
		this.email = "";
		this.tMovel = "";
	}
	
	public UpdatePass(String username, String email) {
		this.password = "";
		this.username = username;
		this.confirmation = "";
		this.email = email;
		this.tMovel = "";
		
	}
	
	public UpdatePass(String username, String email, String password, String tMovel) {
		this.password = "";
		this.username = username;
		this.confirmation = "";
		this.email = "";
		this.tMovel = tMovel;
	}
	
}
