package pt.unl.fct.di.adc.afonsoquinaz.resources;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.CompositeFilter;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.cloud.datastore.Transaction;
import com.google.gson.Gson;
import pt.unl.fct.di.adc.afonsoquinaz.util.AuthToken;
import pt.unl.fct.di.adc.afonsoquinaz.util.LoginData;
import pt.unl.fct.di.adc.afonsoquinaz.util.RegisterData;

@Path("/list")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ListResource {

	private static final Logger LOG = Logger.getLogger(LoginResource.class.getName());

	private final Gson g = new Gson();

	private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

	
	public ListResource() {

	}

	@POST
	@Path("/User")
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
				return Response.ok("{User Deleted}").build();
			}

		} finally {
			if(txn.isActive()) {
				txn.rollback();
			}
		}
	}
	
	@POST
	@Path("/User1")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response listUsers(RegisterData data) {
	LOG.fine("Attempt to remove user: " + data.username);
		
		Key userKey = datastore.newKeyFactory().setKind("User").newKey(data.username);
		Entity user = datastore.get(userKey);
		
		
		if(user != null) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			Timestamp YESTERDAY = Timestamp.of(cal.getTime());
			
			Query<Entity> query = Query.newEntityQueryBuilder()
					.setKind("User").build();
			
			QueryResults<Entity> logs = datastore.run(query);
			List<Entity> registers = new ArrayList();
			logs.forEachRemaining(userlog -> {
				registers.add(userlog);
			//	registers.add(userlog.getTimestamp("user_login_time").toDate());
			});
		
			return Response.ok(g.toJson(registers)).build();
		}

		
		
		return Response.status(Status.BAD_REQUEST).entity("User does not exists.").build();
		
	
	}
	
	@POST
	@Path("/User2")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response listUsers2() {
	LOG.fine("Attempt to remove user: " + "username");
		
		Key userKey = datastore.newKeyFactory().setKind("User").newKey("jleitao");
		Entity user = datastore.get(userKey);
		
		
		if(user != null) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			Timestamp YESTERDAY = Timestamp.of(cal.getTime());
			
			Query<Entity> query = Query.newEntityQueryBuilder()
					.setKind("User").build();
			
			QueryResults<Entity> logs = datastore.run(query);
			List<Entity> registers = new ArrayList();
			logs.forEachRemaining(userlog -> {
				registers.add(userlog);
			//	registers.add(userlog.getTimestamp("user_login_time").toDate());
			});
		
			return Response.ok(g.toJson(registers)).build();
		}

		
		
		return Response.status(Status.BAD_REQUEST).entity("User does not exists.").build();
		
	
	}
	
	
	
	
	
	

}

