package webhookServerIntegrationDemo;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;
@Path("postcal")
public class Postcal {
	
	
	@POST
	@Path("respo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
public JSONObject Respo(JSONObject val){
		 JSONObject obj=new JSONObject();
		 
		 String output="";
			String output1="";
			String output2="";
			 try {
				//	JSONObject json_main=new JSONObject(new JSONTokener(val));
					
					// String str_result=json_main.getString("result");
				      String str_result=val.getString("result");
				      
				      
				      JSONObject json_result=new JSONObject(str_result);
				      
				      String action = json_result.getString("resolvedQuery");
				      if(action.equalsIgnoreCase("Create New Project")){
			            	output="in Which tool you want to create Project?";
			            
			            }else{
			            	output="I am not able to Recognize your Voice !";
			            }

				      
				      JSONObject subobj=new JSONObject();
			            subobj.put("speech", output);
			            subobj.put("displayText", output);
			            JSONObject subsubobj=new JSONObject();
			            subobj.put("data", subsubobj);
			            JSONArray subsubarray =new JSONArray();
			            
			            subobj.put("contextOut", subsubarray);
			            subobj.put("source", "webhookServerIntegrationDemo");
			            
			           
			            obj.put("Body", subobj);
			       
			 } 
		     catch(Exception ex){
		    	 try{
		       return obj.put("error", ex.getMessage());
		    	 }catch (Exception e) {
					// TODO: handle exception
				}
		     }
			 return obj;
		}
}
