package edu.gmu.cs321;

public class ImmForm
{
    private Immigrant immigrant;
    private ImmRelative relative;
    private String creationDate;
    private String status;
    // Constructor
    public ImmForm(Immigrant immigrant, ImmRelative relative, String creationDate, String status) {
            this.immigrant = immigrant;
            this.relative = relative;
            this.creationDate = creationDate;
            this.status = status;
    }
    
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
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    public String getFormStatus() {
        return status; }
    public void updateFormStatus(String newStatus) {
        status=newStatus;
    }
}