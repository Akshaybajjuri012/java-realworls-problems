package assignment;

public class Problem3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ts = 90;
        int tb = 45;
        int gradeAStud = ts / 2; // 50% of total students
        int gradeAboys = 20;
        int gradeAgirls = gradeAStud - gradeAboys;
        System.out.println("Total number of girls getting grade 'A':" + gradeAgirls);

	}

}


/*
Total number of girls getting grade 'A':25
*/