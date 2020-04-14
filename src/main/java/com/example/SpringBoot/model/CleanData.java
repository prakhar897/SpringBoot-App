package com.example.SpringBoot.model;


public class CleanData {

    public String requestId;
    public int hotelId;
    public double hotelrank;
    public double rawDelight;
    public double rawRecommendedHotel;
    public double distance;
    public double fPrice;
    public double shortlisted;
    public double event;
    public double hotelBR;
    public double hotelCTR;
    public double hotelBTOD;
    public double userBR;
    public double userCTR;
    public double distanceFlag;

    @Override
    public String toString() {
        return "CleanData{" +
                "requestId='" + requestId + '\'' +
                ", hotelId=" + hotelId +
                ", hotelrank=" + hotelrank +
                ", rawDelight=" + rawDelight +
                ", rawRecommendedHotel=" + rawRecommendedHotel +
                ", distance=" + distance +
                ", fPrice=" + fPrice +
                ", shortlisted=" + shortlisted +
                ", event=" + event +
                ", hotelBR=" + hotelBR +
                ", hotelCTR=" + hotelCTR +
                ", hotelBTOD=" + hotelBTOD +
                ", userBR=" + userBR +
                ", userCTR=" + userCTR +
                ", distanceFlag=" + distanceFlag +
                '}';
    }
}