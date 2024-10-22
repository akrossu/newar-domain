package edu.gmu.cs321;

public class Person {
    private String name;
    private String dateOfBirth;

    public Person(Builder builder) {
        this.name = builder.name;
        this.dateOfBirth = builder.dateOfBirth;
    }

    public String getName() { return name; }
    public String getDateOfBirth() { return dateOfBirth; }

    public static class Builder<T extends Builder> {
        protected String name;
        protected String dateOfBirth;

        public T setName(String name) {
            this.name = name;
            return self();
        }

        public T setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return self();
        }

        T self() { return (T) this; }

        public Person build() { return new Person(this); }
    }
}
