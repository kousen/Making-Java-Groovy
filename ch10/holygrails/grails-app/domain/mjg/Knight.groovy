package mjg

class Knight {
    String title = 'Sir'
    String name
    Quest quest
    Castle castle
    
    String toString() { "$title $name" }
    
    // static hasMany = [challenges:Challenge]

    static constraints = {
        title inList: ['Sir','King','Lord','Squire']
        name blank: false
        quest nullable: true
        castle nullable: true
    }
}
