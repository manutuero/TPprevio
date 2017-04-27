package com.utn.dds.tpprevio.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;
import com.utn.dds.tpprevio.domain.Country;
import com.utn.dds.tpprevio.domain.State;
import com.utn.dds.tpprevio.service.CountryService;
import com.utn.dds.tpprevio.service.impl.CountryServiceImpl;

public class  CountryController {

    private static final String ID_KEY = "id";
    private static final String NAME_KEY = "name";
    private final Meli meli;

    private static final CountryController instance = new CountryController();
    private CountryService countryService = new CountryServiceImpl();
    
    public CountryController() {
        meli = new Meli(11111L, "clientSecret");
    }

    public static CountryController getInstance() {
        return instance;
    }

    public List<Country> getAllMeliCountries() throws MeliException {
        final List<Country> newCountries = new ArrayList<Country>();
        try {
            final Response response = meli.get("/countries/");

            final Gson gson = new Gson();
            final List<StringMap<String>> countries = gson.fromJson(response.getResponseBody(), List.class);
            
         
            for (final StringMap<String> entries : countries) {
                newCountries.add(new Country(entries.get(ID_KEY), entries.get(NAME_KEY)));
            }
        } catch (MeliException ex) {
            //Logger error en la respuesta
            System.out.println("Error " + ex.getMessage());
        } catch (IOException e) {
            //Logger error en la transformacion usando de gson.
            System.out.println("Error " + e.getMessage());
        }
        return newCountries;
    }
    
    public List<State> getAllMeliState(String pais) throws MeliException {
        //declaro lista de provincias o estados (depende el pais)
        final List<State> newStates = new ArrayList<State>();
       
        try {
            final Response response = meli.get("/countries/"+pais);
            try{
            JSONObject paisJson = new JSONObject(response.getResponseBody()); 
            JSONArray states = paisJson.getJSONArray("states");
            for (int j = 0; j < states.length(); j++) {
                JSONObject stateFromPais = states.getJSONObject(j);
                newStates.add(new State(stateFromPais.getString("id"),stateFromPais.getString("name")));
              }
            } catch (JSONException js){}
        } catch (MeliException ex) {
            //Logger error en la respuesta
            System.out.println("Error " + ex.getMessage());
        } catch (IOException e) {
            //Logger error en la transformacion usando de gson.
            System.out.println("Error " + e.getMessage());
        }
        return newStates;
    }
    
    public void actualizarBase() throws MeliException  {
    	List<Country> countries = getAllMeliCountries();
    	for(int i=0; i < countries.size(); i++)  {
    		Country country = countries.get(i);
    		List<State> states = getAllMeliState(country.getId());
    		//System.out.println(country.getName());	
    		countryService.actualizarBase(country, states);
    		}
    }
}