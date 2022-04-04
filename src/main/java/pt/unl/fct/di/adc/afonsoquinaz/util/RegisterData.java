package pt.unl.fct.di.adc.afonsoquinaz.util;


public class RegisterData {
	public String username;
	public String email;
	public String name;
	public String password;
	public String confirmation;
	
	public String isPublic;
	public String tFixo;
	public String tMovel;
	public String nif;
	
	public String role;
	

	public RegisterData() {
		
		this.username = null;
		this.password = null;
		this.confirmation = null;
		this.email = null;
		this.name = null;
		this.isPublic = null;
		this.tFixo = null;
		this.tMovel = null;
		this.nif = null;
		this.role = null;
	}
	public RegisterData(String username) {
		
		this.username = this.username;
		this.password = null;
		this.confirmation = null;
		this.email = null;
		this.name = null;
		this.isPublic = null;
		this.tFixo = null;
		this.tMovel = null;
		this.nif = null;
		this.role = null;
	}
	
	public RegisterData(String username, String password) {
		this.username = username;
		this.password = password;
		this.confirmation = null;
		this.email = null;
		this.name = null;
		this.isPublic = null;
		this.tFixo = null;
		this.tMovel = null;
		this.nif = null;
		this.role = null;
		
	}

	public RegisterData(String username, String password, String confirmation, String email, String name) {
		this.username = username;
		this.password = password;
		this.confirmation = confirmation;
		this.email = email;
		this.name = name;
		this.isPublic = null;
		this.tFixo = null;
		this.tMovel = null;
		this.nif = null;
		this.role = null;
	}
	
	public RegisterData(String username, String password, String confirmation, String email, String name, String isPublic,
			String tFixo, String tMovel, String nif) {
		this.username = username;
		this.password = password;
		this.confirmation = confirmation;
		this.email = email;
		this.name = name;
		this.isPublic = isPublic;
		this.tFixo = tFixo;
		this.tMovel = tMovel;
		this.nif = nif;
		this.role = null;
	}
	
	public RegisterData(String username, String password, String confirmation, String email, String name, String isPublic,
			String tFixo, String tMovel, String nif, String role) {
		this.username = username;
		this.password = password;
		this.confirmation = confirmation;
		this.email = email;
		this.name = name;
		this.isPublic = isPublic;
		this.tFixo = tFixo;
		this.tMovel = tMovel;
		this.nif = nif;
		this.role = role;
	}
}
