package it.azware.jsonquik.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/api/v2")
public interface JsonQuikController {

    @ResponseBody
    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Return a json filled with random values related to the provided model")
    ResponseEntity<String> getJson(@RequestParam(required = false)
                                   @ApiParam(value = "Indicates if a pretty formatted json should be returned", example = "y")
                                           String pretty);

}