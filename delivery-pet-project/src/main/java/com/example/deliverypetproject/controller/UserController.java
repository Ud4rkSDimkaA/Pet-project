package com.example.deliverypetproject.controller;

import com.example.deliverypetproject.dto.UserDto;
import com.example.deliverypetproject.exception.database.UserDBNotFoundException;
import com.example.deliverypetproject.model.User;
import com.example.deliverypetproject.service.user.UserRepositoryServiceImpl;
import com.example.deliverypetproject.service.user.UserValidationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerError;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User Controller", description = "This controller is used to get user's")
public class UserController {

    private final UserRepositoryServiceImpl userRepositoryService;
    private final UserValidationService validationService;

    @GetMapping("/all")
    @Operation(summary = "Gets all users", description = "Users must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success operation", content =
            @Content(mediaType = "application/json", schema = @Schema(implementation = User[].class))),
            @ApiResponse(responseCode = "400", description = "User list in null/there are no users"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> allUsers = userRepositoryService.getAllUsers();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user: allUsers){
            UserDto userDto = new UserDto(user.getUsername(),user.getRole(),user.getPassword(),
                    user.getEmail(),user.getDateOfBirthday(),user.getCreated(),user.getUpdated(),
                    user.isBlocked());
            userDtos.add(userDto);
        }
        if (!userDtos.isEmpty()) {
            for (UserDto user : userDtos) {
                Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getAllUsers()).withRel("/user-" + user.getUsername());
                user.add(link);
            }
            return ResponseEntity.status(200).body(userDtos);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Gets user by id", description = "Users must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success operation"),

            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),

            @ApiResponse(responseCode = "404", description = "User not found", content =
            @Content(schema = @Schema(implementation = UserDBNotFoundException.class))),

            @ApiResponse(responseCode = "500", description = "Internal server error", content =
            @Content(schema = @Schema(implementation = ServerError.class)))})
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") String userId) {
        long parsedUserId = Long.parseLong(userId);
        User userById = userRepositoryService.getUserById(parsedUserId);
        User findUserById = userRepositoryService.getUserById(parsedUserId);
        if (findUserById != null) {
            return ResponseEntity.status(200).body(userById);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    @PostMapping()
    @Operation(summary = "Save new user", description = "User's body has to be full")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success operation"),

            @ApiResponse(responseCode = "404", description = "Invalid user's input"),

            @ApiResponse(responseCode = "500", description = "Internal server error", content =
            @Content(schema = @Schema(implementation = ServerError.class)))})

    public ResponseEntity<User> saveNewUser(@Valid @RequestBody User user, BindingResult result) {
        boolean isUserValidToSave = validationService.isValid(result);
        if (isUserValidToSave) {
            userRepositoryService.saveNewUser(user);
            log.info("User with name {} was saved", user.getUsername());
            return ResponseEntity.status(200).body(user);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success operation"),

            @ApiResponse(responseCode = "404", description = "User with such id doesn't exist", content =
            @Content(schema = @Schema(implementation = UserDBNotFoundException.class))),

            @ApiResponse(responseCode = "500", description = "Internal server error", content =
            @Content(schema = @Schema(implementation = ServerError.class)))})
    @Operation(summary = "Delete user", description = "User has to have an id")
    public ResponseEntity<User> deleteUserById(@PathVariable(name = "id") Long userId) {
        User userById = userRepositoryService.getUserById(userId);
        userRepositoryService.deleteUserById(userId);
        log.info("User {} was deleted", userById.getUsername());
        return ResponseEntity.status(200).body(userById);
    }

    @DeleteMapping("/name/{username}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success operation"),

            @ApiResponse(responseCode = "404", description = "User with such id doesn't exist", content =
            @Content(schema = @Schema(implementation = UserDBNotFoundException.class))),

            @ApiResponse(responseCode = "500", description = "Internal server error", content =
            @Content(schema = @Schema(implementation = ServerError.class)))})
    @Operation(summary = "Delete user", description = "User has to have an id")
    public ResponseEntity<User> deleteUserByUsername(@PathVariable(name = "username") String username) {
        User userByUsername = userRepositoryService.getUserByUsername(username);
        userRepositoryService.deleteUserByUsername(username);
        log.info("User {} was deleted", userByUsername.getUsername());
        return ResponseEntity.status(200).body(userByUsername);
    }

    @Operation(summary = "Update user's information", description = "User has to have an id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success operation"),

            @ApiResponse(responseCode = "500", description = "Internal server error", content =
            @Content(schema = @Schema(implementation = ServerError.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUserInformation(@PathVariable(name = "id") Long userId, @RequestBody User user) {
        userRepositoryService.updateUser(userId, user);
        User userById = userRepositoryService.getUserById(userId);
        log.info("User {} was updated", userById);
        return ResponseEntity.status(200).build();
    }
}
