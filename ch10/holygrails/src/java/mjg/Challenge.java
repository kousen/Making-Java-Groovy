package mjg;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Challenge {
    @Id @GeneratedValue
    private Long id;
    
//    private Knight knight;
//    private Task task;
    private Date startDate;
    private Date endDate;
    
//    public Knight getKnight() {
//        return knight;
//    }
//    public void setKnight(Knight knight) {
//        this.knight = knight;
//    }
//    public Task getTask() {
//        return task;
//    }
//    public void setTask(Task task) {
//        this.task = task;
//    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Long getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Challenge [id=" + id
                + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
//        result = prime * result + ((knight == null) ? 0 : knight.hashCode());
//        result = prime * result + ((task == null) ? 0 : task.hashCode());
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
        Challenge other = (Challenge) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
//        if (knight == null) {
//            if (other.knight != null)
//                return false;
//        } else if (!knight.equals(other.knight))
//            return false;
//        if (task == null) {
//            if (other.task != null)
//                return false;
//        } else if (!task.equals(other.task))
//            return false;
        return true;
    }
    
    
}
