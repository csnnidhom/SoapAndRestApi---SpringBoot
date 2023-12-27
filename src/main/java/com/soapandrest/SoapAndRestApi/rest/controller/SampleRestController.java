package com.soapandrest.SoapAndRestApi.rest.controller;

import com.soapandrest.SoapAndRestApi.rest.model.BaseReponseSuccess;
import com.soapandrest.SoapAndRestApi.rest.model.Sampleservicerqrest;
import com.soapandrest.SoapAndRestApi.rest.model.Sampleservicersrest;
import com.soapandrest.SoapAndRestApi.rest.service.SampleServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SampleRestController {

    private final SampleServices sampleServices;

    @PostMapping(path = "/external/services/rest/sample-service")
    public BaseReponseSuccess<Sampleservicersrest> get(@RequestBody Sampleservicerqrest request){
        Sampleservicersrest sampleservicers = sampleServices.post(request);
        return BaseReponseSuccess.<Sampleservicersrest>builder().sampleServices(sampleservicers).build();
    }

}
