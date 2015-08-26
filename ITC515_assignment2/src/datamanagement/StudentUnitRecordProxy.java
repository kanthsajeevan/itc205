ppackage datamanagement;
public class StudentUnitRecordProxy implements IStudentUnitRecord {
        private Integer studentId;
        private String unitCode;
        private StudentUnitRecordManager studentUnitManager;
        
        public StudentUnitRecordProxy (Integer studentId,
			String subjectCode) {
               this.studentId = studentId;
               this.unitCode = subjectCode;
               this.studentUnitManager = StudentUnitRecordManager.instance();
        }
        public Integer getStudentId() { 
            return studentId;
        }

        public String getUnitCode() { return unitCode; 

        }

        public void setAssignment1(float mark) {

            studentUnitManager.getStudentUnitRecord( studentId, unitCode ).setAssignment1(mark);
        }
        
        public float getAssignment1() 

        {

            return studentUnitManager.getStudentUnitRecord( studentId, unitCode ).getAssignment1();
        }

        public void setAssignment2(float mark) { 
            studentUnitManager.getStudentUnitRecord( studentId, unitCode ).setAssignment2(mark);
        }

        public float getAssignment2() {return studentUnitManager.getStudentUnitRecord( studentId, 
                unitCode ).getAssignment2();

        }

        public void setExam(float mark) {studentUnitManager.getStudentUnitRecord( studentId,
                unitCode ).setExam(mark);

        }

        public float getExam() 

        {

            return studentUnitManager.getStudentUnitRecord( studentId,
                    unitCode ).getExam();
        }

        public float getTotal() {return studentUnitManager.getStudentUnitRecord( studentId, 
                unitCode ).getTotal();
        }
}

