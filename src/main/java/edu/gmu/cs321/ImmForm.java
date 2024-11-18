package edu.gmu.cs321;

public class ImmForm {
    private Immigrant immigrant;
    private ImmRelative relative;
    private String creationDate;
    private String status;
    // Constructor
    public ImmForm(Immigrant immigrant) {
            this.immigrant = immigrant;
    }

    public ImmForm(ImmRelative relative) {
        this.relative = relative;
    }

    public ImmForm() {}

    public boolean validateForm() {
        if (immigrant == null || relative == null) {
            return false; // Fail if critical fields are missing
        }
        return true;
    }
    public Immigrant getImmigrant() {
        return immigrant;
    }
    public ImmRelative getRelative() {
        return relative;
    }
    public String getCreationDate() {
        return creationDate;
    }
    public boolean setCreationDate(String creationDate) {
        this.creationDate = creationDate;
        return true;
    }
    public String getFormStatus() {
        return status; }
    public boolean updateFormStatus(String newStatus) {
        status=newStatus;
        return true;
    }
}