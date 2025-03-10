package ResfulAPIsPart2.Controller;

import ResfulAPIsPart2.Entity.User;
import ResfulAPIsPart2.Entity.UserWithoutPassword;
import ResfulAPIsPart2.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "APIs for managing users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/save-dynamic")
    public MappingJacksonValue saveUserDynamic(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("password");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(savedUser);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/get-dynamic/{id}")
    public MappingJacksonValue GetUserDynamic(@PathVariable int id) {
        User user = userService.getUserById(id);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("password");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping;
    }


    @Operation(summary = "Save User Details", description = "Save user details in the system")
    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }



    @PostMapping(value = "/save-xml", produces = {"application/xml", "application/json"}, consumes = {"application/xml", "application/json"})
    public User saveUserThroughXml(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @Operation(summary = "Delete User", description = "Delete a user by ID")
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @Operation(summary = "Get User Details", description = "Fetch details of a user using their ID")
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

//    @GetMapping(value = "/withID/{id}", produces = "application/vnd.company.app-v1+json")
//    public User getAllUserDetails(@PathVariable int id) {
//        return userService.getUserById(id);
//
//    }
//
//    @GetMapping(value = "/withID/{id}", produces = "application/vnd.company.app-v2+json")
//    public UserWithoutPassword getUserDetails(@PathVariable int id) throws JsonProcessingException {
//        User user = userService.getUserById(id);
//        return new UserWithoutPassword(user.getId(), user.getName());
//
//    }

//    @GetMapping(value = "/withID/{id}", params = "version=1")
//    public UserWithoutPassword getAllUserDetails(@PathVariable int id) {
//        User user = userService.getUserById(id);
//        return new UserWithoutPassword(user.getId(), user.getName());
//    }
//
//    @GetMapping(value = "/withID/{id}", params = "version=2")
//    public User getUserDetails(@PathVariable int id) throws JsonProcessingException {
//        return userService.getUserById(id);
//
//    }

    @GetMapping(value = "/withID/v1/{id}")
    public UserWithoutPassword getAllUserDetails(@PathVariable int id) {
        User user = userService.getUserById(id);
        return new UserWithoutPassword(user.getId(), user.getName());
    }

    @GetMapping(value = "/withID/v2/{id}")
    public User getUserDetails(@PathVariable int id) throws JsonProcessingException {
        return userService.getUserById(id);

    }

//    @GetMapping(value = "/withID/{id}", headers = "X-API-VERSION=1")
//    public UserWithoutPassword getAllUserDetails(@PathVariable int id) {
//        User user = userService.getUserById(id);
//        return new UserWithoutPassword(user.getId(), user.getName());
//    }
//
//    @GetMapping(value = "/withID/{id}", headers = "X-API-VERSION=2")
//    public User getUserDetails(@PathVariable int id) throws JsonProcessingException {
//        return userService.getUserById(id);
//
//    }


    @GetMapping("/userWithTopic/{id}")
    public EntityModel<User> getUserWithTopics(@PathVariable int id) {
        User user = userService.getUserById(id);

        // Creating a HATEOAS link to fetch all topics
        Link topicsLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(TopicController.class).getAllTopics())
                .withRel("all-topics");

        // Wrap the user object inside EntityModel and add the link
        EntityModel<User> resource = EntityModel.of(user);
        resource.add(topicsLink);

        return resource;
    }



//    @Operation(summary = "Get All Users (XML)", description = "Fetch all users in XML format")
//    @GetMapping(produces = "application/xml")
//    public List<User> getAllUsersXml() {
//        return userService.getAllUsers();
//    }
//
//    @Operation(summary = "Create User (XML)", description = "Create a user by sending XML data")
//    @PostMapping(consumes = "application/xml", produces = "application/xml")
//    public User saveUserXMl(@RequestBody User user) {
//        userService.saveUser(user);
//        return user;
//    }

}
