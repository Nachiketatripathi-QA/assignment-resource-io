package com.qainfotech.tap.training.resourceio;

import com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException;
import com.qainfotech.tap.training.resourceio.model.Individual;
import com.qainfotech.tap.training.resourceio.model.Team;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
//import org.json.simple.parser.ParseException;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class TeamsJsonReader{
	JSONParser parser=new JSONParser();
	List<Team> teamList;
	JSONObject jsonObject;

public List<Individual> getListOfIndividuals() {
	// throw new UnsupportedOperationException("Not implemented.");
	 
        Object obj=null;
        Map<String,Object> map=null;
        Individual a=null;
        JSONObject jsonobj2=null;
        List<Individual> ab=new ArrayList<>();
        map=new HashMap<String,Object>();
        try {
			obj = parser.parse(new FileReader("C:\\Users\\nachiketatripathi\\workspace\\assignment-resource-io-master\\src\\main\\resources\\db.json"));
		} catch (Exception e) {
			e.printStackTrace();
		}
        JSONObject jsonObject=(JSONObject)obj; ;
        JSONArray jsonarr=(JSONArray)jsonObject.get("individuals"); 
       for (int i = 0; i < jsonarr.size(); i++) {
            jsonobj2=(JSONObject)jsonarr.get(i);
            map.put("name", jsonobj2.get("name"));
            map.put("id",((Long)jsonobj2.get("id")).intValue());
            map.put("active", jsonobj2.get("active"));
            a=new Individual(map);
            ab.add(a);
        }
        return ab;
    }


    /**
     * get a list of individual objects from db json file
     * 
     * @return 
     */
   
    
    /**
     * get individual object by id
     * 
     * @param id individual id
     * @return 
     * @throws com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException 
     */
    public Individual getIndividualById(Integer id) throws ObjectNotFoundException{
        //throw new UnsupportedOperationException("Not implemented.");
    	List<Individual> abc=new ArrayList<>();
        try {
			abc=(new TeamsJsonReader()).getListOfIndividuals();
		} catch (Exception e) {
			e.printStackTrace();
		}
        Individual individual=null;
        int i,j=0;
        for(i=0;i<abc.size();i++)
        {
        	individual=abc.get(i);
        	if(individual.getId().compareTo(id)==0)
        	{
        		j=1;
        		break;
        	}
        }
        if(j==0)
        {
        	throw new ObjectNotFoundException("individual","id",id.toString());
        }
        else
        	return individual;
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
    	List<Individual> abc=new ArrayList<>();
        try {
			abc=(new TeamsJsonReader()).getListOfIndividuals();
		} catch (Exception e) {
			e.printStackTrace();
		}
        Individual individual=null;
        int i,j=0;
        for(i=0;i<abc.size();i++)
        {
        	individual=abc.get(i);
        	if(individual.getName().compareTo(name)==0)
        	{
        		j=1;
        		break;
        	}
        }
        if(j==0)
        {
        	throw new ObjectNotFoundException("individual","name",name);
        }
        else
        	return individual;
    }
   
    
    
    /**
     * get a list of individual objects who are not active
     * 
     * @return List of inactive individuals object
     */
    public List<Individual> getListOfInactiveIndividuals(){
        //throw new UnsupportedOperationException("Not implemented.");
    	List<Individual> abc=new ArrayList<>();
        try {
			abc=(new TeamsJsonReader()).getListOfIndividuals();
		} catch (Exception e) {
			e.printStackTrace();
		
		}
    	List<Individual> inactivemember=new ArrayList<>();
    	for(int i=0;i<abc.size();i++)
    	{
    		Individual individual= abc.get(i);
    		if(!individual.isActive())
    		{
    			inactivemember.add(individual);
    		}
    	}
return inactivemember;
    }
    
    
    
    /**
     * get a list of individual objects who are active
     * 
     * @return List of active individuals object
     */
    public List<Individual> getListOfActiveIndividuals(){
        //throw new UnsupportedOperationException("Not implemented.");
    	List<Individual> abc=new ArrayList<>();
        try {
			abc=(new TeamsJsonReader()).getListOfIndividuals();
		} catch (Exception e) {
			e.printStackTrace();
		
		}
    	List<Individual> activemember=new ArrayList<>();
    	for(int i=0;i<abc.size();i++)
    	{
    		Individual individual= abc.get(i);
    		if(individual.isActive())
    		{
    			activemember.add(individual);
    		}
    	}
return activemember;
    
    }
    
   
	public List<Team> getListOfTeams() {
		JSONParser parser = new JSONParser();
		FileReader readfile = null;
		try {
			readfile = new FileReader(new File(
					"C:\\Users\\nachiketatripathi\\workspace\\assignment-resource-io-master\\src\\main\\resources\\db.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			try {
				jsonObject = (JSONObject) parser.parse(readfile);
			} catch (IOException | org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		 teamList = new ArrayList<>();
		JSONArray teams = (JSONArray) jsonObject.get("teams");
		Map<String, Object> input = new HashMap<String, Object>();
		for (int i = 0; i < teams.size(); i++) {
			JSONObject ob = (JSONObject) teams.get(i);
			input.put("1", ob);
			Team newindividual = null;
			newindividual = new Team(input);
			if (newindividual != null)
				teamList.add(newindividual);
			input.remove("1");

		}
		if (teamList == null)
			throw new UnsupportedOperationException("Not implemented.");
		return teamList;
	}
	}


