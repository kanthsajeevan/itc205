package datamanagement;

public class StudentUnitRecord implements IStudentUnitRecord {
	private Integer sid; //variable to store the student ID
	private String uc;   //variable to store the unit code
	private float a1, a2, ex; //variables to store assignment 1, assignment2 and exam marks

	public StudentUnitRecord(Integer id, String code, float assignment1, float assignment2,
			float exam) {
		this.sid = id;
		this.uc = code;
		this.setAssignment1(assignment1);
		this.setAssignment2(assignment2);
		this.setExam(exam);
	}

	public Integer getStudentID() {
		return sid;
	}

	public String getUnitCode() {
		return uc;
	}

	public void setAssignment1(float a1) {
            
           /// Check assignment 1 marks
		if (a1 < 0 ||
			a1 > UnitManager.UM().getUnit(uc).getAsg1Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.a1 = a1;
	}

	public float getAssignment1() {

		return a1;
	}

	public void setAssignment2(float a2) {
            // Check assignment 2 marks
		if (a2 < 0 ||
			a2 > UnitManager.UM().getUnit(uc).getAsg2Weight()) {
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.a2 = a2;

	}

	public float getAssignment2() {
		return a2;
	}

	public void setExam(float ex) {
            // Check exam marks
		if (ex < 0 ||
				ex > UnitManager.UM().getUnit(uc).getExamWeight()) {
				throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
			}
		this.ex = ex;
	}

	public float getExam() {
		return ex;
	}

	public float getTotal() {
            //Return the total mark
		return a1 + a2 + ex;

	}

    @Override
    public Integer getStudentId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSubjectCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getTotalMark() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
