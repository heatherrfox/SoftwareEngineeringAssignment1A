package ie.nuigalway.obrien.ct417ass1a;

import java.util.HashSet;

public class Module {
    private String moduleName;
    private String moduleID;
    private HashSet<Student> moduleStudents;
    private HashSet<CourseProgramme> moduleCourses;
    private Lecturer lecturer;

    public Module(String moduleName, String moduleID, Lecturer lecturer) {
        this.moduleName = moduleName;
        this.moduleID = moduleID;
        this.lecturer = lecturer;
        moduleStudents = new HashSet<>();
        moduleCourses = new HashSet<>();
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
        moduleStudents.add(student);
    }

    public HashSet<Student> getStudents() {
        return moduleStudents;
    }

    public void addCourse(CourseProgramme course) {
        moduleCourses.add(course);
    }

    public HashSet<CourseProgramme> getCourses() {
        return moduleCourses;
    }
}
