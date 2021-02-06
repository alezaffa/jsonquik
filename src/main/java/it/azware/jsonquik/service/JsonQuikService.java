package it.azware.jsonquik.service;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@Slf4j
@Service
public class JsonQuikService {

    private static final String JSON_RESULT_MSG = "Result:\r\n{}";

    public String toJson(Object pojo) {
	PodamFactory factory = new PodamFactoryImpl();
	Object myPojo = factory.manufacturePojo(pojo.getClass());
	final String json = new Gson().toJson(myPojo);
	log.info(JSON_RESULT_MSG, json);
	return json;
    }

    public String toPrettyJson(Object pojo) {
	PodamFactory factory = new PodamFactoryImpl();
	Object myPojo = factory.manufacturePojo(pojo.getClass());
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	final String json = gson.toJson(myPojo);
	log.info(JSON_RESULT_MSG, json);
	return json;
    }

}
