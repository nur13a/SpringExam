package com.company.springExam.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Navat implements Product {
    private static String name;
    private static String dish;
    private static String site;
    private static String address;
    private static Navat navat;
    private  Navat (String name,String dish,String site,String address){
        this.name=name;
        this.dish=dish;
        this.site=site;
        this.address=address;
    }
    public static  Navat getInstance(){
        if(name==null){
            navat=new Navat("Navat","Lagman","navat.kg","Bishkek");
        }return navat;
    }
}
