package datamanagement;

import java.util.List;
import org.jdom.*;

public class StudentUnitRecordManager {

private static StudentUnitRecordManager instance = null;

            private StudentUnitRecordMap studentMap;
    
            private java.util.HashMap<String,StudentUnitRecordList> subjectToStudentRecord;

            private java.util.HashMap<Integer,StudentUnitRecordList> studentToSubjectRecord;
   
            // Check if singleton class exists, return self.
            public static StudentUnitRecordManager instance() {
       
                if (instance == null ) instance = new StudentUnitRecordManager();
                
                return instance;
            }
            
            private StudentUnitRecordManager() {
        
                studentMap = new StudentUnitRecordMap();
    
                subjectToStudentRecord = new java.util.HashMap<>();
    
                studentToSubjectRecord = new java.util.HashMap<>();
            }
    
            // Accessor method to return StudentUnitRecord.
            public IStudentUnitRecord getStudentUnitRecord( Integer studentID, String unitCode ) {

                IStudentUnitRecord ir = studentMap.get(studentID.toString()+unitCode);
 
                return ir != null ? ir : createStudentUnitRecord(studentID, unitCode);
            }

    
            // Mutator method to change assessment marks.
            private IStudentUnitRecord createStudentUnitRecord( Integer subjectCode, String studentId ) {
        
                IStudentUnitRecord newStudentPerUnit;
        
                for (Element el : (List<Element>) XMLManager.getXML().getDocument()
                        .getRootElement().getChild("studentUnitRecordTable")
                        .getChildren("record")) {
        
                    if (subjectCode.toString().equals(el.getAttributeValue("sid")) && studentId.equals(el.getAttributeValue("uid"))) {
                
                        newStudentPerUnit = new StudentUnitRecord( new Integer(el.getAttributeValue("sid")),el.getAttributeValue("uid"),new Float(el.getAttributeValue("asg1")).
                                floatValue(),new Float(el.getAttributeValue("asg2")).floatValue(),new Float(el.getAttributeValue("exam")).floatValue() );
               
                        
                        studentMap.put(newStudentPerUnit.getStudentId().
                                toString()+newStudentPerUnit.getUnitCode(), newStudentPerUnit);return newStudentPerUnit;

                    }

                }

                throw new RuntimeException(
                        "DBMD: createStudent : student unit record not in file");}
        
            // Accessor to return a record using subject.
            public StudentUnitRecordList getRecordsByUnit( String subjectCode ) {
    
                StudentUnitRecordList unitRecord = subjectToStudentRecord.get(subjectCode);
    
                if ( unitRecord != null ) 
                    return unitRecord; 
        
                unitRecord = new StudentUnitRecordList();
       
                for (Element el : (List<Element>) XMLManager.getXML().getDocument().
                        getRootElement().getChild("studentUnitRecordTable").
                        getChildren("record")) {
    
                    if (subjectCode.equals(el.getAttributeValue("uid"))) unitRecord.
                            add(new StudentUnitRecordProxy( new Integer(el.getAttributeValue("sid")), el.
                                    getAttributeValue("uid")));
        
                }
        
                if ( unitRecord.size() > 0 ) 
            
                    subjectToStudentRecord.put(subjectCode, unitRecord); // be careful - this could be empty
            
                return unitRecord;
        
            }


            // Accessor to return a record by student.
            public StudentUnitRecordList getRecordsByStudent( Integer studentID ) {
    
                StudentUnitRecordList studentRecord = studentToSubjectRecord.get(studentID);
    
                if ( studentRecord != null ) return studentRecord; studentRecord = new StudentUnitRecordList();
        
                for (Element el : (List<Element>) XMLManager.getXML().getDocument().
                        getRootElement().getChild("studentUnitRecordTable").
                        getChildren("record")) 
            
                    if (studentID.toString().equals(el.getAttributeValue("sid"))) 
                studentRecord.add(new StudentUnitRecordProxy( new Integer(el.getAttributeValue("sid")), el.getAttributeValue("uid")));
                if ( studentRecord.size() > 0 ) 
                    studentToSubjectRecord.put(studentID, studentRecord); // be careful - this could be empty
                        return studentRecord;
    }

    
            // Save changes to the XML database.
            public void saveRecord( IStudentUnitRecord student) {
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().
                getChild("studentUnitRecordTable").getChildren("record")) {
            if (student.getStudentId().toString().equals(el.getAttributeValue("sid")) && student.
                    getUnitCode().equals(el.getAttributeValue("uid"))) {
                el.setAttribute("asg1", new Float(student.getAssignment1()).toString());
                
                
                
        
                el.setAttribute("asg2", new Float(student.getAssignment2()).toString());
        
                el.setAttribute("exam", new Float(student.getExam()).toString());
        
                XMLManager.getXML().saveDocument(); //write out the XML file for continuous save
        
                return;

            }
        }
        
        
        
        
    
        
        
        
        
        
        
        
        
        
        
        
        
                        throw new RuntimeException("DBMD: saveRecord : no such student record in data");
            }
}

        
        
        
        
        
        
        
        
        
        
        
