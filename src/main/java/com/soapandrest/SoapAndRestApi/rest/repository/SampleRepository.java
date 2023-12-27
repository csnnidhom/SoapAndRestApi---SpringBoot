package com.soapandrest.SoapAndRestApi.rest.repository;

import com.soapandrest.SoapAndRestApi.rest.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<Sample, String> {

    List<Sample> findByServiceId(String serviceId);

    boolean existsByServiceId(String serviceId);
}
