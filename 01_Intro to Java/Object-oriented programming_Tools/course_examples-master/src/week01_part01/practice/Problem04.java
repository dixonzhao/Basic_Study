package week01_part01.practice;

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
		int [][] allGrades;	// reference
		
		// option 1
		allGrades = new int [ numStudents ][ numGrades ]; // ALLOCATE SPACE
		

		// TO COMPLETE: SET allGrades[0] TO GRADES OF student 1, etc.
		for (int gradePos = 0; gradePos < gradesStudent01.length; gradePos++)
		{
			allGrades[0][gradePos]  = gradesStudent01[gradePos];
		}
		
		// TO COMPLETE: DO THE SAME FOR the rest of the students
	}
}




