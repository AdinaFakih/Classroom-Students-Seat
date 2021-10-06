import java.util.ArrayList;

/**
 * Represents a classroom with students
 * Each classroom has a list of students
 * and an array that represents the seats in the classroom
 * @author addyf
 *
 */
public class Classroom {
	//instance VAR
	String buildingName;  //name of building
	String roomName;	  //name of classroom
	
	ArrayList<Student> students;  // List of students in the classroom
	Seat[][] seats;
	
	//constructor
	/**
	 * Creates a classroom
	 * @param buildingName  name of building
	 * @param roomName      name of classroom
	 * @param rows for seats     no.of rows
	 * @param columns for seats  no.of col
	 */
	
	public Classroom(String buildingName,String roomName,int rows,int columns) {
		//set building name
		this.buildingName = buildingName;
		
		//set room name
		this.roomName = roomName;
		
		//Initialize seat array
		this.seats = new Seat[rows][columns];
		
		//populate seat array
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				//give each location it own new instance of seat class
				seats[i][j] = new Seat(i, j);
			}
		}
		//init list of students
		this.students = new ArrayList<Student>();
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	public void assignStudentToSeat(Student student) {
		int rows = this.seats.length;  //gets numb of rows of seat
		int columns = this.seats[0].length; //get the numb of columns of seats, using how many col are in first row
		
		//visit each seat
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				//get each seat location to see if available
				if (this.seats[i][j].studentInSeat == null) {
					this.seats[i][j].putStudetInSeat(student);
					return; //exit loop and method
				}
			}
		}
	}
	
	public void printAllStudents() {
		System.out.println("Student in class: ");
		
		for (Student student: this.students) {
			System.out.println(student);
		}
	}
	
	public String toString() {
		String s = "\n";
		
		int rows = this.seats.length;  //gets numb of rows of seat
		int columns = this.seats[0].length; //get the numb of columns of seats, using how many col are in first row
		
		//visit each seat
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				s +=this.seats[i][j] + "\t";
			}
			s +="\n";
		}
		return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Classroom addy = new Classroom("AA", "105",10, 5);
		Student adina = new Student("adina", 11);
		Student rafay = new Student("rafay", 10);
		
		addy.addStudent(adina);
		addy.addStudent(rafay);
		
		addy.assignStudentToSeat(adina);
		addy.assignStudentToSeat(rafay);
		
		addy.printAllStudents();
		
		System.out.println(addy);
	}
}