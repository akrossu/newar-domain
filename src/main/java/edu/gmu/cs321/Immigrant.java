package edu.gmu.cs321;

public class Immigrant extends Person {
    private int immID;
    private String citizenshipStatus;

    protected Immigrant(Builder builder) {
        super(builder);
        this.immID = builder.immID;
        this.citizenshipStatus = builder.citizenshipStatus;
    }

    public int getID() { return immID; }
    public String getCitizenshipStatus() { return citizenshipStatus; }

    public static class Builder<T extends Builder<T>> extends Person.Builder<T> {
        protected int immID;
        protected String citizenshipStatus;

        public T setID(int immID) {
            this.immID = immID;
            return self();
        }

        public T setCitizenshipStatus(String citizenshipStatus) {
            this.citizenshipStatus = citizenshipStatus;
            return self();
        }

        @Override
        public Immigrant build() { return new Immigrant(this); }
    }
}
