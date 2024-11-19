package edu.gmu.cs321;

public class Immigrant extends Person {
    private String ssn;

    protected Immigrant(Builder builder) {
        super(builder);
        this.ssn = builder.ssn;
    }

    public String getSSN() { return ssn; }

    public static class Builder<T extends Builder<T>> extends Person.Builder<T> {
        protected String ssn;

        public T setSSN(String ssn) {
            this.ssn = ssn;
            return self();
        }
        
        @Override
        public Immigrant build() { return new Immigrant(this); }
    }
}
