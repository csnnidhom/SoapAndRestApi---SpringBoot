package com.soapandrest.SoapAndRestApi.rest.model;

import jakarta.xml.bind.annotation.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "serviceId",
        "orderType",
        "type",
        "trxId"
})
@XmlRootElement(name = "sampleservicerq")
public class Sampleservicerqrest {

    @NonNull
    @XmlElement(name = "service_id", required = true)
    protected String serviceId;

    @NonNull
    @XmlElement(name = "order_type", required = true)
    protected String orderType;

    @XmlElement(required = true)
    protected String type;

    @XmlElement(name = "trx_id", required = true)
    protected String trxId;
}
