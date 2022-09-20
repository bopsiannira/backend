package com.quinnox.Simple;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("/bike")
public class QuinnoxResource {

	BikeRepository repo = new BikeRepository();

	//FETCH
	@GET
	@Path("details")
	@Produces( MediaType.APPLICATION_JSON )
	public List<Bike> getallBikes() throws ClassNotFoundException, SQLException {
		for(Bike bike: repo.getallBikes())
		System.out.println(bike.toString());
		return repo.getallBikes();
	}

	
	  //fetching data on id
	  
	  @GET
	  
	  @Path("details/{id}")
	  
	  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML }) public
	  List<Bike> getBikeonid(@PathParam("id") int id) throws
	  ClassNotFoundException, SQLException { return repo.GetBikeonid(id);
	  
	  }
	 
	
	//INSERT
	@POST
	@Path("insert")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Bike insertBike(Bike bike) throws ClassNotFoundException, SQLException {
//		System.out.println(bike);
		repo.insertBike(bike);
		return bike;
	}

	
	//Update
	@PUT
	@Path("update")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Bike updateBike(Bike bike) throws Exception {
		repo.updateBike( bike);
//		System.out.println(bike.toString());
//		List<Bike> bothData = new ArrayList<Bike>();
//		bothData.addAll(repo.GetBikeonid(id));
//		repo.updateBike(id, bike);
//		bothData.addAll(repo.GetBikeonid(id));

		return bike;	
		}



  //DELETE
  
	
	
	  @DELETE	  
	  @Path("delete/{id}")
	  @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
	  public void deletebike(@PathParam ("id")int id) throws Exception {
		repo.deletebike(id); 
		}
}
	  
	  // return "bike = "+id+" is sold."; } } }
 
