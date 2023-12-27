package com.soapandrest.SoapAndRestApi.rest.model;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "errorCode",
        "errorMsg",
        "trxId"
})
@XmlRootElement(name = "sampleservicers")
public class Sampleservicersrest {

    @XmlElement(name = "error_code", required = true)
    protected String errorCode;

    @XmlElement(name = "error_msg", required = true)
    protected String errorMsg;

    @XmlElement(name = "trx_id")
    protected String trxId;

}
