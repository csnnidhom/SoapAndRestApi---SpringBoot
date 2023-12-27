package com.soapandrest.SoapAndRestApi.soap.endpoint;

import com.soapandrest.SoapAndRestApi.rest.entity.Sample;

import com.soapandrest.SoapAndRestApi.rest.model.Sampleservicerqrest;
import com.soapandrest.SoapAndRestApi.rest.model.Sampleservicersrest;
import com.soapandrest.SoapAndRestApi.rest.service.SampleServices;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class SampleEndpoint {
    private static final String NAMESPACE_URI = "http://www.oracle.com/external/services/sampleservice/request/v1.0";

    private final SampleServices sampleService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sampleservicerq")
    @ResponsePayload
    public Sampleservicersrest addSample(@RequestPayload Sampleservicerqrest request) {
        Sampleservicersrest response = new Sampleservicersrest();

        Sample sample = new Sample();
        sample.setServiceId(request.getServiceId());
        sample.setOrderType(request.getOrderType());
        sample.setType(request.getType());
        sample.setTrxId(request.getTrxId());
        boolean flag = sampleService.addSample(sample);
        if (flag == false) {
            response.setErrorCode("Error");
            response.setErrorMsg("Service Id Already Available");
            response.setTrxId(request.getTrxId());
        } else {
            response.setErrorCode("0000");
            response.setErrorMsg("Success");
            response.setTrxId(request.getTrxId());
        }
        return response;

    }
}
