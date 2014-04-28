package mjg

import spock.lang.Specification

class ArrayListSpec extends Specification {
    ArrayList<Number> nums = [3, 1, 4, 1, 5, 9, 2, 6, 5]
    
    def 'size method returns number of elements'() {
        expect:
        nums.size() == 9
    }
}
