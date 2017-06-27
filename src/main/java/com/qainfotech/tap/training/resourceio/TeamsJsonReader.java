package com.qainfotech.tap.training.resourceio;

import com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException;
import com.qainfotech.tap.training.resourceio.model.Individual;
import com.qainfotech.tap.training.resourceio.model.Team;
import java.util.List;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class TeamsJsonReader{
	
	JSONParser parser = new JSONParser();

	List<Individual> myObjList = new ArrayList<Individual>();
	List<Individual> myObjList1 = new ArrayList<Individual>();
	List<Individual> myObjList2 = new ArrayList<Individual>();
	List<Individual> myObjList3 = new ArrayList<Individual>();
	List<Individual> myObjList4 = new ArrayList<Individual>();
	List<Team> myObjList5 = new ArrayList<Team>();

    /**
     * get a list of individual objects from db json file
     * 
     * @return 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public List<Individual> getListOfIndividuals() throws FileNotFoundException, IOException{
        //throw new UnsupportedOperationException("Not implemented.");
        
        myObjList.clear();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(new FileReader("src/main/resources/db.json"));
		} catch (org.json.simple.parser.ParseException e) {
		}

		JSONObject jsonObject = (JSONObject) obj;

		
		JSONArray second = (JSONArray) jsonObject.get("individuals");

		Individual obj1;
		JSONObject myobj;

		for (int i = 0; i < second.size(); i++) {

			myobj = (JSONObject) second.get(i);
		
			
			Map<String, Object> individualMap = new HashMap() ;
			individualMap.put("name", myobj.get("name").toString().trim());
			individualMap.put("id", myobj.get("id").toString().trim());
			individualMap.put("active", myobj.get("active").toString().trim());
			
	    	
	
			obj1 = new Individual(individualMap);

			try {
				myObjList.add(obj1);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		return myObjList;
    
    }
    
    /**
     * get individual object by id
     * 
     * @param id individual id
     * @return 
     * @throws com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException 
     */
    
    
    
    public Individual getIndividualById(Integer id) throws ObjectNotFoundException{
       // throw new UnsupportedOperationException("Not implemented.");
        for (int i = 0; i < myObjList.size(); i++) {

			if ((int) myObjList.get(i).getId() == (int) id) {

			
				return myObjList.get(i);

			}

		}
		
		 throw new ObjectNotFoundException(null, null, null);
    
    }
    
    /**
     * get individual object by name
     * 
     * @param name
     * @return 
     * @throws com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException 
     */
    public Individual getIndividualByName(String name) throws ObjectNotFoundException{
        //throw new UnsupportedOperationException("Not implemented.");
    
	for (int i = 0; i < myObjList.size(); i++) {

			
			if (myObjList.get(i).getName().equals(name)) {

					return myObjList.get(i);

			}

		}
	throw new ObjectNotFoundException(null, null, null)	;
    }
    
    
    /**
     * get a list of individual objects who are not active
     * 
     * @return List of inactive individuals object
     */
    public List<Individual> getListOfInactiveIndividuals(){
      //  throw new UnsupportedOperationException("Not implemented.");	
		myObjList2.clear();

		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(new FileReader("src/main/resources/db.json"));
		} catch (org.json.simple.parser.ParseException e) {
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject jsonObject = (JSONObject) obj;

		JSONArray second = (JSONArray) jsonObject.get("individuals");

		Individual obj1;
		JSONObject myobj;
		
		for (int i = 0; i < second.size(); i++) {

			myobj = (JSONObject) second.get(i);

			if (Boolean.parseBoolean(myobj.get("active").toString()) == false) {
			
				
				Map<String, Object> individualMap = new HashMap() ;
		
				individualMap.put("name", myobj.get("name").toString().trim());
				individualMap.put("id", myobj.get("id").toString().trim());
				individualMap.put("active", myobj.get("active").toString().trim());
			
				
				obj1 = new Individual(individualMap);

				myObjList2.add(obj1);
			}
		}

		
		return myObjList2;
    }
    
    /**
     * get a list of individual objects who are active
     * 
     * @return List of active individuals object
     */
    public List<Individual> getListOfActiveIndividuals(){
       // throw new UnsupportedOperationException("Not implemented.");
        
        
		myObjList3.clear();

		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(new FileReader("src/main/resources/db.json"));
		} catch (org.json.simple.parser.ParseException e) {
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject jsonObject = (JSONObject) obj;

		JSONArray second = (JSONArray) jsonObject.get("individuals");

		Individual obj1;
		JSONObject myobj;

		for (int i = 0; i < second.size(); i++) {

			myobj = (JSONObject) second.get(i);

			if (Boolean.parseBoolean(myobj.get("active").toString()) == true) {
			
				Map<String, Object> individualMap = new HashMap() ;
				individualMap.put("name", myobj.get("name").toString().trim());
				individualMap.put("id", myobj.get("id").toString().trim());
				individualMap.put("active", myobj.get("active").toString().trim());
					
		    	
		    	
		    	obj1 = new Individual(individualMap);
				myObjList3.add(obj1);
			}
		}

		return myObjList3;
        
    }
    
    /**
     * get a list of team objects from db json
     * 
     * @return 
     */
    public List<Team> getListOfTeams(){
       // throw new UnsupportedOperationException("Not implemented.");
    	
    	
		JSONObject obj = null;
		
		myObjList5.clear();
		
		try {
			obj = (JSONObject) parser.parse(new FileReader("src/main/resources/db.json"));
		} catch (org.json.simple.parser.ParseException e) {
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(myObjList.isEmpty())
		{
			try {
				myObjList4=this.getListOfIndividuals();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myObjList=myObjList4;
		}
		
		JSONObject jsonObject = (JSONObject) obj;

		JSONArray second = (JSONArray) jsonObject.get("teams");

		Team obj1;
		JSONObject myobj;

		for (int i = 0; i < second.size(); i++) {

			myobj = (JSONObject) second.get(i);

			
			Map<String, Object> TeamMap = new HashMap() ;
			TeamMap.put("name", myobj.get("name").toString().trim());
			TeamMap.put("id", myobj.get("id").toString().trim());
			TeamMap.put("memberobject", myObjList);
	    	
	    	
	    	System.out.println(TeamMap.get("memberobject"));
			Team temp = new Team(TeamMap);
			myObjList5.add(temp);

		}

		return myObjList5;
    }
}
