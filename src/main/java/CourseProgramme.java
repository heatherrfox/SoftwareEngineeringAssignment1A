import org.joda.time.DateTime;
import java.util.List;

public class CourseProgramme {
    private String courseName;
    private List<Module> modules;
    private List<Student> students;
    private DateTime startDate;
    private DateTime endDate;

    public CourseProgramme(String courseName, DateTime startDate, DateTime endDate){
        this.courseName = courseName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
