package datamanagement;

import java.util.List;
import org.jdom.*;

public class StudentUnitRecordManager {

private static StudentUnitRecordManager s = null;
            private final StudentUnitRecordMap rm;
    private final java.util.HashMap<String,StudentUnitRecordList> ur;
private final java.util.HashMap<Integer,StudentUnitRecordList> sr;
    public static StudentUnitRecordManager instance() {
 
        if (s != null ) {
        } else {
            s = new StudentUnitRecordManager();
        } return s;}
    
            private StudentUnitRecordManager() {
                // create StudentUnitRecordMap
        rm = new StudentUnitRecordMap();
         // create hash map
    ur = new java.util.HashMap<>();
     // create hash map
    sr = new java.util.HashMap<>();}
    public IStudentUnitRecord getStudentUnitRecord( Integer studentID, String unitCode ) {
IStudentUnitRecord ir = rm.get(studentID.toString()+unitCode);
return ir != null ? ir : createStudentUnitRecord(studentID, unitCode);}

    private IStudentUnitRecord createStudentUnitRecord( Integer uid, String sid ) {
        IStudentUnitRecord ir;
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
        if (uid.toString().equals(el.getAttributeValue("sid")) && sid.equals(el.getAttributeValue("uid"))) {
     
            ir = new StudentUnitRecord(  Integer.valueOf(el.getAttributeValue("sid")),el.getAttributeValue("uid"),Float.parseFloat(el.getAttributeValue("asg1")), Float.valueOf(el.getAttributeValue("asg2")),Float.parseFloat(el.getAttributeValue("exam")) );
               rm.put(ir.getStudentId().toString()+ir.getSubjectCode(), ir);return ir;
}
}
throw new RuntimeException("DBMD: createStudent : student unit record not in file");}
        public StudentUnitRecordList getRecordsByUnit( String unitCode ) {
    StudentUnitRecordList recs = ur.get(unitCode);
    if ( recs != null ) return recs; 
        recs = new StudentUnitRecordList();
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
    if (unitCode.equals(el.getAttributeValue("uid"))) recs.add(new StudentUnitRecordProxy( new Integer(el.getAttributeValue("sid")), el.getAttributeValue("uid")) {

        @Override
        public void setAssignment1(float assignment1Mark) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });
        }
        if ( recs.size() > 0 ) 
            ur.put(unitCode, recs); // be careful - this could be empty
            return recs;
        }

public StudentUnitRecordList getRecordsByStudent( Integer studentID ) {
    StudentUnitRecordList recs = sr.get(studentID);
    if ( recs != null ) return recs; recs = new StudentUnitRecordList();
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) 
            if (studentID.toString().equals(el.getAttributeValue("sid"))) 
                recs.add(new StudentUnitRecordProxy( new Integer(el.getAttributeValue("sid")), el.getAttributeValue("uid")) {

        @Override
        public void setAssignment1(float assignment1Mark) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });
                if ( recs.size() > 0 ) 
                    sr.put(studentID, recs); // be careful - this could be empty
                        return recs;
    }
    /** save the recor
     * @param irec */
    public void saveRecord( IStudentUnitRecord irec ) {
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
            if (irec.getStudentId().toString().equals(el.getAttributeValue("sid")) && irec.getSubjectCode().equals(el.getAttributeValue("uid"))) {
                Element setAttribute;
                setAttribute = el.setAttribute("asg1", Float.toString(irec.getAssignment1()));
                Element setAttribute1;
               setAttribute1 = el.setAttribute("asg2", Float.toString(irec.getAssignment2()));

                Element setAttribute2 = el.setAttribute("exam", Float.toString(irec.getExam()) );
        XMLManager.getXML().saveDocument(); //write out the XML file for continuous save
        return;
}
        }
        
        
        
        
    
        
        
        
        
        
        
        
        
        
        
        
        
                        throw new RuntimeException("DBMD: saveRecord : no such student record in data");}}
