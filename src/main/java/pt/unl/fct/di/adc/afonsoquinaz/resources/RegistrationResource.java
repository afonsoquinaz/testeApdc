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

@Path("/register")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RegistrationResource {

	private static final Logger LOG = Logger.getLogger(LoginResource.class.getName());

	private final Gson g = new Gson();

	private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

	
	public RegistrationResource() {

	}

	@POST
	@Path("/v1")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doRegistV1(RegisterData data) {
		LOG.fine("Attetmped to registerUser : " + data.username);

		// Check input data

		Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username);
		Entity person = Entity.newBuilder(userKey).set("user_pwd", DigestUtils.sha512Hex(data.password))
				.set("user_creation_time", Timestamp.now()).build();

		datastore.put(person);

		LOG.info("User registered" + data.username);
		return Response.ok("{Criou user}").build();
	}
	
	
	
	@POST
	@Path("/v3")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doRegisterV2(RegisterData data) {
		LOG.fine("Attempt to register user: " + data.username);
		
		Transaction txn = datastore.newTransaction();
		try {
			Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username);
			Entity user = txn.get(userKey);
			if(user != null) {
				txn.rollback();
				return Response.status(Status.BAD_REQUEST).entity("User already exists.").build();
			}else {
				user = Entity.newBuilder(userKey).set("user_name", data.username)
						.set("user_pwd", DigestUtils.sha3_512Hex(data.password))
						.set("user_email", data.email)
						.set("user_creation_time", Timestamp.now()).build();
				txn.add(user);
				LOG.info("User registered "+ data.username);
				txn.commit();
				return Response.ok("{Criou user}").build();
			}

		} finally {
			if(txn.isActive()) {
				txn.rollback();
			}
		}
		
	}
	
	
	@POST
	@Path("/v9")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doRegistration(RegisterData data) {
		LOG.fine("Attempt to create user: " + data.username);
		
		//valid registration
		
		Transaction txn = datastore.newTransaction();
		
		try {
			Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username);
			Entity user = txn.get(userKey);
			if(user != null) {
				txn.rollback();
				return Response.status(Status.BAD_REQUEST).entity("User already exists.").build();
			}
			else {
				user = Entity.newBuilder(userKey)
						.set("user_pwd",DigestUtils.sha512Hex(data.password))
						.set("email", data.email)
						.set("username_name", data.name)
						.set("user_profile", data.isPublic)
						.set("user_tFixo", data.tFixo)
						.set("phone", data.tMovel)
						.set("user_nif", data.nif)
						.set("user_creation_time", Timestamp.now())
						.build();
				txn.add(user);
				LOG.info("User Registered with username: " + data.username);
				txn.commit();
				return Response.ok("{}").build();
			}
		}
		finally {
			if(txn.isActive())
				txn.rollback();
		}
	}
	
	
	@POST
	@Path("/v10")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doRegisterV10(RegisterData data) {
		LOG.fine("Attempt to register v10 user: " + data.username);
		
		Transaction txn = datastore.newTransaction();
	
		try {
			Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username);
			Entity user = txn.get(userKey);
			if(user != null) {
				txn.rollback();
				return Response.status(Status.BAD_REQUEST).entity("User already exists.").build();
			}else {
				user = Entity.newBuilder(userKey)
						.set("user_pwd", DigestUtils.sha512Hex(data.password))
						.set("user_email", data.email)
						.set("username_name", data.name)
						.set("user_isPublic", data.isPublic)
						.set("user_tFixo", data.tFixo)
						.set("user_tMovel", data.tMovel)
						.set("user_nif", data.nif)
						.set("user_creation_time", Timestamp.now()).build();
						
				txn.add(user);
				LOG.info("User registered "+ data.username);
				txn.commit();
				return Response.ok("{Criou user}").build();
			}

		} finally {
			if(txn.isActive()) {
				txn.rollback();
			}
		}
		
	}
	
	
	@POST
	@Path("/v11")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doRegisterV11(RegisterData data) {
		LOG.fine("Attempt to register v11 user: " + data.username);
		
		Transaction txn = datastore.newTransaction();
	
		try {
			Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username);
			Entity user = txn.get(userKey);
			if(user != null) {
				txn.rollback();
				return Response.status(Status.BAD_REQUEST).entity("User already exists.").build();
			}else {
				user = Entity.newBuilder(userKey)
						.set("user_pwd", DigestUtils.sha512Hex(data.password))
						.set("user_email", data.email)
						.set("username_name", data.name)
						.set("user_isPublic", data.isPublic)
						.set("user_tFixo", data.tFixo)
						.set("user_tMovel", data.tMovel)
						.set("user_nif", data.nif)
						.set("user_creation_time", Timestamp.now())
						.set("user_role", data.role).build();
						
				txn.add(user);
				LOG.info("User registered "+ data.username);
				txn.commit();
				return Response.ok("{Criou user11}").build();
			}

		} finally {
			if(txn.isActive()) {
				txn.rollback();
			}
		}
		
	}
	
	
	

}
