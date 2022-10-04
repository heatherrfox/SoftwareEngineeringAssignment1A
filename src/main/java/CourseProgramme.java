import org.joda.time.DateTime;

import java.time.DateTimeException;
import java.util.HashSet;
import java.util.List;

public class CourseProgramme {
    private String courseName;
    private DateTime startDate;
    private DateTime endDate;
    private HashSet<Module> courseModules;
    private HashSet<Student> courseStudents;
    public CourseProgramme(String courseName, DateTime startDate, DateTime endDate){
        this.courseName = courseName;
        setStartDate(startDate);
        setEndDate(endDate);
        courseModules = new HashSet<>();
        courseStudents = new HashSet<>();
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
        courseModules.add(module);
    }

    public HashSet<Module> getModules() {
        return courseModules;
    }

    public void addStudent(Student student) {
        courseStudents.add(student);
    }

    public HashSet<Student> getStudents() {
        return courseStudents;
    }
}
