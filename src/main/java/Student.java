import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    private static final AtomicInteger count = new AtomicInteger(0);
    private String fname;
    private String lname;
    private int age;
    private LocalDate DOB;
    private int ID;
    private String username;
    private List<CourseProgramme> courseProgrammes = new ArrayList<>();
    private List<Module> modules = new ArrayList<>();

    public Student(String fname ,String lname, LocalDate DOB) {
        this.fname = fname;
        this.lname = lname;
        this.DOB = DOB;
        ID = count.incrementAndGet();
        age = getAge();
        username = getUsername();
    }

    public String getFirstName(){
        return fname;
    }

    public String getLastName() {return lname;}

    public void setFirstName(String fname) {
        this.fname = fname;
    }

    public void setLastName(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();

        if(DOB != null) {
            if(currentDate.isBefore(DOB)) {
                throw new IllegalArgumentException("Date of Birth must be before today's date");
            }
            else {
                age = Period.between(DOB, currentDate).getYears();

            }
        } else {
            throw new IllegalStateException("Date of Birth must contain a value");
        }
        return age;
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
        if ((fname != null) && (lname != null) && (ID != 0)) {
            return username = fname + lname + ID;
        } else {
            throw new IllegalStateException("Name and ID must contain a value");
        }
    }

    public void addCourseProgramme(CourseProgramme courseProgramme) {
        courseProgrammes.add(courseProgramme);
    }

    public List<CourseProgramme> getCourseProgrammes() {
        return courseProgrammes;
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public List<Module> getModules() {
        return modules;
    }
}
