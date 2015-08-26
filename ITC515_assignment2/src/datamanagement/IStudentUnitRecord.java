package datamanagement;

public interface IStudentUnitRecord {

    public Integer getStudentId();
    public String getSubjectCode();

    public void setAssignment1(float assignment1Mark);
    public float getAssignment1();

    public void setAssignment2(float assignment2Mark);
    public float getAssignment2();

    public void setExam(float examMark);
    public float getExam();

    public float getTotalMark();
}
