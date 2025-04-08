package Utilities;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;


public class Dataprovider {
	
	@DataProvider(name = "Validpythoncode")
	public Object[][] Validpythoncode() throws IOException {
		Excelreaderpython read = new Excelreaderpython();
		String tryherecode = read.getPycode(1);
		String expectedoutput=read.gettryheremessage(1);
		return new Object[][]{
		{tryherecode,expectedoutput}
		};
	}

	@DataProvider(name = "Invalidpythoncode")
	public Object[][] invalidpythoncode() throws IOException {
	    Excelreaderpython read = new Excelreaderpython();
	    int rowIndex = 2;  
	    String tryherecode= read.getPycode(2);;
	    String expectedalertmessage =read.gettryheremessage(2);

	    try {
	        tryherecode = read.getPycode(rowIndex);
	        expectedalertmessage = read.gettryheremessage(rowIndex);
	    } catch (IndexOutOfBoundsException e) {
	        throw new RuntimeException("Invalid index: Ensure row " + rowIndex + " exists in Excel sheet.", e);
	    }

	    return new Object[][]{{tryherecode, expectedalertmessage}};
	}

	
	@DataProvider(name = "PracticeQSearchthearray")
	public Object[][] practiceqsearchthearray() throws IOException {
		Excelreaderpython read = new Excelreaderpython();
		ArrayList<String> practicequescode = read.getArraypracticeques(1);
		String expectedoutput=read.getPQoutput(1);
		
		String codeBlock = String.join("\n", practicequescode); //     // Convert code lines to a single string
		
		return new Object[][]{
			{codeBlock,expectedoutput}
			};
	}
	
	@DataProvider(name = "PracticeQMaxConsones")
	public Object[][] practiceqmaxconsones() throws IOException {
		Excelreaderpython read = new Excelreaderpython();
		ArrayList<String> practicequescode = read.getArraypracticeques(3);
		String expectedoutput=read.getPQoutput(3);
		String codeBlock = String.join("\n", practicequescode);
		return new Object[][]{
			{codeBlock,expectedoutput}
			};
	}
	
	@DataProvider(name = "PracticeQEvennums")
	public Object[][] practiceqevennums() throws IOException {
		Excelreaderpython read = new Excelreaderpython();
		ArrayList<String> practicequescode = read.getArraypracticeques(5);
		String expectedoutput=read.getPQoutput(5);
		String codeBlock = String.join("\n", practicequescode);
		
		return new Object[][]{
			{codeBlock,expectedoutput}
			};
	}

	@DataProvider(name = "PracticeQSQofsortedarray")
	public Object[][] practiceqsqofsortedarray() throws IOException {
		Excelreaderpython read = new Excelreaderpython();
		ArrayList<String> practicequescode = read.getArraypracticeques(7);
		String expectedoutput=read.getPQoutput(7);
        String codeBlock = String.join("\n", practicequescode); 
		
		return new Object[][]{
			{codeBlock,expectedoutput}
			};
		
	}
	
	@DataProvider(name = "Registervalidcredentials")
	public Object[][] Registervalidcredentials() throws IOException {
		Excelreaderpython read = new Excelreaderpython();
		String username = read.getusername(3);
		String password=read.getpassword(3);
		String confirmPassword=read.getconfirmpassword(3);
		return new Object[][]{
		{username,password}
		};
	}
	
	@DataProvider(name = "Registerinvalidusername")
	public Object[][] Registerinvalidusername() throws IOException {
		Excelreaderpython read = new Excelreaderpython();
		String username = read.getusername(2);
		String password=read.getpassword(2);
		return new Object[][]{
		{username,password}
		};
	}
	
	@DataProvider(name = "Registerinvalidpassword")
	public Object[][] Registerinvalidpassword() throws IOException {
		Excelreaderpython read = new Excelreaderpython();
		String username = read.getusername(3);
		String password=read.getpassword(3);
		return new Object[][]{
		{username,password}
		};
	}
	
	@DataProvider(name = "Registerconfirmpassword")
	public Object[][] Registerconfirmpassword() throws IOException {
		Excelreaderpython read = new Excelreaderpython();
		String username = read.getusername(3);
		String password=read.getpassword(3);
		String Confirmpassword=read.getconfirmpassword(3);
		return new Object[][]{
		{username,password,Confirmpassword}
		};
	}
	
	@DataProvider(name = "LoginValidcredentials")
	public Object[][] LoginValidcredentials() throws IOException {
		Excelreaderpython read = new Excelreaderpython();
		String username = read.getusername(7);
		String password=read.getpassword(7);
		return new Object[][]{
		{username,password}
		};
	}
	
	@DataProvider(name = "InvalidUsername")
	public Object[][] InvalidUsername() throws IOException {
		Excelreaderpython read = new Excelreaderpython();
		String username = read.getusername(6);
		String password=read.getpassword(6);
		return new Object[][]{
		{username,password}
		};
	}
	
	@DataProvider(name = "InvalidPassword")
	public Object[][] InvalidPassword() throws IOException {
		Excelreaderpython read = new Excelreaderpython();
		String username = read.getusername(4);
		String password=read.getpassword(4);
		return new Object[][]{
		{username,password}
		};
	}
	@DataProvider(name = "linkDataProvider")
	public Object[][] linkDataProvider() {
	    return new Object[][] {
	        {"Tree Traversals"},
	        {"Traversals-Illustration"},
	        {"Binary Trees"},
	        {"Types of Binary Trees()"},
	        {"Implementation of Python"},
	        {"Binary Tree Traversals"},
	        {"Implementation of Binary Trees"},
	        {"Application of Binary trees"},
	        {"Binary Search Trees"},
	        {"Implementation Of BST"},
	        {"Practice Questions"}
	    };
	}
	@DataProvider(name = "linkListDataProvider")
	public Object[][] linkListDataProvider() {
	   return new Object[][] {
	       {"Indrodution"},
	       {"Creating Linked List"},
	       {"Types Of Linked List"},
	       {"Implement Linked List in Python"},
	       {"Traversal"},
	       {"Insertion"},
	       {"Deletion"},
	     
	   };
}
	}