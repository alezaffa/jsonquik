package it.azware.jsonquik.controller;

import it.azware.jsonquik.model.MyDemoClass;
import it.azware.jsonquik.service.JsonQuikService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JsonQuikControllerImpl implements JsonQuikController {

    private final JsonQuikService jsonQuikService;

    @Override
    public ResponseEntity<String> getJson(String pretty) {
        pretty = StringUtils.defaultIfBlank(pretty, "Y");
        String json = pretty.equalsIgnoreCase("Y")
                ? jsonQuikService.toPrettyJson(new MyDemoClass())
                : jsonQuikService.toJson(new MyDemoClass());
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

}
