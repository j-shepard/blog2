package local.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class InformationResource {
    
    private final SimpleJdbcInsert simpleJdbcInsert;
    
    public InformationResource(SimpleJdbcInsert simpleJdbcInsert) {
        this.simpleJdbcInsert = simpleJdbcInsert;
    }

    @PostMapping("/api/v1/insertinformation")
    @ResponseStatus(HttpStatus.CREATED)
    UUID insertInformation(@RequestBody InformationDto informationDto) {
        String description = informationDto.description();
        String jsonData = informationDto.jsonData();
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("description", description);
        parameters.put("json_data", jsonData);

        Number key = simpleJdbcInsert.executeAndReturnKey(parameters);

        return UUID.fromString(key.toString());
    }
}
