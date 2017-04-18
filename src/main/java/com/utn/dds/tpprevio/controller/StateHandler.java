package com.utn.dds.tpprevio.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;
import com.utn.dds.tpprevio.domain.Country;
import com.utn.dds.tpprevio.domain.State;
import org.json.*;

public class StateHandler {
	private static final String ID_KEY = "id";
    private static final String NAME_KEY = "name";
    private static final String STATES_KEY = "states";
    private final Meli meli;

    private static final StateHandler instance = new StateHandler();

    private StateHandler() {
        meli = new Meli(11111L, "clientSecret");
    }

    public static StateHandler getInstance() {
        return instance;
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
}
