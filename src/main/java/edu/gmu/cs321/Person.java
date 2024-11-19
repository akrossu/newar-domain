package edu.gmu.cs321;


import java.sql.Date;

public class Person {
    private String name;
    private Date dateOfBirth;

    public Person(Builder builder) {
        this.name = builder.name;
        this.dateOfBirth = builder.dateOfBirth;
    }

    public String getName() { return name; }
    public Date getDateOfBirth() { return dateOfBirth; }

    public static class Builder<T extends Builder> {
        protected String name;
        protected Date dateOfBirth;

        public T setName(String name) {
            this.name = name;
            return self();
        }

        public T setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return self();
        }

        T self() { return (T) this; }

        public Person build() { return new Person(this); }
    }
}
