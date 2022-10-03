import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Lecturer {
    private String name;
    private int age;
    private LocalDate DOB;
    private int ID;
    private String username;
    private List<Module> teachingModules;

    public Lecturer(String name, LocalDate DOB, int ID ) {
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
        return username = name + ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addModule(Module module) {
        teachingModules.add(module);
    }
}
