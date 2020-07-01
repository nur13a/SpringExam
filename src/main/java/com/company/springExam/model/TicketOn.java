package com.company.springExam.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TicketOn implements Product {
   private static String name;
    private static String site;
    private static String payment;
private  static TicketOn ticketOn;
    public TicketOn(String name,String site,String payment) {
   this.name=name;
   this.site=site;
   this.payment=payment;
    }
    public static TicketOn getInstance(){
        if(ticketOn==null){
            ticketOn=new TicketOn("TicketOn","ticket.kg","Visa");
        }return ticketOn;
    }
}
