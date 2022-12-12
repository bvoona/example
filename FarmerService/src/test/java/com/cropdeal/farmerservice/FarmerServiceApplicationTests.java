package com.cropdeal.farmerservice;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cropdeal.farmerservice.model.Farmer;
import com.cropdeal.farmerservice.controller.FarmerController;
import com.cropdeal.farmerservice.exception.FarmerNotFoundException;
import com.cropdeal.farmerservice.repository.FarmerRepository;
import com.cropdeal.farmerservice.service.FarmerService;
import com.cropdeal.farmerservice.service.FarmerServiceImpl;

@SpringBootTest
class FarmerServiceApplicationTests {

	  @Autowired
	   private FarmerServiceImpl service;
	   @MockBean
	    private FarmerRepository farmerrepo;
	   
	    @Test
	    public void getFarmerTest() {
	        when(farmerrepo.findAll()).thenReturn(Stream
	                .of(new Farmer("123","abcd","abc@123","34567889", null,null),
	                        new Farmer("321","cba","cba@321","34567889", null,null))
	                .collect(Collectors.toList()));
	        assertEquals(2, service.findAll().size());
	    }
	    
	    @Test
	    public void getfarmerByIdTest() throws FarmerNotFoundException {
	    	String id= "1";
	    	try {
	    		service.getFarmerById(id);
	    	}
	    	catch(FarmerNotFoundException e)
	    	{
	    		System.out.println(e);
	    	}
	    	
	        
	    }

		@Test
	    public void addfarmerTest() {
	        Farmer farmer = new Farmer("1","abc","abc@gmail.com","12412414",null,null);
	        when(farmerrepo.insert(farmer)).thenReturn(farmer);
	        Farmer res=service.addFarmer(farmer);
	        equals(!res.toString().isEmpty());
	    }
	      

	    @Test
	    public void deleteFarmerbyidTest() {
	        String farmer = Farmer("999", "def","def@33", "234567",null,null);
	        String id = "3";
	        service.deleteById(id);
	        verify(farmerrepo, times(1)).deleteById(id);
	    }



	   private String Farmer(String string, String string2, String string3, String string4, Object object, Object object2) {
	        return null;
	    }
	}
	
	   
//	    @Test
//	    public void getFarmerTest() {
//	        when(farmerrepo.findAll()).thenReturn(Stream
//	                .of(new Farmer(123,"abcd","abc@123","34567889", null,null),
//	                        new Farmer(321,"cba","cba@321","34567889", null,null))
//	                .collect(Collectors.toList()));
//	        assertEquals(2, service.getFarmersList());
//	    }
//	   
//	   
//	   
//	   
//
////	    @Test
//	    public void deleteFarmerbyidTest() {
//	        String farmer = Farmer("999", "def", "234567", null, null);
//	        service.getFarmerById("999");
//	        verify(farmerrepo, times(1)).deleteById("999");
//	    }
//
//	   private String Farmer(String i, String string, String string2, Object object, Object object2) {
//	        // TODO Auto-generated method stub
//	        return null;
//	    }
//
//	   @Test
//	    void addfarmerTest() {
//	        Farmer farmer = new Farmer("345", "efgh", "efgh@34", "676489", null, null);
//	        when(farmerrepo.save(farmer)).thenReturn(farmer);
//	        Farmer res = service.getFarmerById("345");
//	        System.out.println(res);
//	        equals(!res.toString().isEmpty());
//	        
//	    }
//	    @Test
//	    void getFarmerByIdTest() {
//	        String id="2";
//	       service.getFarmerById("2");
//	       verify(farmerrepo).findById(id);
//	   }
//	    
//	}
	
	



