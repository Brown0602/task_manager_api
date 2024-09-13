package com.tuaev.task_manager.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tuaev.task_manager.dto.PublicHolidays;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class DaysOffJson {

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
    private List<String> counties;
    @JsonProperty("launchYear")
    private int launchYear;
    @JsonProperty("types")
    private List<PublicHolidays> types;
}
