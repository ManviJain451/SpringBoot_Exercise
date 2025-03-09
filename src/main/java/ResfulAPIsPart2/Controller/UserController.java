package ResfulAPIsPart2.Controller;

import ResfulAPIsPart2.Entity.User;
import ResfulAPIsPart2.Service.UserService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Operation(summary = "Get User Details", description = "Fetch details of a user using their ID")
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @Operation(summary = "Save User Details", description = "Save user details in the system")
    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @Operation(summary = "Delete User", description = "Delete a user by ID")
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
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
