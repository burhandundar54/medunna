package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class US10_Physician {
    private US10_User user;
    private String firstName;
    private int id;
    public US10_Physician() {
    }
    public US10_Physician(US10_User user, String firstName, int id) {
        this.user = user;
        this.firstName = firstName;
        this.id = id;
    }
    public US10_User getUser() {
        return user;
    }
    public void setUser(US10_User user) {
        this.user = user;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "US10_Physician{" +
                "user=" + user +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }
}
