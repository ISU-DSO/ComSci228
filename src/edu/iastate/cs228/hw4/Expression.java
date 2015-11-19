package edu.iastate.cs228.hw4;

import java.util.HashMap;
import java.util.Scanner;

public abstract class Expression 
{
	protected String postfixExpression; 		
	protected HashMap<Character, Integer> varTable; // hash map to store variables in the 

	
	protected Expression()
	{
		// no implementation needed 
		// removable when you are done
	}
	
	
	/**
	 * Initialization with a provided hash map. 
	 * 
	 * @param varTbl
	 */
	protected Expression(String st, HashMap<Character, Integer> varTbl)
	{
		this.varTable = varTable;
	}
	
	/**
	 * Initialization with a default hash map.
	 * 
	 * @param st
	 */
	protected Expression(String st) 
	{
		varTable = new HashMap<Character, Integer>();
	}

	/**
	 * @param varTbl
	 */
	public void setVarTable(HashMap<Character, Integer> varTbl) 
	{
		varTable = varTbl;
	}
	
	/**
	 * Evaluates the infix or postfix expression. 
	 * 
	 * @return value of the expression 
	 * @throws ExpressionFormatException, UnassignedVariableException
	 */
	public abstract int evaluate() throws ExpressionFormatException, UnassignedVariableException;  

	
	
	// --------------------------------------------------------
	// Helper methods for InfixExpression and PostfixExpression 
	// --------------------------------------------------------

	/** 
	 * Check if a string represents an integer.  You may call the static method 
	 * Integer.parseInt(). 
	 * 
	 * @param s
	 * @return
	 */
	protected static boolean isInt(String s) 
	{
		try{
			int temp = Integer.parseInt(s);
		}catch (NumberFormatException e){
			return false;
		}
		return true;
	}

	
	/**
	 * Check if a char represents an operator, i.e., one of '+', '-', '*', '/', '%', '^'. 
	 * 
	 * @param c
	 * @return
	 */
	protected static boolean isOperator(char c) 
	{
		if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^' || c == '(' || c == ')'){
			return true;
		}
		return false; 
	}

	/** 
	 * Check if a char is a variable, i.e., a lower case English letter. 
	 * 
	 * @param c
	 * @return
	 */
	protected static boolean isVariable(char c) 
	{
		if((int) c >= 97 && (int) c <=122){		//'a'= 97, 'z'= 122, all lower-case chars must be between that.
			return true;
		}
		return false;
	}	
	protected static String removeExtraSpaces(String s) {
	     return s.replaceAll("\\s+", " ").trim();
	 }
}
