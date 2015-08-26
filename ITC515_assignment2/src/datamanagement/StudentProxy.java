package datamanagement;

public class StudentProxy implements IStudent {

    private Integer studentId;

    private String firstName;

    private String lastName;
    private StudentManager studentManager;
    
    // StudentProxy constructor. Sets the relevant variables to the passed
    // integers. Additionally, retrieves the StudentManager instance.
    public StudentProxy( Integer studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;

        
        this.lastName = lastName;

        this.studentManager = StudentManager.get();}

    public Integer getID() { 
        return studentId;
    }

    public String getFirstName() { 
        return firstName; }

    public String getLastName() { 

        return lastName; 

    }

    public void setFirstName(String firstName) {

        studentManager.getStudent(studentId).setFirstName(firstName);}
    
    public void setLastName(String lastName) {
        
        
        
        studentManager.getStudent(studentId).setLastName(lastName);}

    
    
     // The method addUnitRecord adds a single passed student unit record to
     // the StudentManager of this StudentProxy object.  
    public void addUnitRecord(IStudentUnitRecord record) {
        
        studentManager.getStudent(studentId).addUnitRecord(record);}
    
    // The getUnitRecord method differs from the standard getter that
    // returns the entire unit record list, rather it returns one unit
    // record based on a passed unit code.
    public IStudentUnitRecord getUnitRecord(String unitCode) {

           
        return studentManager.getStudent(studentId).getUnitRecord(unitCode);}


   
    public StudentUnitRecordList getUnitRecords() {
                                    
        return studentManager.getStudent(studentId).getUnitRecords();
    }
}
