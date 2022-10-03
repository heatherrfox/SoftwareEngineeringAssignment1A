import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Collections;

public class StudentTest {
    private Student student;

    @BeforeEach
    public void resetValues() {
         student = new Student("Heather", "OBrien", LocalDate.of(2001, 10, 11));
    }

    @Test
    public void test_studentIsSetup() {
        assertEquals("Heather", student.getFirstName());
        assertEquals("OBrien", student.getLastName());
        assertEquals(11, student.getDOB().getDayOfMonth());
        assertEquals(10, student.getDOB().getMonthValue());
        assertEquals(2001, student.getDOB().getYear());
        assertEquals(4, student.getID());
        assertEquals(20, student.getAge());
        assertEquals("HeatherOBrien4", student.getUsername());
    }

    @Test
    public void test_getUsername_firstNameNull() {
        student.setFirstName(null);
         Exception exception = assertThrows(IllegalStateException.class, () -> student.getUsername());
         assertEquals("Name and ID must contain a value", exception.getMessage());

    }

    @Test
    public void test_getUsername_lastNameNull() {
        student.setLastName(null);
        Exception exception = assertThrows(IllegalStateException.class, () -> student.getUsername());
        assertEquals("Name and ID must contain a value", exception.getMessage());

    }

    @Test
    public void test_getUsername_nullID() {
        student.setID(0);
        Exception exception = assertThrows(IllegalStateException.class, () -> student.getUsername());
        assertEquals("Name and ID must contain a value", exception.getMessage());
    }

    @Test
    public void test_getAge_DOBisNull() {
        student.setDOB(null);
        Exception exception = assertThrows(IllegalStateException.class, () -> student.getAge());
        assertEquals("Date of Birth must contain a value", exception.getMessage());
    }

    @Test
    public void test_getAge_DOBisAfterCurrentDate() {
        student.setDOB(LocalDate.now().plusDays(1));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> student.getAge());
        assertEquals("Date of Birth must be before today's date", exception.getMessage());

    }

    @Test
    public void test_getModules() {
        student.addModule(TestResources.module);
        assertEquals(Collections.singletonList(TestResources.module), student.getModules());
    }

    @Test
    public void test_getCourseProgrammes() {
        student.addCourseProgramme(TestResources.course);
        assertEquals(Collections.singletonList(TestResources.course),student.getCourseProgrammes());
    }
}
