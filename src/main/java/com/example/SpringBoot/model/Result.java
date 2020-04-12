package com.example.SpringBoot.model;

public class Result {
    public String event;
    public  String hotelrank;
    public String hotelId;
    public String predicted_ranking;

    @Override
    public String toString() {
        return "Result{" +
                "event='" + event + '\'' +
                ", hotelrank='" + hotelrank + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", predicted_ranking='" + predicted_ranking + '\'' +
                '}';
    }
}
