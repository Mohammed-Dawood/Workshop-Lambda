package se.lexicon;

import java.time.LocalDate;

import se.lexicon.model.Gender;
import se.lexicon.model.Person;
import se.lexicon.data.DataStorage;

import java.util.List;

public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;

    public static void exercise1(String message) {
        System.out.println(message);
        // Lambda expression to find persons with firstName "Erik"
        List<Person> persons = storage.findMany(person -> "Erik".equals(person.getFirstName()));
        // Print each found person
        persons.forEach(System.out::println);
        System.out.println("----------------------");
    }

    public static void exercise2(String message) {
        System.out.println(message);
        // Lambda expression to find persons with gender FEMALE
        List<Person> females = storage.findMany(person -> Gender.FEMALE.equals(person.getGender()));
        // Print each found person
        females.forEach(System.out::println);
        System.out.println("----------------------");
    }

    public static void exercise3(String message) {
        System.out.println(message);
        LocalDate thresholdDate = LocalDate.of(2000, 1, 1);

        // Lambda expression to find persons born on or after 2000-01-01
        List<Person> personsBornAfter2000 = storage.findMany(person -> !person.getBirthDate().isBefore(thresholdDate));

        // Print each found person
        personsBornAfter2000.forEach(System.out::println);
        System.out.println("----------------------");
    }

    public static void exercise4(String message) {
        System.out.println(message);
        int targetId = 123;

        // Lambda expression to find the person with id 123
        Person personWithId123 = storage.findOne(person -> person.getId() == targetId);

        // Print the found person or a message if not found
        if (personWithId123 != null) {
            System.out.println(personWithId123);
        } else {
            System.out.println("Person with id 123 not found.");
        }
        System.out.println("----------------------");
    }


    /*
        TODO:  5.	Find the Person that has an id of 456 and convert to String with following content:
            “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
     */
    public static void exercise5(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  6.	Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
     */
    public static void exercise6(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  7.	Find all people who are below age of 10 and convert them to a String like this:
            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
     */
    public static void exercise7(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  8.	Using findAndDo() print out all people with firstName “Ulf”.
     */
    public static void exercise8(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  9.	Using findAndDo() print out everyone who have their lastName contain their firstName.
     */
    public static void exercise9(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  10.	Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */
    public static void exercise10(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  11.	Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static void exercise11(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  12.	Using findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.
     */
    public static void exercise12(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  13.	Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static void exercise13(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }
}
