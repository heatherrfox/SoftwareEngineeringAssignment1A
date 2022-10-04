import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;

public class ModuleTest {

    private Module module = TestResources.module;

    @Test
    public void test_moduleIsSetup() {
        assertEquals("Software Engineering III",module.getModuleName());
        assertEquals("CT417",module.getModuleID());
        assertEquals(TestResources.lecturer,module.getLecturer());
    }

    @Test
    public void test_getStudents() {
        module.addStudent(TestResources.student);
        assertEquals(Collections.singleton(TestResources.student), module.getStudents());
    }

    @Test
    public void test_getAssociatedCourses() {
        module.addCourse(TestResources.course);
        assertEquals(Collections.singleton(TestResources.course), module.getCourses());
    }
}
