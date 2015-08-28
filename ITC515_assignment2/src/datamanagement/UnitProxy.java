package datamanagement;
public class UnitProxy implements IUnit {
private String subjectCode;
        private String subjectName;

        
        UnitManager   unitManager;

    public UnitProxy( String unitCode, String unitName ) {
        
        this.subjectCode = unitCode;
        this.subjectName = unitName;
                
        unitManager = UnitManager.UM(); }
    
    public String getUnitCode() { 
        return this.subjectCode;}
        
    public String getUnitName() { 
            return this.subjectName; 
        }
    public void setPassCutoff(float cutoff) {
        unitManager.getUnit(subjectCode).setPassCutoff(cutoff);

    }
    

    public float getPassCutoff() {
        
        return unitManager.getUnit(subjectCode).getPassCutoff();}
    
    public void setCreditCutoff(float cutoff) {unitManager.getUnit(subjectCode).setCreditCutoff(cutoff);
    }
    
    public float getCreditCutoff() {
        

        return unitManager.getUnit(subjectCode).getCreditCutoff();
    }


    public void setDistinctionCutoff(float cutoff) {
        unitManager.getUnit(subjectCode).setDistinctionCutoff(cutoff);
    }
    
    public float getDistinctionCutoff() {
        return unitManager.getUnit(subjectCode).getDistinctionCutoff();
    }

    public void setHighDistinctionCutoff(float cutoff) {
    unitManager.getUnit(subjectCode).setHighDistinctionCutoff(cutoff);
    }
    
    public float getHighDistinctionCutoff() {

        return unitManager.getUnit(subjectCode).getHighDistinctionCutoff();
    }

    public void setAlternativeExitCutoff(float cutoff) {
        unitManager.getUnit(subjectCode).setAlternativeExitCutoff(cutoff);
    }
    
    public float getAlternativeExitCutoff() {
        return unitManager.getUnit(subjectCode).getAlternativeExitCutoff();
    }

    public String getGrade(float f1, float f2, float f3) {

        return unitManager.getUnit(subjectCode).getGrade(f1, f2, f3);
    }
    
    public void addStudentRecord(IStudentUnitRecord record) { 

        unitManager.getUnit(subjectCode).addStudentRecord(record);
    }
    
    public IStudentUnitRecord getStudentRecord(int s) {
        return unitManager.getUnit(subjectCode).getStudentRecord(s);
    }

    public StudentUnitRecordList listStudentRecords() {
    return unitManager.getUnit(subjectCode).listStudentRecords();

    }

    public int getAssignment1Weight() {
	return unitManager.getUnit(subjectCode).getAssignment1Weight();

    }

    public int getAssignment2Weight() {
	return unitManager.getUnit(subjectCode).getAssignment2Weight();

    }

    public int getExamWeight() {
	return unitManager.getUnit(subjectCode).getExamWeight();

    
    }

    public void setAssessmentWeights(int assignment1Weight, int assignment2Weight, int examWeight) {
	unitManager.getUnit(subjectCode).setAssessmentWeights(assignment1Weight, assignment2Weight, examWeight);
	

    }
}
