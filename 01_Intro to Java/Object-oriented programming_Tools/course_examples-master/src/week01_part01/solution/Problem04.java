package week01_part01.solution;

public class Problem04 
{
	public static void main(String[] args) 	
	{
		//
		// Reviewing 2D Arrays
		String [] names = {"Alice", "Bob", "Cindy"};
		int [] gradesStudent01 = {100, 90, 95, 90};
		int [] gradesStudent02 = {100, 95, 80, 95};
		int [] gradesStudent03 = {85, 90, 80, 100};

		int numStudents = names.length;
		int numGrades = gradesStudent01.length;
		int [][] allGrades;	// creating the reference
		// starts by pointing to null

		
		// option 1 --------------------
		allGrades = new int [numStudents][numGrades]; // ALLOCATE SPACE

		// TO COMPLETE: SET allGrades[0] TO GRADES OF Student01, etc.

		for (int gradePos = 0; gradePos < gradesStudent01.length; gradePos++)
		{
			allGrades[0][gradePos]  = gradesStudent01[gradePos];
		}
		
		for (int gradePos = 0; gradePos < gradesStudent02.length; gradePos++)
		{
			allGrades[1][gradePos]  = gradesStudent02[gradePos];
		}
		
		for (int gradePos = 0; gradePos < gradesStudent03.length; gradePos++)
		{
			allGrades[2][gradePos]  = gradesStudent03[gradePos];
		}

		
		// option 2 -----------------------
		allGrades = new int[3][];
		allGrades[0] = gradesStudent01;
		allGrades[1] = gradesStudent02;
		allGrades[2] = gradesStudent03;	
	}
}
