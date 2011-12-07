package sorting;

import spock.lang.Specification;

class StringSorterTest extends Specification {
    StringSorter sorter
    def strings
    
    def setup() {
        sorter = new StringSorter()
        strings = ['this','is','a','list','of','strings']
    }
    
    def "lexicographical sort returns alphabetical"() {
        when:
        sorter.sortLexicographically strings
        
        then:
        strings == ['a','is','list','of','strings','this']
    }
    
    def "reverse sort by length should be decreasing size"() {
        when:
        sorter.sortByDecreasingLength strings
        
        then:
        strings*.size() == [7, 4, 4, 2, 2, 1]
    }
}
