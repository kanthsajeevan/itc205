package datamanagement;

import org.jdom.*;
import java.util.List;
public class StudentManager {
    private static StudentManager instance = null;

    
    private StudentMap studentMap;
    private java.util.HashMap<String, StudentMap> studentsToUnitsMap;
    

     // The StudentManager's getInstance method. Will return the
     // lone instance of this class.
    public static StudentManager getInstance() {
        
        if (instance == null) 
            

            instance = new StudentManager();
        
        return instance; }

    // The private StudentManager constructor, potentially called as
    // a result of the getInstance() method being called.
    private StudentManager() {

        studentMap = new StudentMap();
        studentsToUnitsMap = new java.util.HashMap<>();}
        
    // The method getStudent will return a Student based on the passed id
    // parameter. If the student doesn't exist, the createStudent method
    // is called with the passed id parameter and that result is returned.
    public IStudent getStudent(Integer id) {

        IStudent is = studentMap.get(id);
        
        return is != null ? is : createStudent(id);
    }


   // The getStudentElement will take a passed id parameter and return
   // an Element based on the id matching a particular attribute value.
   // If there is no match, it will return null.
    private Element getStudentElement(Integer id) {
        for (Element element : (List<Element>) XMLManager.getXML().getDocument()
                .getRootElement().getChild("studentTable").getChildren("student")) 
            if (id.toString().equals(element.getAttributeValue("sid"))) 
  
                return element;
       return null;
       
                }
    
                 // The createStudent method will create a Student based on a match to 
                 // the passed id parameter. If the Student is not able to be created
                 // then an exception is thrown describing the problem.
                private IStudent createStudent(Integer id) {
                    IStudent iStudent;
        
                    Element element = getStudentElement(id);
        
                    if (element != null) {
            
                        StudentUnitRecordList rlist = StudentUnitRecordManager.instance().getRecordsByStudent(id);
    
                        iStudent = new Student(new Integer(element.getAttributeValue("sid")),element.getAttributeValue("fname"),element.getAttributeValue("lname"),rlist);

    
    
                        studentMap.put(iStudent.getID(), iStudent);
        
                        return iStudent;
                    }

                    throw new RuntimeException("DBMD: createStudent : student not in file");
                }
    
                 // The createStudentProxy method will create and return a StudentProxy
                 // based on a match to the passed id parameter. If the Proxy cannot be 
                 // created, an exception is thrown describing the problem.
                private IStudent createStudentProxy(Integer id) {
        
                    Element element = getStudentElement(id);
        
        
                    if (element != null) 
                        return new StudentProxy(id, element.getAttributeValue("fname"), 
                                element.getAttributeValue("lname"));
        
                    throw new RuntimeException("DBMD: createStudent : student not in file");
                }

        
                // The getStudentsByUnit method will create a StudentMap and return it.
                // Its contents are based on what students have a matching unit code to 
                // the passed unitCode parameter.
                public StudentMap getStudentsByUnit(String  unitCode) {
       
                    StudentMap studentMap = studentsToUnitsMap.get( unitCode);
        
                    if (studentMap != null) 

                    {
                        return studentMap;
                }


                    studentMap = new StudentMap();

                    IStudent iStudent;
    
                    StudentUnitRecordList ur = StudentUnitRecordManager.instance()
                            .getRecordsByUnit( unitCode);
        
                    for (IStudentUnitRecord S : ur) {
            
            
           
                        iStudent = createStudentProxy(new Integer(S.getStudentId()));
   
                        studentMap.put(iStudent.getID(), iStudent);}
    
                    studentsToUnitsMap.put(  unitCode, studentMap);
        
                    return studentMap;

                }
}
