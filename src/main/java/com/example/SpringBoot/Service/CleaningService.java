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

    @Autowired
    DataRepository dataRepository;

    @Autowired
    RedisData redisData;

    public List<Data> retrieval(String hotelids[]){
        List<Data> hoteldata = new ArrayList<>();
        for(String id : hotelids){
            Optional<Data> retOpt;
            retOpt = Optional.ofNullable(redisData.findById(id));
            if(retOpt == null) {
                System.out.println("Not found in Redis, Searching in ES");
                retOpt = dataRepository.findById(id);
            }
            Data ret = retOpt.orElse(null);
            if(ret != null)
                hoteldata.add(ret);
            else
                System.out.println("HotelId: " + id + " not found in data");
        }
        return hoteldata;
    }

    public List<CleanData> cleaning(List<Data> hoteldata){
        List<CleanData> cleandata = new ArrayList<>();
        for(Data data : hoteldata){
            CleanData cdata = new CleanData();

            if(data.shortlisted == "True")
                cdata.shortlisted = 1;
            else
                cdata.shortlisted = 0;

            if(data.event.equals("hotel_impression"))
                cdata.event = 0;
            else if(data.event.equals("hotel_details_page"))
                cdata.event = 1;
            else if(data.event.equals("booking"))
                cdata.event = 2;
            else
                cdata.event = 3;

            cdata.hotelBR = div(data.bookingcount,data.impressioncount);
            cdata.hotelBTOD = div(data.bookingcount,data.detailcount);
            cdata.hotelCTR = div(data.detailcount,data.impressioncount);
            cdata.userBR = div(data.userbookingcount,data.userimpressioncount);
            cdata.userCTR = div(data.detailcount,data.impressioncount);

            if(data.distance.equals("None"))
                cdata.distanceFlag = 1;
            else
                cdata.distanceFlag = 0;

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

    public double div(String a, String b){
        if(a.equals("None") || b.equals("None") || Double.parseDouble(b) == 0)
            return 0;
        return Double.parseDouble(a)/Double.parseDouble(b);
    }

    public double minMaxScaler(String val,double min,double max){
        double val2 = Double.parseDouble(val);
        double ans = (val2 - min)/(max-min);
        return ans;
    }

}
