package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {
    /*
    {
            "createdBy": "anonymousUser",
            "createdDate": "2022-01-13T18:14:21.637681Z",
            "id": 8354,
            "firstName": "Tiara",
            "lastName": "Pollich",
            "birthDate": null,
            "phone": "(325) 088-9927",
            "gender": "MALE",
            "bloodGroup": "Apositive",
            "adress": null,
            "email": "grant.weimann@gmail.com",
            "description": null,
            "user": {
                "createdBy": "anonymousUser",
                "createdDate": "2022-01-13T18:14:21.636483Z",
                "id": 8204,
                "login": "user_112233445_56677889991642097661549",
                "firstName": "Tiara",
                "lastName": "Pollich",
                "email": "grant.weimann@gmail.com",
                "activated": false,
                "langKey": null,
                "imageUrl": null,
                "resetDate": null,
                "ssn": "721-28-7926"
            },
            "inPatients": null,
            "country": null,
            "cstate": null
        },
     */

    private Country country;
    private CState cstate;
    private String email;
    private String firstName;
    private Integer id;
    private String lastName;
    private String phone;
    private String ssn;
    private User user;
    private String startDate;


    public Patient() {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public CState getCstate() {
        return cstate;
    }

    public void setCstate(CState cstate) {
        this.cstate = cstate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "country=" + country +
                ", cstate=" + cstate +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", ssn='" + ssn + '\'' +
                ", user=" + user +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}
