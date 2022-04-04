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

@Path("/delete")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RemoveResource {

	private static final Logger LOG = Logger.getLogger(LoginResource.class.getName());

	private final Gson g = new Gson();

	private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

	
	public RemoveResource() {

	}

	@POST
	@Path("/v1")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doRegistV1(RegisterData data) {
	LOG.fine("Attempt to remove user: " + data.username);
		
		Transaction txn = datastore.newTransaction();
		try {
			Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username);
			Entity user = txn.get(userKey);
			
			if(user == null) {
				txn.rollback();
				return Response.status(Status.BAD_REQUEST).entity("User does not exists.").build();
			}else {

				txn.delete(userKey);
				//txn.add(user);
				LOG.info("User Deleted "+ data.username);
				txn.commit();
				return Response.ok("{User Deleted}" + user.getString("user_role")).build();
			}

		} finally {
			if(txn.isActive()) {
				txn.rollback();
			}
		}
	}
	
	@POST
	@Path("/v3")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doRegistV3(RemoveData data) {
		
	LOG.fine("Attempt to remove user: " + data.username2);
		
		Transaction txn = datastore.newTransaction();
		try {
			Key userKey1 = datastore.newKeyFactory().setKind("User").newKey(data.username1);
			Entity user1 = txn.get(userKey1);
			
			Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username2);
			Entity user = txn.get(userKey);
			
			if(!data.canRemove(data.username1, data.username2, user1.getString("user_role"), user.getString("user_role")))
			{
				return Response.status(Status.BAD_REQUEST).entity("NO PERMISSION FOR THAT").build();
			}
			
			
		//	if(user1.getString("user_role").equals("USER") && !(data.username1.equals(data.username2))) {
		//		return Response.status(Status.BAD_REQUEST).entity("NO PERMISSION FOR THAT").build();
		//	}
			
		//	if(user1.getString("user_role").equals("GBO") && !user.getString("user_role").equals("USER")  && !(data.username1.equals(data.username2))) {
				
		//	}
			
		//	if(user1.getString("user_role").equals("GA") && (user.getString("user_role").equals("GA") ||  user.getString("user_role").equals("SU")) && !(data.username1.equals(data.username2))) {
		//		return Response.status(Status.BAD_REQUEST).entity("NO PERMISSION FOR THAT").build();
		//	}
				
				
				if(user == null) {
					txn.rollback();
					return Response.status(Status.BAD_REQUEST).entity("User does not exists.").build();
				}else {

					txn.delete(userKey);
					//txn.add(user);
					LOG.info("User Deleted "+ data.username2);
					txn.commit();
					return Response.ok("{User Deleted}" + user1.getString("user_role")).build();
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
