package datamanagement;

public class StudentUnitRecordProxy implements IStudentUnitRecord {
       private Integer studentId;
       private String subjectCode;
       private StudentUnitRecordManager studentUnitManager;

       public StudentUnitRecordProxy( Integer studentId, 
                        String subjectCode ) {
  
       this.studentId = studentId;
       this.subjectCode = subjectCode;
       this.studentUnitManager = StudentUnitRecordManager.instance();
                          
       }
       
       public Integer getStudentId() { 
                return studentId;
         
       }
       
       public String getSubjectCode() { 
               return subjectCode; 
       }
       
       public float getAssignment1() {
	          	return studentUnitManager.getStudentUnitRecord(studentId,
				      subjectCode).getAssignment1();
    	}
       
      public void setAssignent1(float assignment1Mark) {
               studentUnitManager.getStudentUnitRecord( studentId, 
                               subjectCode ).setAssignment1(assignment1Mark);
        
      }

      public float getAssignment2() {
              return studentUnitManager.getStudentUnitRecord( studentId, 
                              subjectCode ).getAssignment2();
      }

      public void setAssignment2(float assignment2mark) { 
                studentUnitManager.getStudentUnitRecord( studentId, 
                                subjectCode ).setAssignment2(assignment2mark);
        
      }
      public float getExam() {
        
              return studentUnitManager.getStudentUnitRecord( studentId, 
                          subjectCode ).getExam();
        
      }

      public void setExam(float examMark) {
               studentUnitManager.getStudentUnitRecord( studentId, 
                               subjectCode ).setExam(examMark);
      }
     
      
      public float getTotalMark() {
               return studentUnitManager.getStudentUnitRecord( studentId, subjectCode ).getTotalMark();
        
      }
  
}
