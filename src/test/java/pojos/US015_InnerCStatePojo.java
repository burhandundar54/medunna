package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class US015_InnerCStatePojo {

    private int id;
    private String name;
    private US015_InnerCountryPojo country;

    public US015_InnerCStatePojo() {
    }

    public US015_InnerCStatePojo(int id, String name, US015_InnerCountryPojo country) {
        //this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public US015_InnerCountryPojo getCountry() {
        return country;
    }

    public void setCountry(US015_InnerCountryPojo country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}