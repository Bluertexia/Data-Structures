package csi213.projects.computers;

import java.io.Serializable; // Problem 1f

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Each {@code Computer} represents a computer.
 * 
 * @author Jeong-Hyon Hwang (jhh@cs.albany.edu)
 */

/**
 * Luiginna Fernandez ICSI 213 Project 1 
 */

public class Computer implements Serializable{
	
    private static final long serialVersionUID = 1L; // declare serialVersionUID

	/**
	 * The serial number of this {@code Computer}.
	 */
	protected String serialNumber;

	/**
	 * The price of this {@code Computer}.
	 */
	protected double price;

	/**
	 * Constructs a {@code Computer} instance.
	 * 
	 * @param serialNumber
	 *            the serial number of the {@code Computer}
	 * @param price
	 *            the price of the {@code Computer}
	 */
	public Computer(String serialNumber, double price) {
		this.serialNumber = serialNumber;
		this.price = price;	
		//Computer newComputer = new Computer(serialNumber,price);
	}

	/**
	 * Returns the serial number of this {@code Computer}.
	 * 
	 * @return the serial number of this {@code Computer}
	 */
	public String getSerialNumber() {
		return this.serialNumber;
	}

	/**
	 * Sets the price of this {@code Computer}.
	 * 
	 * @param price
	 *            the new price of this {@code Computer}
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Here I added an override toString method so that we can print the
	 * computer's information in the proper formatting.
	 */
	
	@Override
	public String toString() {
		return "serial number: " + serialNumber + ", price: " + price; //“serial number: s1, price: 500.0”
	}
	
	/**
	 * Here I added an override equals method that will check if two computer objects are equal
	 * based on just their serial numbers.
	 */
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false; // null object compared to non-null can't be true! & if 'o' isn't in the same class type it also can't be equal.
	
	    Computer computer = (Computer) o;
		
		return serialNumber.equals(computer.serialNumber);
	}
	
	/**
	 * The main method of the {@code Computer} class.
	 * 
	 * @param args
	 *            the program arguments
	 * @throws Exception
	 *             if an error occurs
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws Exception {
		Computer c = new Computer("s1", 500);
		System.out.println(c);

		System.out.println(c.getSerialNumber());
		
		c.setPrice(600);
		System.out.println(c);

		System.out.println(c.equals(new Computer("s1", 500)));
		System.out.println(c.equals(new Computer(new String("s1"), 500)));
		System.out.println(c.equals(new Computer("s2", 500)));
		System.out.println(c.equals("s1"));

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.dat"));
		out.writeObject(c);
		out.close();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.dat"));
		System.out.println(in.readObject());
		in.close();
	}

}
