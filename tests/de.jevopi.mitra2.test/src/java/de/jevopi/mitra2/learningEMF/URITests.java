package de.jevopi.mitra2.learningEMF;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.Test;



public class URITests {

	@Test
	public void testURICreation() {
		
		URI uri;
		uri = URI.createURI("simpleFileName.xmi");
		assertNotNull(uri);
		assertTrue(uri.isFile());
		assertTrue(uri.isRelative());
		
		uri = URI.createURI("/simpleFileName.xmi");
		assertTrue(uri.isFile());
		assertNotNull(uri);
		assertTrue(uri.isRelative());
		
		uri = URI.createURI("file:/simpleFileName.xmi");
		assertNotNull(uri);
		assertFalse(uri.isRelative());
		
		uri = URI.createURI("file://simpleFileName.xmi");
		assertNotNull(uri);
		assertFalse(uri.isRelative());
		
		uri = URI.createURI("archive.jar!content.xmi");
		assertNotNull(uri);
		assertTrue(uri.isFile());
		assertTrue(uri.isRelative());
		assertFalse(uri.isArchive());
		
		
		uri = URI.createURI("jar://archive.jar!/content.xml");
		assertNotNull(uri);
		assertFalse(uri.isFile());
		assertFalse(uri.isRelative());
		assertTrue(uri.isArchive());
		
		uri = URI.createURI("jar://archive.jar!/");
		assertNotNull(uri);
		assertFalse(uri.isFile());
		assertFalse(uri.isRelative());
		assertTrue(uri.isArchive());

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void illegalArchiveURI() {
		URI.createURI("jar://archive.jar!content.xml");
	}
	
	@Test
	public void testComposedURIInArchive() {
		URI base = URI.createURI("jar://archive.jar!/");
		assertNotNull(base);
		assertFalse(base.isFile());
		assertFalse(base.isRelative());
		assertTrue(base.isArchive());
		
		URI uri = URI.createURI("/content.xml");
		assertTrue(uri.isFile());
		assertNotNull(uri);
		assertTrue(uri.isRelative());
		
		URI resolved = uri.resolve(base);
		assertNotNull(resolved);
		assertFalse(resolved.isRelative());
		assertTrue(resolved.isArchive());
		Assert.assertEquals("jar://archive.jar!/content.xml", resolved.toString());
		
		
		
		uri = URI.createURI("content.xml");
		assertTrue(uri.isFile());
		assertNotNull(uri);
		assertTrue(uri.isRelative());
		
		resolved = uri.resolve(base);
		assertNotNull(resolved);
		assertFalse(resolved.isRelative());
		assertTrue(resolved.isArchive());
		Assert.assertEquals("jar://archive.jar!/content.xml", resolved.toString());
	}
	
	
	/**
	 * Lessons learned:
	 * - trailing '/' is required in base to indicate path
	 * - each leading '/' removes one segment from base
	 * 
	 */
	@Test
	public void testComposedFileURI() {
		URI base = URI.createURI("file://some/path/");
		assertNotNull(base);
		assertTrue(base.isFile());
		assertFalse(base.isRelative());
		assertFalse(base.isArchive());
		
		URI uri = URI.createURI("/content.xml");
		assertTrue(uri.isFile());
		assertNotNull(uri);
		assertTrue(uri.isRelative());
		
		URI resolved = uri.resolve(base);
		assertNotNull(resolved);
		assertFalse(resolved.isRelative());
		assertFalse(base.isArchive());
		Assert.assertEquals("file://some/content.xml", resolved.toString());
		
		
		
		uri = URI.createURI("content.xml");
		assertTrue(uri.isFile());
		assertNotNull(uri);
		assertTrue(uri.isRelative());
		
		resolved = uri.resolve(base);
		assertNotNull(resolved);
		assertFalse(resolved.isRelative());
		assertFalse(base.isArchive());
		Assert.assertEquals("file://some/path/content.xml", resolved.toString());
	}
	
	@Test
	public void testComposedFileURIAbsolute() {
		URI base = URI.createURI("file://some/path/");
		assertNotNull(base);
		assertTrue(base.isFile());
		assertFalse(base.isRelative());
		assertFalse(base.isArchive());
		
		URI uri = URI.createURI("file://content.xml");
		assertTrue(uri.isFile());
		assertNotNull(uri);
		assertFalse(uri.isRelative());
		
		URI resolved = uri.resolve(base);
		assertNotNull(resolved);
		assertFalse(resolved.isRelative());
		assertFalse(base.isArchive());
		assertEquals("file://content.xml", resolved.toString());
		
	}
	
	@Test
	public void testAddSlash() {
		URI base = URI.createURI("file://some/path");
		assertNotNull(base);
		assertEquals("file://some/path", base.toString());
		assertFalse(base.isPrefix());
		
				
		URI uri = URI.createURI(base.toString()+"/");
		assertEquals("file://some/path/", uri.toString());
		
		
	}
	
	@Test
	public void testURISegments() {
		URI uri;
		uri = URI.createURI("file://this/is/a/simpleFileName.xmi");
		assertEquals("simpleFileName.xmi", uri.lastSegment());
		
	}
}
