import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseProgrammeTest {

    private CourseProgramme courseProgramme = TestResources.course;

    @Test
    public void test_courseIsSetup() {
        assertEquals("Computer Science & Information Technology",
                courseProgramme.getCourseName());
        assertEquals(new DateTime(2022,9,4,9,0),
                courseProgramme.getStartDate());
        assertEquals(new DateTime(2023,4,20,10,11),
                courseProgramme.getEndDate());
    }

    @Test
    public void test_setStartDate_afterEndDate() {
        Exception exception = assertThrows(DateTimeException.class, () -> {
            courseProgramme.setStartDate(new DateTime(2024,4,20,10,9));
        });
        assertEquals("Start Date cannot be after End Date", exception.getMessage());
    }

    @Test
    public void test_setEndDate_beforeStartDate() {
        Exception exception = assertThrows(DateTimeException.class, () -> {
            courseProgramme.setEndDate(new DateTime(2021,4,20,10,9));
        });
        assertEquals("End Date cannot be before Start Date", exception.getMessage());
    }

    @Test
    public void test_getModules() {
        courseProgramme.addModule(TestResources.module);
        assertEquals(Collections.singletonList(TestResources.module),
                courseProgramme.getModules());
    }

    @Test
    public void test_getStudents() {
        courseProgramme.addStudent(TestResources.student);
        assertEquals(Collections.singletonList(TestResources.student),
                courseProgramme.getStudents());
    }


}
