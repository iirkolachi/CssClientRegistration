package org.credobank.testautomation.CssClientRegistration.Models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ToString
public class Result {
    @JsonProperty("Id")
    public int id;
    @JsonProperty("OperationId")
    public int operationId;
    @JsonProperty("OperationTypeId")
    public int operationTypeId;
    @JsonProperty("Message")
    public String message;
    @JsonProperty("AMLStatusId")
    public int aMLStatusId;
    @JsonProperty("PersonalN")
    public String personalN;
    @JsonProperty("PersonId")
    public int personId;
}