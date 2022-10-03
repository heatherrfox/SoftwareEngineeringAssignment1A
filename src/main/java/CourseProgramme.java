import org.joda.time.DateTime;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;

public class CourseProgramme {
    private String courseName;
    private List<Module> modules = new ArrayList<>();
    private List<Student> students =new ArrayList<>();
    private DateTime startDate;
    private DateTime endDate;

    public CourseProgramme(String courseName, DateTime startDate, DateTime endDate){
        this.courseName = courseName;
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public String getCourseName() {
        return courseName;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        if(startDate.isAfter(endDate)) {
            throw new DateTimeException("Start Date cannot be after End Date");
        } else {
            this.startDate = startDate;
        }
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        if(endDate.isBefore(startDate)) {
            throw new DateTimeException("End Date cannot be before Start Date");
        } else {
            this.endDate = endDate;
        }
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public List<Module> getModules() {
        return modules;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}
