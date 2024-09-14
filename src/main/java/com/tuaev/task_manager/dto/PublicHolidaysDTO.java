package com.tuaev.task_manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PublicHolidaysDTO {

//    @JsonProperty("date")
//    LocalDate localDate;
//    @JsonProperty("localName")
//    String localName;
//    @JsonProperty("name")
//    String name;
//    @JsonProperty("countryCode")
//    String countryCode;
//    @JsonProperty("types")
//    String types;

}
