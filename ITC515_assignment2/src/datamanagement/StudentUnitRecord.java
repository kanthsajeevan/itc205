package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord {
	private Integer studentId;
	private String unitCode;
	private float assignment1, assignment2, exam;

	public StudentUnitRecord(Integer id, String code, float assignment1, float assignment2,
			float exam) {
		this.studentId = id;
		this.unitCode = code;
		this.setAssignment1(assignment1);
		this.setAssignment2(assignment2);
		this.setExam(exam);
	}

	public Integer getStudentId() {
		return studentId;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setAssignment1(float assignment1) {
		if (assignment1 < 0 ||
			assignment1 > UnitManager.UM().getUnit(unitCode).getAsg1Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assignment1 = assignment1;
	}

	public float getAssignment1() {

		return assignment1;
	}

	public void setAssignment2(float a2) {
		if (a2 < 0 ||
			a2 > UnitManager.UM().getUnit(unitCode).getAsg2Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.assignment2 = a2;

	}

	public float getAssignment2() {
		return assignment2;
	}

	public void setExam(float exam) {
		if (exam < 0 ||
				
                        exam > UnitManager.UM().getUnit(unitCode).getExamWeight()) {
				throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
			}
		
                this.exam = exam;
	}

	public float getExam() {
		return exam;
	}

	public float getTotal() {
		return assignment1 + assignment2 + exam;

	}
}

