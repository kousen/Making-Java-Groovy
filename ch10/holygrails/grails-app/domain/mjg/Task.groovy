package mjg

class Task {
    String name
    int priority = 3
    Date startDate = new Date()
    Date endDate = new Date()
    boolean completed
    
    String toString() { name }
    
    static belongsTo = [quest:Quest]
    
    static constraints = {
        name blank:false
        priority range:1..5
        startDate()
        endDate validator: { value, task ->
            value >= task.startDate
        }
        completed()
    }
}
