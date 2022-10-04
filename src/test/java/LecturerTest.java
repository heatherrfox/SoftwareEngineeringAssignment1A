import ie.nuigalway.obrien.ct417ass1a.Lecturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Collections;

public class LecturerTest {
    private Lecturer lecturer;

    @BeforeEach
    public void resetValues() {
        lecturer =  new Lecturer("Michael", "Schukat", LocalDate.of(1980, 9, 23));
    }

    @Test
    public void test_lecturerIsSetup() {
        assertEquals("Michael", lecturer.getFirstName());
        assertEquals("Schukat", lecturer.getLastName());
        assertEquals(23, lecturer.getDOB().getDayOfMonth());
        assertEquals(9, lecturer.getDOB().getMonthValue());
        assertEquals(1980, lecturer.getDOB().getYear());
        assertEquals(3, lecturer.getID());
        assertEquals(42, lecturer.getAge());
        assertEquals("MichaelSchukat3", lecturer.getUsername());
    }

    @Test
    public void test_getUsername_firstNameNull() {
        lecturer.setFirstName(null);
        Exception exception = assertThrows(IllegalStateException.class, () -> lecturer.getUsername());
        assertEquals("Name and ID must contain a value", exception.getMessage());

    }

    @Test
    public void test_getUsername_lastNameNull() {
        lecturer.setLastName(null);
        Exception exception = assertThrows(IllegalStateException.class, () -> lecturer.getUsername());
        assertEquals("Name and ID must contain a value", exception.getMessage());

    }

    @Test
    public void test_getUsername_nullID() {
        lecturer.setID(0);
        Exception exception = assertThrows(IllegalStateException.class, () -> lecturer.getUsername());
        assertEquals("Name and ID must contain a value", exception.getMessage());
    }

    @Test
    public void test_getAge_DOBisNull() {
        lecturer.setDOB(null);
        Exception exception = assertThrows(IllegalStateException.class, () -> lecturer.getAge());
        assertEquals("Date of Birth must contain a value", exception.getMessage());
    }

    @Test
    public void test_getAge_DOBisAfterCurrentDate() {
        lecturer.setDOB(LocalDate.now().plusDays(1));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> lecturer.getAge());
        assertEquals("Date of Birth must be before today's date", exception.getMessage());

    }

    @Test
    public void test_getModules() {
        lecturer.addModule(TestResources.module);
        assertEquals(Collections.singleton(TestResources.module), lecturer.getModules());
    }
}
