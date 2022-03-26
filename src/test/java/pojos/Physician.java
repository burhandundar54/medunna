package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Physician {
    /*
    {
            "createdBy": "oscarlebsack",
            "createdDate": "2022-03-01T13:26:00.734890Z",
            "id": 10501,
            "firstName": "Arif",
            "lastName": "Canpol",
            "birthDate": "1991-01-31T23:00:00Z",
            "phone": "5354334312",
            "gender": "MALE",
            "bloodGroup": "Apositive",
            "adress": "",
            "description": "",
            "user": {
                "createdBy": "anonymousUser",
                "createdDate": "2022-03-01T13:19:47.400256Z",
                "id": 10097,
                "login": "arifcanpol135",
                "firstName": "Arif",
                "lastName": "Canpol",
                "email": "canpolska@gmail.co",
                "activated": true,
                "langKey": "en",
                "imageUrl": null,
                "resetDate": null,
                "ssn": "331-13-1131"
            },
            "speciality": "ALLERGY_IMMUNOLOGY",
            "country": null,
            "cstate": null,
            "examFee": 200.00,
            "image": "",
            "imageContentType": null
        },
     */

    private String appointments;

    private Country country;
    private CState cstate;
    private int examFee;
    private String firstName;
    private String phone;
    private String ssn;
    private User user;


    public Physician() {
    }

    public String getAppointments() {
        return appointments;
    }

    public void setAppointments(String appointments) {
        this.appointments = appointments;
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

    public int getExamFee() {
        return examFee;
    }

    public void setExamFee(int examFee) {
        this.examFee = examFee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    @Override
    public String toString() {
        return "Physician{" +
                "appointments='" + appointments + '\'' +
                ", country=" + country +
                ", cstate=" + cstate +
                ", examFee=" + examFee +
                ", firstName='" + firstName + '\'' +
                ", phone='" + phone + '\'' +
                ", ssn='" + ssn + '\'' +
                ", user=" + user +
                '}';
    }
}
