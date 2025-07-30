package mymockito;

public class Employee {
	
		private Long employeeId;
		private String employeeName;
		private String gender;
		private int points;
		public Long getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(Long employeeId) {
			this.employeeId = employeeId;
		}
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getPoints() {
			return points;
		}
		public void setPoints(int points) {
			this.points = points;
		}
		public Employee(Long employeeId, String employeeName, String gender, int points) {
			super();
			this.employeeId = employeeId;
			this.employeeName = employeeName;
			this.gender = gender;
			this.points = points;
		}

}
