import java.io.*;

public class SudokuBoard
{	
	boolean explain;
	public static int size = 9;
    	String[][] board = new String[size][size];
	String stringWithAllDigits = "123456789";

	public SudokuBoard(boolean arg)
	public void initializeBoard()
	public String extractDigitAtPos(int pos, String aStrng)

	// Boolean methods
	// ---------------
	public boolean squareContainsASingleDigit(int r,int c)
	public boolean moreThanOneDigitInString(String strng)	
	public boolean	digitAppearsInString(String digt, String strng)
	public boolean digitAppearsOnlyOnceInString(String dgt, String strng)

	// Accessors
	// ---------
	public String getContentOfSquare(int r, int c)
	public String[] getColumn(int c)
	public String[] getRow(int r)
	public String[] get3x3region(int row, int col)	// extracts 3x3 region which

	// Mutators
	// --------
	public void setContentOfSquare(int r, int c, String val)
	public void setRow(int r, String[] arr)		// copies an array to row r of board
	public void setColumn(int c, String[] arr)	//copies an array to column c of board
	public void set3x3region(int row, int col, String[] arr) // copies a string array to board
	// ------------------------------------------------------------------------------------

	// Removes a digit 
	// ---------------
	// Removes a digit from a string 
	public String removeDigitFromStringOfLength2orMore(String dgt, String strng)

	// Removes a digit dgt from each element of a string array
	public String[] removeDigitFromEachElementOfStringArray(String dgt, String[] arr)
	public void removeDigitFromAllStringsOfLength2orMoreInRow(int r, int c)
	public void removeDigitFromAllStringsOfLength2orMoreInColumn(int r, int c)
	public void removeDigitFromAllStringsOfLength2orMoreIn3x3region(int row, int col)
	// ---------------------------------------------------

	public String joinAllStringsInArray(String[] arr)
	public String joinAllStringsInRowR(int r, int c)
	public String joinAllStringsInColC(int r, int c)
	public String joinAllStringsIn3x3region(int r, int c)
	public boolean onlyNumberInRowColOr3x3region(String numbr, int r, int c)
	public void identifyHiddenSinglesInSquare(int r, int c)
	public String constructLineNo(int lineNo, String strng)
	public void displayBoard()
	public void displayFinalBoard()