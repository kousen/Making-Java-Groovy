package mjg.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
    private Long id;
    private String first;
    private String last;
    
    public Person() { }
    
    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Person(Long id, String first, String last) {
        this.id = id;
        this.first = first;
        this.last = last;
    }

    
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        return first + " " + last;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((first == null) ? 0 : first.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((last == null) ? 0 : last.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (first == null) {
            if (other.first != null)
                return false;
        } else if (!first.equals(other.first))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (last == null) {
            if (other.last != null)
                return false;
        } else if (!last.equals(other.last))
            return false;
        return true;
    }  
}
