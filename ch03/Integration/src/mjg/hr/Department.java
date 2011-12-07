package mjg.hr;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Department {
    private int id;
    private String name;
    private Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public void hire(Employee e) {
        empMap.put(e.getId(), e);
    }
    
    public void layOff(Employee e) {
        empMap.remove(e.getId());
    }
    
    public Collection<Employee> getEmployees() {
        return empMap.values();
    }
    
    public Department plus(Employee e) {
        hire(e);
        return this;
    }
    
    public Department minus(Employee e) {
        layOff(e);
        return this;
    }
    
    public Department leftShift(Employee e) {
        hire(e);
        return this;
    }
}
