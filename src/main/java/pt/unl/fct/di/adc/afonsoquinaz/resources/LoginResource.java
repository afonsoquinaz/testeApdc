package pt.unl.fct.di.adc.afonsoquinaz.resources;

import java.util.logging.Logger;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.commons.codec.digest.DigestUtils;
import com.google.cloud.Timestamp;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Transaction;
import com.google.gson.Gson;
import pt.unl.fct.di.adc.afonsoquinaz.util.AuthToken;
import pt.unl.fct.di.adc.afonsoquinaz.util.LoginData;
import pt.unl.fct.di.adc.afonsoquinaz.util.RegisterData;


@Path("/login")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class LoginResource {

	
	/**
	 * A logger Object
	 */
	private static final Logger LOG = Logger.getLogger(LoginResource.class.getName());
	
	private final Gson g = new Gson();
	
	private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

	
	
	public LoginResource() {
		
	}
	
	@POST 
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doLogin(LoginData data) {
		
		//LOG.fine("Login attempt by user: " + data.username);
		
		LOG.fine("Attemp to login user: " + data.username);
		
		
		
		
		
		Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username);
		//Entity user = datastore.get(userKey);
		
		if(data.username.equals("jleitao") && data.password.equals("password")) {
			AuthToken at = new AuthToken(data.username);
			return Response.ok(g.toJson(at)).build();
		}
		
		return Response.status(Status.FORBIDDEN).entity("Incorrect username or password.").build();
	}
	@POST 
	@Path("/v1")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response doLoginv1(LoginData data) {
		
		LOG.fine("Login attempt by user: " + data.username);
		//is it really like this?
		//Key userKey = datastore.newKeyFactory().newKey(data.username);
		
		//Key userKey = userKeyFactory.newKey(data.username);
		
		//Entity user = datastore.get();
		
		
		//if(user != null) {
		//	String hashedPWD = user.getString("user_pwd");
		//	if(hashedPWD.equals(DigestUtils.sha3_512Hex(data.password))) {
		//		AuthToken token = new AuthToken(data.username);
		//		LOG.info("User " + data.username + "logged in successfully");
		//		return Response.ok(g.toJson(token)).build();
				
				
		//	}else {
		//		LOG.warning("Wrong password for username: " + data.username);
		//		return Response.status(Status.FORBIDDEN).build();
		//	}
		//}
		
		
		return Response.status(Status.FORBIDDEN).entity("IIncorrect username or password.").build();
	}
	
	

	@GET
	@Path("/{username}")
	public Response checkUsernameAvailable(@PathParam("username") String username) {
		if(!username.trim().equals("jleitao")) {
			return Response.ok().entity(g.toJson(true)).build();
		} else {
			return Response.ok().entity(g.toJson(false)).build();
		}
	}
	

	@POST
	@Path("/v10")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response doLogin10(LoginData data) {
		
		LOG.fine("Attemp to login user: " + data.username);
		
		Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username);
		Entity user = datastore.get(userKey);
		
		if(user != null) {
			String hashedPWD = user.getString("user_pwd");
			 if(hashedPWD.equals(DigestUtils.sha512Hex(data.password))) {
				AuthToken token = new AuthToken(data.username);
			LOG.info("User '" + data.username + "' logged in succesefully.");
				return Response.ok(g.toJson(token)).build();
			}else {
				LOG.warning("Wrong password for username: " + data.username);
				return Response.status(Status.FORBIDDEN).build();
				
			}
				//LOG.info("User '" + data.username + "' logged in succesefully.");
			
			
		}else {
			LOG.warning("Wrong password for username: " + data.username);
			return Response.status(Status.FORBIDDEN).build();
		}
		
		//return Response.status(Status.FORBIDDEN).entity("Incorrect username or password.").build();

	}
	
	
		
	@POST
	@Path("/v11")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response doLogin11(LoginData data) {
		
		LOG.fine("Attemp to login user: " + data.username);
		
		Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username);
		Entity user = datastore.get(userKey);
		
		if(user != null) {
			String hashedPWD = user.getString("user_pwd");
			 if(hashedPWD.equals(DigestUtils.sha512Hex(data.password))) {
				AuthToken token = new AuthToken(data.username);
			LOG.info("User '" + data.username + "' logged in succesefully.");
				return Response.ok(g.toJson(token)).build();
			}else {
				LOG.warning("Wrong password for username: " + data.username);
				return Response.status(Status.FORBIDDEN).build();
				
			}
				//LOG.info("User '" + data.username + "' logged in succesefully.");
			
			
		}else {
			LOG.warning("Wrong password for username: " + data.username);
			return Response.status(Status.FORBIDDEN).build();
		}
		
		//return Response.status(Status.FORBIDDEN).entity("Incorrect username or password.").build();

	}
	
	
	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response doLoginUser(LoginData data) {
		
		LOG.fine("Attemp to login user: " + data.username);
		
		Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username);
		Entity user = datastore.get(userKey);
		
		if(user != null) {
					return Response.ok(g.toJson(user)).build();
		}else {
			LOG.warning("User does not exist: " + data.username);
			return Response.status(Status.FORBIDDEN).build();
		}
		
		//return Response.status(Status.FORBIDDEN).entity("Incorrect username or password.").build();

	}
	

	
	
	
	
}
