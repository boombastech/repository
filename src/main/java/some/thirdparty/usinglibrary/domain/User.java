package some.thirdparty.usinglibrary.domain;

public class User {
    private final String id;
    private String username;

    public User (String id) {
        this.id = id;
        this.username = "cheese";
    }

    public String getId () {
        return id;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }
}