package com.utn.dds.tpprevio.service.impl;

import java.util.List;
import com.utn.dds.tpprevio.controller.*;
import com.utn.dds.tpprevio.domain.*;;

public class Main {

    public static void main(String[] args) throws Exception {
        final List<Country> countries = CountryHandler.getInstance().getAllMeliCountries();

        for (final Country country: countries) {
            System.out.println(country);
        }
        final List<State> provs = StateHandler.getInstance().getAllMeliState("AR");
        
        
        
    }
}