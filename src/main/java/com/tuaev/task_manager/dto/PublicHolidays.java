package com.tuaev.task_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Data
public class PublicHolidays {

    @JsonProperty("date")
    private Date date;
    @JsonProperty("localName")
    private String localName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("fixed")
    private boolean fixed;
    @JsonProperty("global")
    private boolean global;
    @JsonProperty("counties")
    private List<String> countries;
    @JsonProperty("launchYear")
    private int launchYear;
    @JsonProperty("types")
    private List<String> types;

    public PublicHolidays(String type){
        this.types = Collections.singletonList(type);
    }
}
