package com.soapandrest.SoapAndRestApi.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sample")
public class Sample {

    @Id
    private String serviceId;

    private String orderType;

    private String type;

    private String trxId;
}
