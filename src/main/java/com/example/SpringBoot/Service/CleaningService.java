package com.example.SpringBoot.Service;

import com.example.SpringBoot.model.CleanData;
import com.example.SpringBoot.model.Data;
import com.example.SpringBoot.model.RedisData;
import com.example.SpringBoot.model.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CleaningService {

    // vals are mean,standard daviation,min,max
    private double raw_delight_vals[] = new double[]{0.392268,0.288341,0,1};
    private double raw_recom_vals[] = new double[]{13.077685,41.772135,0,150};
    private double distance_vals[] = new double[]{0.312889,0.106004,0,100};
    private double fprice_vals[] = new double[]{0.085819,0.044960,0,10000};

    public List<CleanData> cleaning(List<Data> hoteldata){
        List<CleanData> cleandata = new ArrayList<>();
        for(Data data : hoteldata){
            CleanData cdata = new CleanData();

            cdata.shortlisted = makeShortlisted(data.shortlisted);
            cdata.event = makeEvent(data.event);
            cdata.hotelBR = div(data.bookingcount,data.impressioncount);
            cdata.hotelBTOD = div(data.bookingcount,data.detailcount);
            cdata.hotelCTR = div(data.detailcount,data.impressioncount);
            cdata.userBR = div(data.userbookingcount,data.userimpressioncount);
            cdata.userCTR = div(data.detailcount,data.impressioncount);
            cdata.distanceFlag = makeDistanceFlag(data.distance);
            cdata.hotelId = Integer.parseInt(data.hotelId);
            cdata.requestId = data.requestId;
            cdata.hotelrank = Double.parseDouble(data.hotelrank);

            if(data.fPrice.equals("None"))
                data.fPrice = fprice_vals[0]+"";
            if(data.distance.equals("None"))
                data.distance = distance_vals[0]+"";
            if(data.rawDelight.equals("None"))
                data.rawDelight = raw_delight_vals[0]+"";
            if(data.rawRecommendedHotel.equals("None"))
                data.rawRecommendedHotel = raw_recom_vals[0]+"";

            cdata.fPrice = minMaxScaler(data.fPrice,fprice_vals[2],fprice_vals[3]);
            cdata.distance = minMaxScaler(data.distance,distance_vals[2],distance_vals[3]);
            cdata.rawDelight = minMaxScaler(data.rawDelight,raw_delight_vals[2],raw_delight_vals[3]);
            cdata.rawRecommendedHotel = minMaxScaler(data.rawRecommendedHotel,raw_recom_vals[2],raw_recom_vals[3]);

            cleandata.add(cdata);
        }

        return cleandata;
    }

    private double div(String a, String b){
        if(a.equals("None") || b.equals("None") || Double.parseDouble(b) == 0)
            return 0;
        return Double.parseDouble(a)/Double.parseDouble(b);
    }

    private double minMaxScaler(String val,double min,double max){
        double val2 = Double.parseDouble(val);
        double ans = (val2 - min)/(max-min);
        return ans;
    }

    private int makeShortlisted(String val){
        if(val == "True")
            return 1;
        return 0;
    }

    private int makeEvent(String val){
        if(val.equals("hotel_impression"))
            return 0;
        else if(val.equals("hotel_details_page"))
            return 1;
        else if(val.equals("booking"))
            return 2;
        return 3;
    }

    private int makeDistanceFlag(String val){
        if(val.equals("None"))
           return 1;
        return 0;
    }

}
