package com.utn.dds.tpprevio.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;
import com.utn.dds.tpprevio.domain.Country;
import com.utn.dds.tpprevio.domain.State;

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
            final Gson gson = new Gson(); 
            final StringMap<String> paisSeleccionado = gson.fromJson(response.getResponseBody(), StringMap.class);
      
           //System.out.println(paisSeleccionado.getClass()); 
           //System.out.println(paisSeleccionado.get(STATES_KEY).getClass());
           //final List<StringMap<String>> provincias = (List)gson.fromJson(paisSeleccionado.get(STATES_KEY), List.class);
           /*
           for (final StringMap<String> provincia : provincias) {   
        	    gson.fromJson(provincia.toString(),StringMap.class);
                System.out.println(provincia.get(NAME_KEY));
            }*/
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
