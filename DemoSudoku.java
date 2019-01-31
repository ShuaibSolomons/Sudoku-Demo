import java.io.*;                          

// 2D Arrays and string manipulation
// Below are some methods that can be used to implement 
// the Sudoku elimination method
// ---------------------------------------------------

public class DemoSudoku
{
	public static int size = 9;
    	String[][] board = new String[size][size];	// declares a 9 x 9 string array
	String stringWithAllDigits = "123456789";	// stores all 9 digits as a string

	public void initializeBoard()
	{	for (int r=0; r<size; r++)
		{	for (int c=0; c<size; c++)
			{	board[r][c] = stringWithAllDigits;
			}
		}
		board[0][1] = "6"; board[0][3] = "1"; board[0][5] = "4"; board[0][7] = "5"; board[1][2] = "8"; 
		board[1][3] = "3"; board[1][5] = "5"; board[1][6] = "6"; board[2][0] = "2"; board[2][8] = "1"; board[0][0] = "9";
		board[3][0] = "8"; board[3][3] = "4"; board[3][5] = "7"; board[3][8] = "6"; board[4][2] = "6"; 
		board[4][6] = "3"; board[5][0] = "7"; board[5][3] = "9"; board[5][5] = "1"; board[5][8] = "4";
 		board[6][0] = "5"; board[6][8] = "2"; board[7][2] = "7"; board[7][3] = "2"; board[7][5] = "6"; 
		board[7][6] = "9"; board[8][1] = "4"; board[8][3] = "5"; board[8][5] = "8"; board[8][7] = "7";
	}

	// Accessors
	// ---------
	public String[] getRow(int r)	        // retrieves row r from 2D-array
	{	String[] arr = new String[size];
		for (int col = 0;  col < size; col++)
			arr[col] = board[r][col];
		return arr;
	} 

	public String[] getColumn(int c)	// retrieves column c from 2D-array
	{	String[] arr = new String[size];
		for (int row = 0;  row < size; row++)
			arr[row] = board[row][c];
		return arr;
	} 

	public String[] get3by3Region(int r, int c, String dgtStrng)	// retrieves 3x3 region which contains arr[r][c]
	{	String[] arr = new String[size];
		int topRow = 3 * (r / 3);		// determines the top row of the 3x3 region
		int leftCol = 3 * ( c / 3);		// determines the left most column of the 3x3 region
		for (int row = topRow;  row < topRow+3; row++)
		{	for (int col = leftCol;  col < leftCol+3; col++)
				{	int count=0;
					//removeDigitFromStringOfLength2orMore(dgtStrng, board[row][col]);
					arr[col] = board[row][col];
					if(board[row][col].length() > 1)
						{
						board[row][col] = board[row][col].replace(dgtStrng,"");
						}
				}
		}
		return arr;
	} 

	// Mutators
	// --------

	public void setRow(int r, String[] arr)	        // stores string array arr in row r of 2D-array board
	{	for (int col = 0;  col < arr.length; col++)
			board[r][col] = arr[col];		
	} 

	public void setColumn(int c, String[] arr)	// stores string array arr in column c of 2D-array board
	{	for (int row = 0;  row < arr.length; row++)
			board[row][c] = arr[row];		
	} 

	// ------------------------------------------------

	public void removeDigitFromRowR(String dgt, int r)	// removes the string dgt (of length 1) from 
	{	String[] tmpArr = new String[board[0].length];  // all string entries (of length 2 and longer) in row r
		tmpArr = getRow(r);
		for (int c=0; c<tmpArr.length; c++)
		{	String aStrng = tmpArr[c];  // copy string at index c from string array tmpArr
			tmpArr[c] = removeDigitFromStringOfLength2orMore(dgt, aStrng);
		} 
		setRow(r, tmpArr);                  // stores array tmpArr in row r of 2D-array board
	}

	public void removeDigitFromColumnC(String dgt, int c)	// removes the string dgt (of length 1) from 
	{	String[] tmpArr = new String[board.length];     // all string entries (of length 2 and longer) in column c
		tmpArr = getColumn(c);
		for (int r=0; r<tmpArr.length; r++)
		{	String aStrng = tmpArr[r];		// copy the string 	 
			tmpArr[r] = removeDigitFromStringOfLength2orMore(dgt, aStrng);
		} 
		setColumn(c, tmpArr);
	}

	public String removeDigitFromStringOfLength2orMore(String dgtStrng, String strng) // removes the string dgtStrng from String strng
	{	String aStrng = strng;
		int indx = aStrng.indexOf(dgtStrng);
		if ((indx >= 0) && (aStrng.length() >= 2))
			aStrng = aStrng.substring(0,indx) + aStrng.substring(indx+1); // removes dgtStrng from aStrng			
		return aStrng;
	}

	public String constructLineNo(int lineNo, String strng)	// places the digits in a square in its correct position 
	{ 	String template = "123456789";			// e.g. "23" is stored as " 23" while "46" is stored as "4 6" and "78 as "78 "
		String line = "";
		String aBlank = " ";
		int strt = 3 * lineNo - 3;			// strt indicates the starting position of the 3 digit substring to be extracted from "123456789"
		for (int i = strt; i< strt+3; i++)		// for the first line "123" is used while "789" is used for the third line
		{	String digt = template.substring(i,i+1);
			if (strng.indexOf(digt) != -1)		// display digt if it appears in string strng else do not display
				line = line + " "+digt;		// since digt is present in cell add it to the line to be displayed
			else
				line = line + " "+aBlank;	// else add a space 
		}
		return line;
	}

	public void displayBoard()				// displays contents of each cell of the board across three lines
	{											// as  123
		System.out.println("\t\t\t\t-------------------- TOP ------------------");	//     456
		for (int r=0; r<size; r++)							//     789
		{	
			String line1 = "\t\t| ";
			String line2 = "\t\t| ";
			String line3 = "\t\t| ";

			for (int c=0; c<size; c++)
			{	 line1 = line1 + constructLineNo(1, board[r][c])  + " |";
				 line2 = line2 + constructLineNo(2, board[r][c]) + " |";
				 line3 = line3 + constructLineNo(3, board[r][c])  + " |";
				 if (( c == 2) || ( c == 5))	// signals end of last column on 3x3 region
				 {	line1 = line1 + "| ";			
				 	line2 = line2 + "| ";	
				 	line3 = line3 + "| ";
				 }
			}
			System.out.println(line1);
			System.out.println(line2);
			System.out.println(line3);
			if (( r == 2) || ( r == 5))	 //  indicates the last row of a 3x3 region
				System.out.println("==========================================================================================================");
			else
				System.out.println("----------------------------------------------------------------------------------------------------------");
		}
		System.out.println("\t\t\t\t----------------- BOTTOM  ----------------\n");
		System.out.println();
	}

	public void run()
	{
		initializeBoard();
		String dgtStrng = board[0][1];
		System.out.println("Before removing "+board[0][1]+" (which appears in square 1,2) from all other squares in ROW "+1+" of the board");
		displayBoard();
		removeDigitFromRowR(dgtStrng, 0);
		System.out.println("After removing "+board[0][1]+" (which appears in square 1,2) from all other squares in ROW "+1+" of the board");
		displayBoard();
		removeDigitFromColumnC(dgtStrng, 1);
		System.out.println("After removing "+board[0][1]+" (which appears in square 1,2) from all other squares in COLUMN "+2+" of the board");
		displayBoard();
		
	}
	
	public boolean getLength(String str)
	{ String aString = str;
		boolean examp = true;
		
		if (aString.length() ==1)
		{
			examp = false;
			return examp;
		}
		return examp;
	}

	public void finale()
	{
		initializeBoard();
		for(int m = 0; m<10; m++)
		{
		for(int i = 0; i<9; i++)
		{
			for(int r=0; r<9; r++)
			{
				
				if(getLength(board[i][r]) == false)
					{
					
					String dgtStrng = board[i][r];
					//System.out.println(dgtStrng);
					//System.out.println("Before removing "+board[0][1]+" (which appears in square 1,2) from all other squares in ROW "+1+" of the board");
					//displayBoard();
					removeDigitFromRowR(dgtStrng, i);
					//System.out.println("After removing "+board[0][1]+" (which appears in square 1,2) from all other squares in ROW "+1+" of the board");
					//displayBoard();
					removeDigitFromColumnC(dgtStrng, r);
					//System.out.println("After removing "+board[0][1]+" (which appears in square 1,2) from all other squares in COLUMN "+2+" of the board");
					String[] val = get3by3Region(i, r, dgtStrng);
					//val.replace((String.valueOf(dgtStrng)),"");
					//displayBoard();
					for(int a = 0; a<9; a++)
					{
						if(dgtStrng == val[a])
						{
							val[a] = "";
						}
						String val2 = "";
						val2 += val[a];
						//System.out.println(val2);
						//constructLineNo(i, val2);
					
					}
					}
			}
		}
		}
		System.out.println("After removing "+board[0][1]+" (which appears in square 1,2) from all other squares in COLUMN "+2+" of the board");
		displayBoard();
		
	}

       	public static void main(String args[])
      	{
		DemoSudoku tstrObjct = new DemoSudoku();	
		//tstrObjct.run();
		tstrObjct.finale();  
		tstrObjct.finale();
      	}
}