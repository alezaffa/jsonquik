package it.azware.jsonquik.controller;

import org.springframework.http.ResponseEntity;

import it.azware.jsonquik.model.MyDemoClass;

public interface JsonQuikController {

	public ResponseEntity<String> getJson(String pretty);
	
	public ResponseEntity<MyDemoClass> getObject();
	
}