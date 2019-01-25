import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ApplicationFeature {

    private LeanApplication application = new LeanApplication();

    @Test
    public void beTesteable() {
        assertThat(application.process("apples"),is("100"));
    }
}
