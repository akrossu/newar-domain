package edu.gmu.cs321;

public class ImmRelative extends Immigrant {
    private int alienRegistrationNumber;
    private String relationship;
    private String nationality;

    public ImmRelative(Builder builder) {
        super(builder);
        this.alienRegistrationNumber = builder.alienRegistrationNumber;
        this.relationship = builder.relationship;
        this.nationality = builder.nationality;
    }

    public int getAlienRegistrationNumber() { return alienRegistrationNumber; }
    public String getRelationship() { return relationship; }
    public String getNationality() { return nationality; }

    public static class Builder<T extends Builder <T>> extends Immigrant.Builder<T> {
        protected int alienRegistrationNumber;
        protected String relationship;
        protected String nationality;

        public T setAlienRegistrationNumber(int alienRegistrationNumber) {
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

        public ImmRelative build() { return new ImmRelative(this); }
    }
}
