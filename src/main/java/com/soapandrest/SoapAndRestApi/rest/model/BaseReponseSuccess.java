package com.soapandrest.SoapAndRestApi.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseReponseSuccess<T> {

    private T sampleServices;

}
