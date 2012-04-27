package de.jevopi.mitra2;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;


public class MitraUtilsTest {

	@Test
	public void testConvertFQNToPathName() {
		assertEquals("my"+File.separator+"module"+File.separator+"name.mitra", MitraUtils.convertFQNToPathName("my:module:name"));
	}
	
	@Test
	public void testGetFQModuleName() {
		assertEquals("my:module", MitraUtils.getFQModuleName("my:module:name"));
	}
	
	
	
	
}
