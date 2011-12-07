package tasks

class GroovyTask {
    String name
    int priority
    Date startDate
    Date endDate
    
    String toString() { "($name,$priority,$startDate,$endDate)" }
}
