package com.utn.dds.tpprevio.service.impl;

import java.util.List;
import com.utn.dds.tpprevio.controller.*;
import com.utn.dds.tpprevio.domain.*;;

public class Main {

    public static void main(String[] args) throws Exception {
        final List<Site> sites = SiteHandler.getInstance().getAllMeliSite();

        for (final Site site: sites) {
            System.out.println(site);
        }
    }
}