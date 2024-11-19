package edu.gmu.cs321;

public class ImmForm {
    private Immigrant immigrant;
    private ImmRelative relative;
    private int id;
    private String creationDate;
    private String status;
    // Constructor
    public ImmForm(int id,Immigrant immigrant,ImmRelative relative, String creationDate,String status) {
            this.relative=relative;
            this.id=id;
            this.creationDate=creationDate;
            this.status=status;
            this.immigrant = immigrant;
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