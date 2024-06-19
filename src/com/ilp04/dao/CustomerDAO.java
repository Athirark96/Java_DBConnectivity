package com.ilp04.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp04.entity.Customer;

public class CustomerDAO {

	// get connection

	public Connection getConnection() {
		String connectionURL = "jdbc:mysql://localhost:3306/bankdb";
		String userName = "root";
		String password = "global@123";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionURL, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}

	// close the connection
	public Connection closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	// get all customer details

	public ArrayList<Customer> getAllCustomers(Connection connection) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Statement statement;
		ResultSet resultSet;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from customer");
			while (resultSet.next()) {
				int customerCode = resultSet.getInt(1);
				String customerFirstName = resultSet.getString(2);
				String customerLastName = resultSet.getString(3);
				String address = resultSet.getString(4);
				long phNumber = resultSet.getLong(6);
				long adhaarNumber = resultSet.getLong(7);
				Customer customer = new Customer(customerCode, customerFirstName, customerLastName, address, phNumber,
						adhaarNumber);
				customerList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	// Insert Customer
	public int insertIntoCustomer(Customer customer, Connection connection) {
		Statement statement = null;
		int rowsAffected = 0;
		try {
			statement = connection.createStatement();

			String insertQuery = "INSERT INTO customer (customer_code, customer_firstname, customer_lastname, address, phone_number, adhaar_number) "
					+ "VALUES (" + customer.getCustomerCode() + ", '" + customer.getCustomerFirstname() + "', '"
					+ customer.getCustomerLastname() + "', '" + customer.getAddress() + "', " + customer.getPhNumber()
					+ ", " + customer.getAdhaarNo() + ")";
			rowsAffected = statement.executeUpdate(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowsAffected;
	}

	
	// Update

	public int updateIntoCustomer(Customer customer, Connection connection) {
		int rowsAffected = 0;
		connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			String updateQuery = "update customer set customer_firstname = ?, customer_lastname = ?, address = ?, phone_number = ?, adhaar_number = ? where customer_code = ?";
			System.out.println(customer.getCustomerFirstname());
			statement = connection.prepareStatement(updateQuery);
			statement.setString(1, customer.getCustomerFirstname());
			statement.setString(2, customer.getCustomerLastname());
			statement.setString(3, customer.getAddress());
			statement.setLong(4, customer.getPhNumber());
			statement.setLong(5, customer.getAdhaarNo());
			statement.setInt(6, customer.getCustomerCode());// Assuming customer_code is an integer
			rowsAffected = statement.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowsAffected;
	}

}
