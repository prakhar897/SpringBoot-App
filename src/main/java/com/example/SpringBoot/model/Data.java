package com.example.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "hoteldata", type = "Data")
public class Data {

    @JsonProperty("requestId")
    public String requestId;
    @Id
    @JsonProperty("hotelId")
    public String hotelId;
    @JsonProperty("userid")
    public String userid;
    @JsonProperty("hotelrank")
    public String hotelrank;
    @JsonProperty("rawDelight")
    public String rawDelight;
    @JsonProperty("rawRecommendedHotel")
    public String rawRecommendedHotel;
    @JsonProperty("rating")
    public String rating;
    @JsonProperty("ratingCount")
    public String ratingCount;
    @JsonProperty("distance")
    public String distance;
    @JsonProperty("fPrice")
    public String fPrice;
    @JsonProperty("shortlisted")
    public String shortlisted;
    @JsonProperty("event")
    public String event;
    @JsonProperty("impressioncount")
    public String impressioncount;
    @JsonProperty("detailcount")
    public String detailcount;
    @JsonProperty("bookingcount")
    public String bookingcount;
    @JsonProperty("userimpressioncount")
    public String userimpressioncount;
    @JsonProperty("userdetailcount")
    public String userdetailcount;
    @JsonProperty("userbookingcount")
    public String userbookingcount;

    public Data(){}

    public Data(String requestId, String hotelId, String userid, String hotelrank, String rawDelight, String rawRecommendedHotel, String rating, String ratingCount, String distance, String fPrice, String shortlisted, String event, String impressioncount, String detailcount, String bookingcount, String userimpressioncount, String userdetailcount, String userbookingcount) {
        super();
        this.requestId = requestId;
        this.hotelId = hotelId;
        this.userid = userid;
        this.hotelrank = hotelrank;
        this.rawDelight = rawDelight;
        this.rawRecommendedHotel = rawRecommendedHotel;
        this.rating = rating;
        this.ratingCount = ratingCount;
        this.distance = distance;
        this.fPrice = fPrice;
        this.shortlisted = shortlisted;
        this.event = event;
        this.impressioncount = impressioncount;
        this.detailcount = detailcount;
        this.bookingcount = bookingcount;
        this.userimpressioncount = userimpressioncount;
        this.userdetailcount = userdetailcount;
        this.userbookingcount = userbookingcount;
    }

    @Override
    public String toString() {
        return "Data{" +
                "requestId='" + requestId + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", userid='" + userid + '\'' +
                ", hotelrank='" + hotelrank + '\'' +
                ", rawDelight='" + rawDelight + '\'' +
                ", rawRecommendedHotel='" + rawRecommendedHotel + '\'' +
                ", rating='" + rating + '\'' +
                ", ratingCount='" + ratingCount + '\'' +
                ", distance='" + distance + '\'' +
                ", fPrice='" + fPrice + '\'' +
                ", shortlisted='" + shortlisted + '\'' +
                ", event='" + event + '\'' +
                ", impressioncount='" + impressioncount + '\'' +
                ", detailcount='" + detailcount + '\'' +
                ", bookingcount='" + bookingcount + '\'' +
                ", userimpressioncount='" + userimpressioncount + '\'' +
                ", userdetailcount='" + userdetailcount + '\'' +
                ", userbookingcount='" + userbookingcount + '\'' +
                '}';
    }
}