package com.georgebrown.comp3074.a1100984638;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 9/27/2017.
 */

public class Restaurant {
    private String category;
    private String name;
    private String[] menu;
    //private int imageResourceId;

    private Restaurant(String category, String name, String[] menu){
    //private Restaurant(String category, String name, int id){
        this.category = category;
        this.name = name;
        this.menu = menu;
        //this.imageResourceID = id;
    }

    //getters
    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String[] getMenu() {
        return menu;
    }

    //create restaurant array
    public static final Restaurant[] Mexican = {
            new Restaurant("Mexican", "El Camino", Menu.m1),
            new Restaurant("Mexican", "Corazon De Maiz", Menu.m2),
            new Restaurant("Mexican", "Taqueria la Bonita", Menu.m3),
            new Restaurant("Mexican", "Ola Cocina", Menu.m4),
            new Restaurant("Mexican", "Ace Mercado", Menu.m5),
    };

    public static final Restaurant[] Caribbean = {
            new Restaurant("Caribbean", "Tropical Paradise", Menu.c1),
            new Restaurant("Caribbean", "Mango Bay", Menu.c2),
            new Restaurant("Caribbean", "La Habanera", Menu.c3),
            new Restaurant("Caribbean", "Cafe Rustic Rosemont", Menu.c4),
            new Restaurant("Caribbean", "Patois", Menu.c5),
    };

    public static final Restaurant[] Greek = {
            new Restaurant("Greek", "Aroma Meze", Menu.g1),
            new Restaurant("Greek", "Cozmos Souvlaki", Menu.g2),
            new Restaurant("Greek", "Zizis Kitchen", Menu.g3),
            new Restaurant("Greek", "Kallisto", Menu.g4),
            new Restaurant("Greek", "Kostas", Menu.g5),
    };

    public static final Restaurant[] Italian = {
            new Restaurant("Italian", "La Bottega", Menu.i1),
            new Restaurant("Italian", "Vittoria Trattoria", Menu.i2),
            new Restaurant("Italian", "Mamma Teresa Ristorante", Menu.i3),
            new Restaurant("Italian", "Cucina da Vito\n", Menu.i4),
            new Restaurant("Italian", "Poco Pazzo", Menu.i5),
    };

    public static final Restaurant[] Japanese = {
            new Restaurant("Japanese", "Tomo", Menu.j1),
            new Restaurant("Japanese", "Genji", Menu.j2),
            new Restaurant("Japanese", "Edokko", Menu.j3),
            new Restaurant("Japanese", "Shogun", Menu.j4),
            new Restaurant("Japanese", "Fuji", Menu.j5),
    };

    //show the name of restaurant in spinner
    @Override
    public String toString() {
        return this.name;
    }
}
