import java.util.List;

public class Module {
    private String moduleName;
    private int moduleID;
    private List<Student> students;
    private List<CourseProgramme> associatedCourses;
    private Lecturer lecturer;

    public Module(String moduleName, int moduleID, Lecturer lecturer) {
        this.moduleName = moduleName;
        this.moduleID = moduleID;
        this.lecturer = lecturer;
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getModuleID() {
        return moduleID;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(CourseProgramme course) {
        associatedCourses.add(course);
    }
}
