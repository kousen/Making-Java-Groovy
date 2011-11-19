package mjg.ast.delegate;

public interface Developer {
	String writeCode(String specification);
	boolean runTests();
	int fixBugs();
	String whereAreYou();
}
