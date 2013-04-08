package mjg.rest;

import java.util.List;

public interface PersonDAO {
    List<Person> findAll();
    Person findById(long id);
    List<Person> findByLastName(String name);
    Person create(Person c);
    Person update(Person c);
    boolean delete(long id);
    Long getMinId();
    Long getMaxId();
}
