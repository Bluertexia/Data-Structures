package csi213.projects.computers;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * {@code UnitTests} tests the implementations in the {@code csi213.projects.computers} package.
 * 
 * @author Jeong-Hyon Hwang (jhh@cs.albany.edu)
 * 
 */
public class UnitTests {

	/**
	 * A {@code Laptop} for testing the implementation of the {@code Laptop} class.
	 */
	static Laptop l1 = new Laptop("l1", 1000.0, 13.1);

	/**
	 * A {@code Laptop} for testing the implementation of the {@code Laptop} class.
	 */
	static Laptop l2 = new Laptop("l2", 1500.0, 15.0);

	/**
	 * Tests the Problems 1a and 1b implementations.
	 * 
	 * @throws Exception
	 *             if an error occurs
	 */
	@Test
	public void test1ab() throws Exception {
		assertEquals("serial number: s1, price: 500.0", "" + new Computer("s1", 500.0));
		assertEquals("serial number: s2, price: 500.0", "" + new Computer("s2", 500.0));
		assertEquals("serial number: s3, price: 600.0", "" + new Computer("s3", 600.0));
	}

	/**
	 * Tests the Problem 1c implementation.
	 * 
	 * @throws Exception
	 *             if an error occurs
	 */
	@Test
	public void test1c() throws Exception {
		assertEquals("s1", new Computer("s1", 500.0).getSerialNumber());
		assertEquals("s2", new Computer("s2", 500.0).getSerialNumber());
		assertEquals("s3", new Computer("s3", 500.0).getSerialNumber());
	}

	/**
	 * Tests the Problem 1d implementation.
	 * 
	 * @throws Exception
	 *             if an error occurs
	 */
	@Test
	public void test1d() throws Exception {
		Computer c = new Computer("s1", 500.0);
		c.setPrice(600.0);
		assertEquals("serial number: s1, price: 600.0", "" + c);
		c.setPrice(700.0);
		assertEquals("serial number: s1, price: 700.0", "" + c);
		c.setPrice(800.0);
		assertEquals("serial number: s1, price: 800.0", "" + c);
	}

	/**
	 * Tests the Problem 1e implementation.
	 * 
	 * @throws Exception
	 *             if an error occurs
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void test1e() throws Exception {
		Computer c = new Computer("s1", 500);
		assertTrue(c.equals(new Computer("s1", 500)));
		assertTrue(c.equals(new Computer(new String("s1"), 500)));
		assertFalse(c.equals(new Computer("s2", 500)));
		assertFalse(c.equals("s1"));
	}

	/**
	 * Tests the Problem 1f implementation.
	 * 
	 * @throws Exception
	 *             if an error occurs
	 */
	@Test
	public void test1f() throws Exception {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.dat"));
		out.writeObject(new Computer("s1", 500));
		out.close();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.dat"));
		assertTrue(new Computer("s1", 500).equals(in.readObject()));
		in.close();
	}

	/**
	 * Tests the Problems 2a and 2b implementations.
	 * 
	 * @throws Exception
	 *             if an error occurs
	 */
	@Test
	public void test2ab() throws Exception {
		assertEquals("serial number: l1, price: 1000.0, screen size: 13.1", "" + l1);
		assertEquals("serial number: l2, price: 1500.0, screen size: 15.0", "" + l2);
	}

	/**
	 * Tests the Problem 2c implementation.
	 * 
	 * @throws Exception
	 *             if an error occurs
	 */
	@Test
	public void test2c() throws Exception {
		assertEquals(2, Laptop.count());
		new Laptop("l3", 1300.0, 14.0);
		assertEquals(3, Laptop.count());
	}

}
