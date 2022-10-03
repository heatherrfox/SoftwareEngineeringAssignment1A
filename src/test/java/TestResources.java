import org.joda.time.DateTime;

import java.time.LocalDate;

public class TestResources {
    public static Student student = new Student("Heather", "OBrien", LocalDate.of(2001, 10, 11));

    public static Lecturer lecturer =  new Lecturer("Michael", "Schukat", LocalDate.of(1980, 9, 23));
    public static Module module = new Module("Software Engineering III", "CT417", lecturer);
    public static CourseProgramme course = new CourseProgramme("Computer Science & Information Technology",new DateTime(2022,9,4,9,0),
            new DateTime(2023,4,20,10,11));


}
