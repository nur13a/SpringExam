package com.company.springExam.model;

public class Factory {
    public static Product getProduct(String name) {
        switch (name) {
            case "C":
                return BroadWay.getInstance();
            case "R":
                return Navat.getInstance();
            case "T":
                return TicketOn.getInstance();
        }

        return null;
    }
}
