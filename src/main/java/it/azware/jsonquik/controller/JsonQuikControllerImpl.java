package it.azware.jsonquik.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import it.azware.jsonquik.model.MyDemoClass;
import it.azware.jsonquik.service.JsonQuikService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v2")
@AllArgsConstructor
public class JsonQuikControllerImpl implements JsonQuikController {

	private final JsonQuikService jsonQuikService;

	@GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ResponseEntity<String> getJson(@RequestParam(required = false) String pretty) {
		pretty = StringUtils.defaultIfBlank(pretty, "Y");
		String json = pretty.equalsIgnoreCase("Y") 
				? jsonQuikService.toPrettyJson(new MyDemoClass())
				: jsonQuikService.toJson(new MyDemoClass());
		return ResponseEntity.status(HttpStatus.OK).body(json);
	}
	
	@GetMapping(value = "/obj", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ResponseEntity<MyDemoClass> getObject() {
		String prettyJson = jsonQuikService.toPrettyJson(new MyDemoClass());
		MyDemoClass myDemoClass = new Gson().fromJson(prettyJson, MyDemoClass.class);
		return ResponseEntity.status(HttpStatus.OK).body(myDemoClass);
	}
}
