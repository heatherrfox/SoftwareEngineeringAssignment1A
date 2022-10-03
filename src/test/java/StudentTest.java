import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    Student student = new Student("Heather", LocalDate.of(2001, 10, 11), 19498304 );

    @Test
    public void test_getUsername() {
        assertEquals("Heather19498304", student.getUsername());
    }

    @Test
    public void test_getUsername_nullName() {

    }

}
