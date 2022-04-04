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
import pt.unl.fct.di.adc.afonsoquinaz.util.RemoveData;
import pt.unl.fct.di.adc.afonsoquinaz.util.UpdatePass;
import pt.unl.fct.di.adc.afonsoquinaz.util.UpdateRole;

@Path("/update")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class UpdateResource {

	private static final Logger LOG = Logger.getLogger(LoginResource.class.getName());

	private final Gson g = new Gson();

	private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

	
	public UpdateResource() {

	}
	
	
	@POST
	@Path("/role")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateRole(UpdateRole data) {
		
	LOG.fine("Attempt to update role user: " + data.username2);
		
		Transaction txn = datastore.newTransaction();
		try {
		
			
			Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username2);
			Entity user = txn.get(userKey);
			
			Key userKey1 = datastore.newKeyFactory().setKind("User").newKey(data.username1);
			Entity user1 = txn.get(userKey1);
		
			if(!data.canUpdate(user1.getString("user_role"), user.getString("user_role"), data.newRole)) {
				return Response.status(Status.BAD_REQUEST).entity("ONLY SU USERS CAN CHANGE ROLES, OR GS IF CHANGING ROLE FROM USER TO GBO").build();
				
			}
			
			
				
				if(user == null) {
					txn.rollback();
					return Response.status(Status.BAD_REQUEST).entity("User does not exists.").build();
				}else {
					String user_email = user.getString("user_email");
					String username_name = user.getString("username_name");
					String user_isPublic = user.getString("user_isPublic");
					String user_tFixo = user.getString("user_tFixo");
					String user_tMovel = user.getString("user_tMovel");
					String user_nif = user.getString("user_nif");
					String user_role = user.getString("user_role");
					String user_pwd = user.getString("user_pwd");
					
					
					user = Entity.newBuilder(userKey)
							.set("user_pwd", user_pwd)
							.set("user_email", user_email)
							.set("username_name", username_name)
							.set("user_isPublic", user_isPublic)
							.set("user_tFixo", user_tFixo)
							.set("user_tMovel", user_tMovel)
							.set("user_nif", user_nif)
							.set("user_creation_time", Timestamp.now())
							.set("user_role", data.newRole).build();
					txn.update(user);
					
					//txn.delete(userKey);
					//txn.add(user);
					LOG.info("User updated "+ data.username2);
					txn.commit();
					return Response.ok("{User updated}").build();
				}

		} finally {
			if(txn.isActive()) {
				txn.rollback();
			}
		}
	}

	
	@POST
	@Path("/pass")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePass(UpdatePass data) {
		
	LOG.fine("Attempt to update pass user: " + data.username);
		
		Transaction txn = datastore.newTransaction();
		try {
		
			
			Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username);
			Entity user = txn.get(userKey);
			
				

				
				if(user == null) {
					txn.rollback();
					return Response.status(Status.BAD_REQUEST).entity("User does not exists.").build();
				}else {
					String user_email = user.getString("user_email");
					String username_name = user.getString("username_name");
					String user_isPublic = user.getString("user_isPublic");
					String user_tFixo = user.getString("user_tFixo");
					String user_tMovel = user.getString("user_tMovel");
					String user_nif = user.getString("user_nif");
					String user_role = user.getString("user_role");
					 
					
					
					user = Entity.newBuilder(userKey)
							.set("user_pwd", DigestUtils.sha512Hex(data.password))
							.set("user_email", user_email)
							.set("username_name", username_name)
							.set("user_isPublic", user_isPublic)
							.set("user_tFixo", user_tFixo)
							.set("user_tMovel", user_tMovel)
							.set("user_nif", user_nif)
							.set("user_creation_time", Timestamp.now())
							.set("user_role", user_role).build();
					txn.update(user);
					
					//txn.delete(userKey);
					//txn.add(user);
					LOG.info("User updated "+ data.username);
					txn.commit();
					return Response.ok("{User updated}").build();
				}

		} finally {
			if(txn.isActive()) {
				txn.rollback();
			}
		}
	}
	
	
	
	
	
	
	@POST
	@Path("/email")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmail(UpdatePass data) {
		
	LOG.fine("Attempt to update USER email: " + data.username);
		
		Transaction txn = datastore.newTransaction();
		try {
	
			Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username);
			Entity user = txn.get(userKey);
			
				if(user == null) {
					txn.rollback();
					return Response.status(Status.BAD_REQUEST).entity("User does not exists.").build();
				}else {
					String user_pwd = user.getString("user_pwd");
					//String user_email = user.getString("user_email");
					String username_name = user.getString("username_name");
					String user_isPublic = user.getString("user_isPublic");
					String user_tFixo = user.getString("user_tFixo");
					String user_tMovel = user.getString("user_tMovel");
					String user_nif = user.getString("user_nif");
					String user_role = user.getString("user_role");
					 
					
					
					user = Entity.newBuilder(userKey)
							.set("user_pwd", user_pwd)
							.set("user_email", data.email)
							.set("username_name", username_name)
							.set("user_isPublic", user_isPublic)
							.set("user_tFixo", user_tFixo)
							.set("user_tMovel", user_tMovel)
							.set("user_nif", user_nif)
							.set("user_creation_time", Timestamp.now())
							.set("user_role", user_role).build();
					txn.update(user);
					
					//txn.delete(userKey);
					//txn.add(user);
					LOG.info("User updated "+ data.username);
					txn.commit();
					return Response.ok("{User updated}").build();
				}

		} finally {
			if(txn.isActive()) {
				txn.rollback();
			}
		}
	}
	
	
	@POST
	@Path("/phone")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePhone(UpdatePass data) {
		
	LOG.fine("Attempt to update USER phone: " + data.username);
		
		Transaction txn = datastore.newTransaction();
		try {
	
			Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username);
			Entity user = txn.get(userKey);
			
				if(user == null) {
					txn.rollback();
					return Response.status(Status.BAD_REQUEST).entity("User does not exists.").build();
				}else {
					String user_pwd = user.getString("user_pwd");
					String user_email = user.getString("user_email");
					String username_name = user.getString("username_name");
					String user_isPublic = user.getString("user_isPublic");
					String user_tFixo = user.getString("user_tFixo");
					//String user_tMovel = user.getString("user_tMovel");
					String user_nif = user.getString("user_nif");
					String user_role = user.getString("user_role");
					 
					
					
					user = Entity.newBuilder(userKey)
							.set("user_pwd", user_pwd)
							.set("user_email", user_email)
							.set("username_name", username_name)
							.set("user_isPublic", user_isPublic)
							.set("user_tFixo", user_tFixo)
							.set("user_tMovel", data.tMovel)
							.set("user_nif", user_nif)
							.set("user_creation_time", Timestamp.now())
							.set("user_role", user_role).build();
					txn.update(user);
					
					//txn.delete(userKey);
					//txn.add(user);
					LOG.info("User updated "+ data.username);
					txn.commit();
					return Response.ok("{User updated}").build();
				}

		} finally {
			if(txn.isActive()) {
				txn.rollback();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	@POST
	@Path("/v2")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doRegistV2(String username) {
	LOG.fine("Attempt to remove user: " + username);
		
		Transaction txn = datastore.newTransaction();
		try {
			Key userKey = datastore.newKeyFactory().setKind("User").newKey(username);
			Entity user = txn.get(userKey);
			if(user == null) {
				txn.rollback();
				return Response.status(Status.BAD_REQUEST).entity("User does not exists.").build();
			}else {

				txn.delete(userKey);
				//txn.add(user);
				LOG.info("User Deleted "+ username);
				txn.commit();
				return Response.ok("{User Deleted}").build();
			}

		} finally {
			if(txn.isActive()) {
				txn.rollback();
			}
		}
	}
	
	
	
	
	
	

}
