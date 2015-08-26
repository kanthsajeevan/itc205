package datamanagement;

public class Student implements IStudent {
    private Integer id; private String fn;
            private String ln;
private StudentUnitRecordList su;

// Constructor for the Student class. Will create the Student object based
// on the values of the parameters passed.
public Student( Integer id, String fn, String ln, StudentUnitRecordList su ) { this.id = id; this.fn = fn;
        this.ln = ln;this.su = 
       
                su == null ? new StudentUnitRecordList() : 
                su;
}

    public Integer getID() { return this.id; 

    } 
    public String getFirstName() { 

        return fn; }

    public void setFirstName( String firstName ) { 

        this.fn = firstName; }


    public String getLastName() { 
    
        return ln; }
   
    public void setLastName( String lastName ) { 

        

        this.ln = lastName; }
    
     // The addUnitRecord method will add the passed student unit record
  
     // to this object's student unit record list.


    public void addUnitRecord( IStudentUnitRecord record ) { su.add(record); }
        public IStudentUnitRecord getUnitRecord( String unitCode ) {

            for ( IStudentUnitRecord r : su ) 
            
                if ( r.getUnitCode().equals(unitCode)) 

                
                    return r; 


            
            return null;
        
}
        // The getUnitRecord method differs from the standard getter that
        // returns the entire unit record list, rather it returns one unit
        // record, if it exists, based on a passed unit code.

        public StudentUnitRecordList getUnitRecords() {
            return su; 
        }
}
