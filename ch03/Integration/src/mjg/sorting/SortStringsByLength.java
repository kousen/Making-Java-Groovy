package mjg.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.List;

public class SortStringsByLength {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		strings.add("this");
		strings.add("is");
		strings.add("a");
		strings.add("list");
		strings.add("of");
		strings.add("strings");
		Collections.sort(strings, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		System.out.println(strings);
	}
}
