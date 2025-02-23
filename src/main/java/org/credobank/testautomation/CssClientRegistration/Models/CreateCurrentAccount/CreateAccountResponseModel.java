package org.credobank.testautomation.CssClientRegistration.Models.CreateCurrentAccount;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateAccountResponseModel {
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
