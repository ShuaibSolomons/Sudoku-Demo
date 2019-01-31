import java.io.*;

public class TestSudoku

{
	SudokuBoard brd;

	boolean explain = true; // describes each move if set to true

	public boolean moreStringsOfLength2orMorePresent()
	{	
		int max = 0;
		for (int r=0; r<9; r++)
		{	for (int c=0; c<9; c++)
			{	if (brd.getContentOfSquare(r, c).length() > max)
				{	max = brd.getContentOfSquare(r, c).length();
				}
			}
		}
		return (max > 1);
	}

	public void run(boolean value)
	{	explain = value;
		brd = new SudokuBoard(explain);
		brd.initializeBoard();
		brd.displayBoard();
		int max = 0;

		int k=0;
		int noOfMoves = 0;

		do{
			for (int r=0; r<9; r++)
			{	for (int c=0; c<9; c++)
				{	
					if (brd.squareContainsASingleDigit(r,c))
					{	brd.removeDigitFromAllStringsOfLength2orMoreInRow(r, c);
						if (explain)
						{	System.out.println("Below: removed "+brd.getContentOfSquare(r, c)+
							" from all squares in row "+r+" except from square ["+r+"]["+c+"]");
							brd.displayBoard();
						}
						brd.removeDigitFromAllStringsOfLength2orMoreInColumn(r, c);
						if (explain)
						{	System.out.println("Below: removed "+brd.getContentOfSquare(r, c)+
							" from all squares in column "+c+" except from square ["+r+"]["+c+"]");
							brd.displayBoard();
						}
						brd.removeDigitFromAllStringsOfLength2orMoreIn3x3region(r, c);
						if (explain)
						{	System.out.println("Below: removed "+brd.getContentOfSquare(r, c)+
							" from all squares in 3x3 region except from square ["+r+"]["+c+"]");
							brd.displayBoard();
						}
					}
				}
			}

			for (int r=0; r<9; r++)
			{	for (int c=0; c<9; c++)
				{	if (brd.moreThanOneDigitInString(brd.getContentOfSquare(r, c)))
					{	
						brd.identifyHiddenSinglesInSquare(r,c);
					}
				}
			}

			if (explain)
				brd.displayBoard();
	
			k++;

		} while ((moreStringsOfLength2orMorePresent()) || ( k < 10));

		brd.displayFinalBoard();
	}

    	public static void main(String args[]) {
	TestSudoku obj = new TestSudoku();
	boolean explainEachMove = true;//false;	// to describe each move set to true
	obj.run(explainEachMove);

    	} // end method main
}

