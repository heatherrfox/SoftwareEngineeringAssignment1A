import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private LocalDate DOB;
    private int ID;
    private String username;
    private List<CourseProgramme> courses;
    private List<Module> modules;

    public Student(String name ,LocalDate DOB, int ID) {
        this.name = name;
        this.DOB = DOB;
        this.ID = ID;
        age = getAge();
        username = getUsername();
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();

        if ((DOB != null) && (currentDate!=null)) {
            age = Period.between(DOB, currentDate).getYears();
        } else {
            age = 0;
        }

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        if ((name != null) && (ID != 0)) {
            return username = name + ID;
        } else {
            throw new IllegalStateException("Name or ID cannot a must contain a value");
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addCourseProgramme(CourseProgramme courseProgramme) {
        courses.add(courseProgramme);
    }

    public void addModule(Module module) {
        modules.add(module);
    }
}
