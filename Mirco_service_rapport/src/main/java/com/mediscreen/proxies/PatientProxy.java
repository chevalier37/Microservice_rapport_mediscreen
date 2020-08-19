package com.mediscreen.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mediscreen.model.Patient;

@FeignClient(name = "micro-patient")
@RibbonClient(name = "micro-patient")
public interface PatientProxy {

	@GetMapping("patient/getPatient/{id}")
	Patient showPatient(@PathVariable("id") int id);

}
