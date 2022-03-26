package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class US015_Create_Edit_Patient_Pojo {

    /*
    {
        "createdBy": null,
        "createdDate": null,
        "id": null,
        "firstName": "muzafferrr",
        "lastName": "ucakbocerkk",
        "birthDate": null,
        "phone": "555-555-5555",
        "gender": null,
        "bloodGroup": null,
        "adress": null,
        "email": "dgssffsa12@gm.com",
        "description": null,
        "user": {
            "createdBy": null,
            "createdDate": null,
            "id": 11034,
            "login": null,
            "firstName": null,
            "lastName": null,
            "email": null,
            "activated": null,
            "langKey": null,
            "imageUrl": null,
            "resetDate": null,
            "ssn": null
        },
        "appointments": null,
        "inPatients": null,
        "country": {
            "id": 1201,
            "name": "US"
        },
        "cstate": {
            "id": 1255,
            "name": "California",
            "country": {
                "id": 1201,
                "name": "US"
            }
        }
    }
     */

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private US015_InnerUserPojo user;
    private US015_InnerCountryPojo country;
    private US015_InnerCStatePojo cstate;

    public US015_Create_Edit_Patient_Pojo() {
    }

    public US015_Create_Edit_Patient_Pojo(String firstName, String lastName, String phone, String email, US015_InnerUserPojo user, US015_InnerCountryPojo country, US015_InnerCStatePojo cstate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.user = user;
        this.country = country;
        this.cstate = cstate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public US015_InnerUserPojo getUser() {
        return user;
    }

    public void setUser(US015_InnerUserPojo user) {
        this.user = user;
    }

    public US015_InnerCountryPojo getCountry() {
        return country;
    }

    public void setCountry(US015_InnerCountryPojo country) {
        this.country = country;
    }

    public US015_InnerCStatePojo getCstate() {
        return cstate;
    }

    public void setCstate(US015_InnerCStatePojo cstate) {
        this.cstate = cstate;
    }

    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", user=" + user +
                ", country=" + country +
                ", cstate=" + cstate +
                '}';
    }
}