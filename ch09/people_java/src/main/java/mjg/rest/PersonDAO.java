package mjg.rest;

import java.util.List;

public interface PersonDAO {
    List<Person> findAll();
    Person findById(long id);
    List<Person> findByLastName(String name);
    Person create(Person p);
    Person update(Person p);
    boolean delete(long id);
}
