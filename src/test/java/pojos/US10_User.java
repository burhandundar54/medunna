package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class US10_User {
    private String login;
    private int id;
    public US10_User() {
    }
    public US10_User(String login, int id) {
        this.login = login;
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "US10_User{" +
                "login='" + login + '\'' +
                "id='"+id+ '\'' +
                '}';
    }
}