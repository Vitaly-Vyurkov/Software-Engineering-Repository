package com.webapp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    DataSourceProperties dataSourceProperties;

    @GetMapping("/users")
    @Tag (
            name = "API that returns aggregate list.",
            description = "Retrieval of aggregate list."
    )
    @Operation (
            summary = "API that returns aggregate list.",
            description = "Retrieval of aggregate list."
    )
    @ApiResponse(responseCode = "200", description = "The aggregate list is successfully retrieved", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    public ResponseEntity<List<User>> getUsers() {
        try {
            List<User> users = UserDataAggregator.aggregateUserData(dataSourceProperties.getDataSources ());

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
