package com.ilp04.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;
import com.ilp04.service.CustomerServiceImpl;

public class CustomerUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch;
		do {
			System.out.println("1.Display all Customer 2.Insert Customer 3.Update Customer");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				getAllCustomers();
				break;
			case 2:

				InsertCustomer();
				break;

			case 3:
				updateCustomer();
				break;

			}
			System.out.println("Want to continue(y/n) : ");
			ch = scanner.next().charAt(0);

		} while (ch == 'y');

	}

	private static void updateCustomer() {

		// TODO Auto-generated method stub
		int customerCode;
		String first_Name, last_Name;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the customer code to update: ");
		customerCode = scanner.nextInt();
		System.out.println("Enter the first name : ");
		scanner.nextLine();
		first_Name = scanner.nextLine();
		System.out.println("Enter the last name : ");
		last_Name = scanner.nextLine();
		System.out.println("Enter the Address: ");
		String address = scanner.nextLine();
		System.out.println("Enter the Phone Number : ");
		long phone_Number = scanner.nextLong();
		System.out.println("Enter the Adhaar Number : ");
		long adhaar_Number = scanner.nextLong();
		Customer customer = new Customer(customerCode, first_Name, last_Name, address, phone_Number, adhaar_Number);
		CustomerService customerservice = new CustomerServiceImpl();
		customerservice.updateCustomer(customer);
		
	}

	private static void InsertCustomer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the first name : ");
		String first_Name = scanner.nextLine();
		System.out.println("Enter the last name : ");
		String last_Name = scanner.nextLine();
		System.out.println("Enter the Address: ");
		String address = scanner.nextLine();
		System.out.println("Enter the Phone Number : ");
		long phone_Number = scanner.nextLong();
		System.out.println("Enter the Adhaar Number : ");
		long adhaar_Number = scanner.nextLong();

		Customer customer = new Customer(first_Name, last_Name, address, phone_Number, adhaar_Number);
		CustomerService customerservice = new CustomerServiceImpl();
		customerservice.insertIntoCustomer(customer);
		

	}

	private static void getAllCustomers() {
		// TODO Auto-generated method stub

		CustomerService customerservice = new CustomerServiceImpl();
		ArrayList<Customer> customerList = customerservice.getAllCustomers();
		for (Customer customer : customerList) {
			System.out.println("Customer code : " + customer.getCustomerCode());
			System.out.println("Customer Name : " + customer.getCustomerFirstname());
			System.out.println(customer.getCustomerLastname());
			System.out.println(customer.getAdhaarNo());
			System.out.println(customer.getAddress());

		}

	}

}
