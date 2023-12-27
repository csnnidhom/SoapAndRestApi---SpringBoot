package com.soapandrest.SoapAndRestApi.rest.service;

import com.soapandrest.SoapAndRestApi.rest.entity.Sample;
import com.soapandrest.SoapAndRestApi.rest.model.Sampleservicerqrest;
import com.soapandrest.SoapAndRestApi.rest.model.Sampleservicersrest;
import com.soapandrest.SoapAndRestApi.rest.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleServices implements ISampleServices{

    private final SampleRepository sampleRepository;

    private final ValidationService validationService;

    public Sampleservicersrest post(Sampleservicerqrest request){

        validationService.validate(request);

        if (sampleRepository.existsByServiceId(request.getServiceId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID already exist");
        }

        Sample sample = new Sample();
        sample.setServiceId(request.getServiceId());
        sample.setOrderType(request.getOrderType());
        sample.setType(request.getType());
        sample.setTrxId(request.getTrxId());
        sampleRepository.save(sample);

        return Sampleservicersrest.builder()
                .errorCode("0000")
                .errorMsg("Success")
                .trxId(sample.getTrxId())
                .build();
    }


    @Override
    public boolean addSample(Sample sample) {
        List<Sample> list = sampleRepository.findByServiceId(sample.getServiceId());
        if (list.size() > 0){
            return false;
        }else {
            sample = sampleRepository.save(sample);
            return true;
        }
    }
}
