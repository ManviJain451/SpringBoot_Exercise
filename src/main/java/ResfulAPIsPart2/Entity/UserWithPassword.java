package ResfulAPIsPart2.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserWithPassword extends User {
    @JsonProperty("password")
    private String password;

    public UserWithPassword(User user) {
        super(user.getName(), user.getPassword());
        this.setId(user.getId());
        this.password = user.getPassword();
    }
}