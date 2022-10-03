import java.util.ArrayList;
import java.util.List;

public class Module {
    private String moduleName;
    private String moduleID;
    private List<Student> students = new ArrayList<>();
    private List<CourseProgramme> associatedCourses = new ArrayList<>();
    private Lecturer lecturer;

    public Module(String moduleName, String moduleID, Lecturer lecturer) {
        this.moduleName = moduleName;
        this.moduleID = moduleID;
        this.lecturer = lecturer;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getModuleID() {
        return moduleID;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addCourse(CourseProgramme course) {
        associatedCourses.add(course);
    }

    public List<CourseProgramme> getAssociatedCourses() {
        return associatedCourses;
    }
}
