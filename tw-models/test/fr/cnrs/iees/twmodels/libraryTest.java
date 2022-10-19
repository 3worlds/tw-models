package fr.cnrs.iees.twmodels;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.cnrs.iees.omhtk.utils.NameUtils;

class libraryTest {
	private void show(String s) {
//		System.out.println(s);
	}

	@Test
	void test() {
		for (LibraryTable e : LibraryTable.values()) {
			show(e.displayName());
			String s1 = e.proposedName();
			String s2 = NameUtils.validJavaName(s1);
			assertTrue(s1.equals(s2));
			assertTrue(e.configExists());
			assertTrue(e.dependencyExists());
		}
		
	}

}
