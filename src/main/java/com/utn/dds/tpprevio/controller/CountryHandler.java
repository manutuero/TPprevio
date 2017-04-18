package com.utn.dds.tpprevio.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;
import com.utn.dds.tpprevio.domain.*;;

public class CountryHandler {

    private static final String ID_KEY = "id";
    private static final String NAME_KEY = "name";
    private final Meli meli;

    private static final CountryHandler instance = new CountryHandler();

    private CountryHandler() {
        meli = new Meli(11111L, "clientSecret");
    }

    public static CountryHandler getInstance() {
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
}