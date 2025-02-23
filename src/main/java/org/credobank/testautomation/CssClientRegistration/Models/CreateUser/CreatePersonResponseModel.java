package org.credobank.testautomation.CssClientRegistration.Models.CreateUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ToString
public class CreatePersonResponseModel {
    public boolean success;
    @JsonProperty("Version")
    public String version;
    @JsonProperty("StatusCode")
    public int statusCode;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("Result")
    public Result result;
    public String error;
}