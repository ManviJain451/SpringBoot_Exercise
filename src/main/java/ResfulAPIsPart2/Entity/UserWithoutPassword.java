package ResfulAPIsPart2.Entity;
public class UserWithoutPassword {

    private Integer id;
    private String name;

    public UserWithoutPassword(){}

    public UserWithoutPassword(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}