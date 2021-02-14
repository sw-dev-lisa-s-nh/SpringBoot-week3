package com.lisasmith.findAGig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lisasmith.findAGig.entity.Instrument;
import com.lisasmith.findAGig.service.InstrumentService;

@RestController
@RequestMapping("/instruments")
public class InstrumentController {
	
	@Autowired
	private InstrumentService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getInstruments() {
		return new ResponseEntity<Object>(service.getInstruments(), HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createInstrument(@RequestBody Instrument instrument) throws Exception {
		return new ResponseEntity<Object>(service.createInstrument(instrument), HttpStatus.CREATED);
	}

}
