package br.eti.clairton.security;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LockInMemoryTest {
	final Lock lock = new LockInMemory();

	@Test
	public void testIsValid() {
		assertTrue(lock.isValid("admin", "123456"));
		assertFalse(lock.isValid("admin", "123"));
	}
}
