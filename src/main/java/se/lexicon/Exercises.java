package se.lexicon;

import java.time.LocalDate;

import se.lexicon.model.Gender;
import se.lexicon.model.Person;
import se.lexicon.data.DataStorage;

import java.util.List;
import java.time.Period;
import java.util.Comparator;


public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;


    /*
        TODO: 1. Find everyone that has firstName: “Erik” using findMany().
     */
    public static void exercise1(String message) {
        System.out.println(message);
        // Lambda expression to find persons with firstName "Erik"
        List<Person> persons = storage.findMany(person -> "Erik".equals(person.getFirstName()));
        // Print each found person
        persons.forEach(System.out::println);
        System.out.println("----------------------");
    }


    /*
        TODO: 2. Find all females in the collection using findMany().
     */
    public static void exercise2(String message) {
        System.out.println(message);
        // Lambda expression to find persons with gender FEMALE
        List<Person> females = storage.findMany(person -> Gender.FEMALE.equals(person.getGender()));
        // Print each found person
        females.forEach(System.out::println);
        System.out.println("----------------------");
    }


    /*
       TODO: 3. Find all who are born after (and including) 2000-01-01 using findMany().
     */
    public static void exercise3(String message) {
        System.out.println(message);
        LocalDate thresholdDate = LocalDate.of(2000, 1, 1);

        // Lambda expression to find persons born on or after 2000-01-01
        List<Person> personsBornAfter2000 = storage.findMany(person -> !person.getBirthDate().isBefore(thresholdDate));

        // Print each found person
        personsBornAfter2000.forEach(System.out::println);
        System.out.println("----------------------");
    }


    /*
       TODO: 4. Find the Person that has an id of 123 using findOne().
     */
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
       TODO: 5. Find the Person that has an id of 456 and convert to String with following content:
        “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
     */
    public static void exercise5(String message) {
        System.out.println(message);
        int targetId = 456;

        // Lambda expression to find the person with id 456
        String personString = storage.findOneAndMapToString(
                person -> person.getId() == targetId,
                // Lambda expression to convert the person to the desired string format
                person -> "Name: " + person.getFirstName() + " " + person.getLastName() + " born " + person.getBirthDate()
        );

        // Print the resulting string
        System.out.println(personString);
        System.out.println("----------------------");
    }


    /*
        TODO:  6. Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
     */
    public static void exercise6(String message) {
        System.out.println(message);

        // Lambda expression to filter males whose first name starts with "E"
        List<String> maleNamesStartingWithE = storage.findManyAndMapEachToString(
                person -> Gender.MALE.equals(person.getGender()) && person.getFirstName().startsWith("E"),

                // Lambda expression to convert each Person to a String
                person -> person.getFirstName() + " " + person.getLastName()
        );

        // Print each resulting string
        maleNamesStartingWithE.forEach(System.out::println);

        System.out.println("----------------------");
    }


    /*
        TODO:  7.	Find all people who are below age of 10 and convert them to a String like this:
            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
     */
    public static void exercise7(String message) {
        System.out.println(message);

        // Lambda expression to filter persons below the age of 10
        List<String> personsBelowAge10 = storage.findManyAndMapEachToString(
                person -> Period.between(person.getBirthDate(), LocalDate.now()).getYears() < 10,

                // Lambda expression to convert each Person to a formatted String
                person -> person.getFirstName() + " " + person.getLastName() + " " +
                        Period.between(person.getBirthDate(), LocalDate.now()).getYears() + " years"
        );

        // Print each resulting string
        personsBelowAge10.forEach(System.out::println);

        System.out.println("----------------------");
    }


    /*
        TODO:  8.	Using findAndDo() print out all people with firstName “Ulf”.
     */
    public static void exercise8(String message) {
        System.out.println(message);
        //Write your code here
        storage.findAndDo(
                person -> person.getFirstName().equals("Ulf"),
                System.out::println
        );
        System.out.println("----------------------");
    }


    /*
        TODO:  9.	Using findAndDo() print out everyone who have their lastName contain their firstName.
     */
    public static void exercise9(String message) {
        System.out.println(message);
        //Write your code here
        storage.findAndDo(
                person -> person.getLastName().toLowerCase().contains(person.getFirstName().toLowerCase()),
                System.out::println
        );
        System.out.println("----------------------");
    }

    /*
        TODO:  10.	Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */
    public static void exercise10(String message) {
        System.out.println(message);
        //Write your code here
        storage.findAndDo(
                person -> person.getFirstName().equalsIgnoreCase(new StringBuilder(person.getFirstName()).reverse().toString()),
                person -> System.out.println(person.getFirstName() + " " + person.getLastName())
        );
        System.out.println("----------------------");
    }

    /*
        TODO:  11.	Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static void exercise11(String message) {
        System.out.println(message);
        //Write your code here
        storage.findAndSort(
                person -> person.getFirstName().startsWith("A"),
                Comparator.comparing(Person::getBirthDate)
        ).forEach(System.out::println);

        System.out.println("----------------------");
    }

    /*
        TODO:  12.	Using findAndSort() find everyone born before 1950 sorted reversed by latest to earliest.
     */
    public static void exercise12(String message) {
        System.out.println(message);
        //Write your code here
        storage.findAndSort(
                person -> person.getBirthDate().getYear() < 1950,
                Comparator.comparing(Person::getBirthDate).reversed()
        ).forEach(System.out::println);

        System.out.println("----------------------");
    }

    /*
        TODO:  13.	Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static void exercise13(String message) {
        System.out.println(message);
        //With Anonymous inner Class
        Comparator<Person> compareLastName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        };

        //With Lambda
        Comparator<Person> compareFirstName = (Person o1, Person o2) -> o1.getFirstName().compareTo(o2.getFirstName());
        //With Method Reference
        Comparator<Person> compareBirthDate = Comparator.comparing(Person::getBirthDate);
        //Stack
        Comparator<Person> all = compareLastName.thenComparing(compareFirstName).thenComparing(compareBirthDate);
        storage.findAndSort(all).forEach(System.out::println);

        /*
        storage.findAndSort(
                Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName).thenComparing(Person::getBirthDate)
        ).forEach(System.out::println);
        */

        System.out.println("----------------------");
    }
}
