package com.cropdeal.dealerservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.cropdeal.dealerservice.exception.DealerNotFoundException;
import com.cropdeal.dealerservice.model.Crop;
import com.cropdeal.dealerservice.model.Dealer;
import com.cropdeal.dealerservice.service.DealerService;

@RestController
@RequestMapping("/dealer")
public class DealerController {
	
	Logger log = LoggerFactory.getLogger(DealerController.class);

	@Autowired
	DealerService dealerservice;
	
	@Autowired
	private RestTemplate restTemp;


	@GetMapping("/finddealers")
	public List<Dealer> getdealer() {
		log.info("All dealers are viewed");
    return dealerservice.findAll();
	}
	  	 
	  @GetMapping("/getDealerById/{id}")
	  public Dealer getdealerById(@PathVariable String id)throws DealerNotFoundException{
		     log.info(" dealer based on id is viewed");
      return dealerservice.getDealerById(id);
	 }
	  
	   @PostMapping("/adddealer")
		public Dealer adddealer(@RequestBody Dealer dealer) {
			log.info(" New dealer details are added");
			return 	dealerservice.addDealer(dealer);
		}
	  
	  @PutMapping("/updatedealer")
	  public Dealer updatedealer(@RequestBody Dealer dealer) {
			log.info("dealer details are updated");
		  return dealerservice.updateDealer(dealer);
      }
	  
	  @DeleteMapping("/deletedealer/{id}")
		public String deletedealer(@PathVariable String id) {
			log.info("Deleted dealer based on id");
		  dealerservice.deleteById(id);
	    return "farmer deleted having id " + id;
	}
	  
	//-----------Dealer access to crop---------

//		@GetMapping("/dealer/get/crop")
//		public List<Crop> getCropatDealer() {
//			Crop[] crop = restTemp.getForObject("http://CropService/crop/findcrops", Crop[].class);
//			return Arrays.asList(crop);
//		}
	  
	  @GetMapping("/dealer/get/crop")
		public List<Object> getCropatDealer() {
			log.info(" crop details will be viewed by dealer");
			Object[] crop = restTemp.getForObject("http://CropService/crop/findcrops", Object[].class);
			return Arrays.asList(crop);
		}

	

}

