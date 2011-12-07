package tasks

import spock.lang.Specification;

class TaskTests extends Specification {
    JavaTask jtask
    GroovyTask gtask
    
    def setup() {
        jtask = new JavaTask(name:'name',priority:1,
            startDate:new Date(),endDate:new Date() + 1)
        
        gtask = new GroovyTask(name:'name',priority:1,
            startDate:new Date(),endDate:new Date() + 1)
    }
    
    def "groovy and java tasks are equivalent"() {
        expect:
        jtask.name == gtask.name
        jtask.priority == gtask.priority
        Math.abs(jtask.startDate - gtask.startDate) < 1
        Math.abs(jtask.endDate - gtask.endDate) < 1
    }
}
