/**
 * Each seat has row and column 
 * it might has a student assigned to it 
 * @author addyf
 *
 */
public class Seat {
	int row;
	int column;
	Student studentInSeat;
	
	//constructor
	public Seat(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public void putStudetInSeat(Student student) {
		this.studentInSeat = student;
	}
	
	public String toString() {
		return this.row + ", " + this.column + ": " + this.studentInSeat; //this will also call the toString method in Student class
	}
}
