package com.tuaev.task_manager;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


public enum HolidayTypes {
    @JsonProperty("Public")
    Public,
    @JsonProperty("Bank")
    Bank,
    @JsonProperty("School")
    School,
    @JsonProperty("Authorities")
    Authorities,
    @JsonProperty("Optional")
    Optional,
    @JsonProperty("Observance")
    Observance;
}
