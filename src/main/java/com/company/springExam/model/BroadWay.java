package com.company.springExam.model;

public class BroadWay implements Product {
    private static String name;
    private static Integer numberOfPeople;
    private static String site;
    private static String address;
    private static BroadWay broadWay;
    private  BroadWay (String name,Integer number,String site,String address){
        this.name=name;
        this.numberOfPeople=number;
        this.site=site;
        this.address=address;
    }
    public static BroadWay getInstance(){
        if(broadWay==null){
            broadWay=new BroadWay("BroadWay",500,"broadway.kg","Bishkek");
        }return broadWay;
    }
}
