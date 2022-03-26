package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class US10_Appointment {
    private    US10_Physician physician;
    private    US10_Patient patient;
    private   String endDate;
    private String startDate;
    private   int id;
    private String status;
    public US10_Appointment() {
    }
    public US10_Appointment(US10_Physician physician, US10_Patient patient, String endDate, String startDate, int id, String status) {
        this.physician = physician;
        this.patient = patient;
        this.endDate = endDate;
        this.startDate = startDate;
        this.id = id;
        this.status = status;
    }
    public US10_Physician getPhysician() {
        return physician;
    }
    public void setPhysician(US10_Physician physician) {
        this.physician = physician;
    }
    public US10_Patient getPatient() {
        return patient;
    }
    public void setPatient(US10_Patient patient) {
        this.patient = patient;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "US10_Appointment{" +
                "physician=" + physician +
                ", patient=" + patient +
                ", endDate='" + endDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
