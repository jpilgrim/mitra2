package de.jevopi.utils;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class FileUtilsTest {

	@Test
	public void testToOS() {
		doTestToOS("./Hello/World");
		doTestToOS("."+File.separator+"Hello"+File.separator+"World");
	}

	void doTestToOS(String s) {
		StringBuilder strb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch (ch) {
			case '/':
			case '\\':
				strb.append(File.separator);
				break;
			default:
				strb.append(ch);
			}
		}

		String e = strb.toString();

		assertEquals(e, FileUtils.toOS(s));
	}

}
