package mjg.ast.delegate;

public class LocalDeveloper implements Developer {

    public String writeCode(String specification) {
        return "lots of code";
    }

    public boolean runTests() {
        return true;
    }

    public int fixBugs() {
        return 100;
    }
    
    public String whereAreYou() {
        return "in my office";
    }

}
