package ResfulAPIsPart2.Entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;


@Table(name = "UsersDetails")
@Schema(description = "User Entity representing a user in the system")

@JacksonXmlRootElement(localName = "user")
@Entity
@JsonFilter("UserFilter")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JacksonXmlProperty(localName = "name")
    private String name;

//    @JsonIgnore
    private String password;

    public User() {}
    public User(String name, String password) {

        this.name = name;
        this.password  = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
