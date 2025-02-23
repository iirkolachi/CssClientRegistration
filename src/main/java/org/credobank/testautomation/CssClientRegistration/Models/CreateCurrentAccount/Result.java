package org.credobank.testautomation.CssClientRegistration.Models.CreateCurrentAccount;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Result {
    @JsonProperty("Id")
    public int id;
    @JsonProperty("OperationId")
    public int operationId;
    @JsonProperty("OperationTypeId")
    public Object operationTypeId;
    @JsonProperty("Message")
    public String message;
    @JsonProperty("AccountNumber")
    public String accountNumber;
    @JsonProperty("T24GelAccountId")
    public int t24GelAccountId;
}
