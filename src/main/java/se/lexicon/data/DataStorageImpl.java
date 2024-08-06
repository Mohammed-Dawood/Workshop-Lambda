package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.util.PersonGenerator;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class DataStorageImpl implements DataStorage {

    private static final DataStorage INSTANCE;

    static {
        INSTANCE = new DataStorageImpl();
    }

    private final List<Person> personList;

    private DataStorageImpl() {
        personList = PersonGenerator.getInstance().generate(1000);
    }

    static DataStorage getInstance() {
        return INSTANCE;
    }


    @Override
    public List<Person> findMany(Predicate<Person> filter) {
        List<Person> result = new ArrayList<>();
        for (Person person : personList) {
            if (filter.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public Person findOne(Predicate<Person> filter) {
        for (Person person : personList) {
            if (filter.test(person)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public String findOneAndMapToString(Predicate<Person> filter, Function<Person, String> personToString) {
        Person person = findOne(filter);
        return person != null ? personToString.apply(person) : null;
    }

    @Override
    public List<String> findManyAndMapEachToString(Predicate<Person> filter, Function<Person, String> personToString) {
        List<Person> filteredPersons = findMany(filter);
        List<String> mappedStrings = new ArrayList<>();
        for (Person person : filteredPersons) {
            mappedStrings.add(personToString.apply(person));
        }
        return mappedStrings;
    }

    @Override
    public void findAndDo(Predicate<Person> filter, Consumer<Person> consumer) {
        List<Person> filteredPersons = findMany(filter);
        for (Person person : filteredPersons) {
            consumer.accept(person);
        }
    }

    @Override
    public List<Person> findAndSort(Comparator<Person> comparator) {
        List<Person> sortedPersons = new ArrayList<>(personList);
        sortedPersons.sort(comparator);
        return sortedPersons;
    }

    @Override
    public List<Person> findAndSort(Predicate<Person> filter, Comparator<Person> comparator) {
        List<Person> filteredPersons = findMany(filter);
        filteredPersons.sort(comparator);
        return filteredPersons;
    }

}
