package datamanagement;

public class Student implements IStudent {
    
    private Integer identification;
    private String firstName;
    private String lastName;
    private StudentUnitRecordList studentUnitRecordList;

// Constructor for the Student class. Will create the Student object based
// on the values of the parameters passed.
public Student( Integer identification, String firstName, String lastName,
        StudentUnitRecordList studentUnitRecordList ) { 
    this.identification = identification; 
    this.firstName = firstName;
    this.lastName = lastName;
    this.studentUnitRecordList = 
       studentUnitRecordList == null ? new StudentUnitRecordList() : 
                studentUnitRecordList;
}

    public Integer getID() {
        return this.identification; 

    } 
    public String getFirstName() { 
        return firstName; 
    }

    public void setFirstName( String firstName ) { 

        this.firstName = firstName;
    }


    public String getLastName() { 
    
        return lastName;
    }
   
    public void setLastName( String lastName ) { 

         this.lastName = lastName;
    }
    
     // The addUnitRecord method will add the passed student unit record
  
     // to this object's student unit record list.
     public void addUnitRecord( IStudentUnitRecord record ) { 
         studentUnitRecordList.add(record);
     }
        
    // The getUnitRecord method differs from the standard getter that
    // returns the entire unit record list, rather it returns one unit
    // record, if it exists, based on a passed unit code. 
     public IStudentUnitRecord getUnitRecord( String unitCode ) {

            for ( IStudentUnitRecord record : studentUnitRecordList ) 
            
                if ( record.getUnitCode().equals(unitCode)) 

                
                    return record; 


            
            return null;
        
}
        

        public StudentUnitRecordList getUnitRecords() {
            return studentUnitRecordList; 
        }
}
