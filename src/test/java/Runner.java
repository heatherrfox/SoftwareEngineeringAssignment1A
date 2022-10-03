import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherFactory;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.launcher.listeners.TestExecutionSummary.Failure;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        final LauncherDiscoveryRequest request =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(
                                selectClass(StudentTest.class),
                                selectClass(LecturerTest.class),
                                selectClass(ModuleTest.class),
                                selectClass(CourseProgrammeTest.class)
                        )
                        .build();

        final Launcher launcher = LauncherFactory.create();
        final SummaryGeneratingListener listener = new SummaryGeneratingListener();

        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        //print summary of tests
        TestExecutionSummary summary = listener.getSummary();
        System.out.println("Tests found: " + summary.getTestsFoundCount());
        System.out.println("Tests succeeded: " + summary.getTestsSucceededCount());
        System.out.println("Tests failed: " + summary.getTestsFailedCount());

        //print failure details
        List<Failure> failures = summary.getFailures();
        failures.forEach(failure ->  {
            System.out.println("*****FAILURE*****");
            System.out.println("Test identifier: " + failure.getTestIdentifier().getDisplayName());
            System.out.println("Exception:" + failure.getException());
            System.out.println("*****************");
        });
    }
}
