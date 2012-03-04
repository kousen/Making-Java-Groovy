package mjg

class Quest {
    String name
    
    String toString() { name }
    
    static hasMany = [knights:Knight, tasks:Task]

    static constraints = {
        name blank:false
    }
}
