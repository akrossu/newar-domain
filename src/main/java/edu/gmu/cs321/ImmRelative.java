package edu.gmu.cs321;

public class ImmRelative extends Immigrant {
    private String alienRegistrationNumber;
    private String relationship;
    private String nationality;
    private String citizenshipStatus;

    public ImmRelative(Builder builder) {
        super(builder);
        this.alienRegistrationNumber = builder.alienRegistrationNumber;
        this.relationship = builder.relationship;
        this.nationality = builder.nationality;
        this.citizenshipStatus = builder.citizenshipStatus;
    }

    public String getAlienRegistrationNumber() { return alienRegistrationNumber; }
    public String getRelationship() { return relationship; }
    public String getNationality() { return nationality; }
    public String getCitizenshipStatus() { return citizenshipStatus; }

    public static class Builder<T extends Builder <T>> extends Immigrant.Builder<T> {
        protected String alienRegistrationNumber;
        protected String relationship;
        protected String nationality;
        protected String citizenshipStatus;

        public T setAlienRegistrationNumber(String alienRegistrationNumber) {
            this.alienRegistrationNumber = alienRegistrationNumber;
            return self();
        }

        public T setRelationship(String relationship) {
            this.relationship = relationship;
            return self();
        }

        public T setNationality(String nationality) {
            this.nationality = nationality;
            return self();
        }

        public T setCitizenshipStatus(String citizenshipStatus) {
            this.citizenshipStatus = citizenshipStatus;
            return self();
        }

        public ImmRelative build() { return new ImmRelative(this); }
    }
}
