package pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentOuter {

    /*
    [
    {
        "createdBy": "anonymousUser",
        "createdDate": "2021-12-21T22:33:06.907662Z",
        "id": 3403,
        "startDate": "2021-12-22T17:00:00Z",
        "endDate": "2021-12-22T18:00:00Z",
        "status": "UNAPPROVED",
        "anamnesis": null,
        "treatment": null,
        "diagnosis": null,
        "prescription": "",
        "description": "cfgvhbjn",
        "physician":
        "patient":
        "ctests": null
    },
     */
    private String createdBy;
    private String createdDate;
    private Integer id;
    private String startDate;
    private String endDate;
    private String status;
    private String anamnesis;
    private String diagnosis;
    private Physician physician;
    private	Patient patient;



    public AppointmentOuter() {
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AppointmentOuter{" +
                "anamnesis='" + anamnesis + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", endDate='" + endDate + '\'' +
                ", id='" + id + '\'' +
                ", patient=" + patient +
                ", physician=" + physician +
                ", startDate='" + startDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
