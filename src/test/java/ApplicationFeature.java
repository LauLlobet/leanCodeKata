import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ApplicationFeature {

    private LeanApplication application = new LeanApplication();

    @Test
    public void iteration_3() {

        assertThat(application.processCSV("apples,cherries,bananas"),is(325));
        application = new LeanApplication();
        assertThat(application.processCSV("cherries,cherries"),is(130));
    }


    @Test
    public void iteration_4() {
        assertThat(application.process("cherries"),is(75));
        assertThat(application.process("pommes"),is(175));
        assertThat(application.process("cherries"),is(230));
        assertThat(application.process("bananas"),is(380));
        assertThat(application.process("bananas"),is(380));
        assertThat(application.process("apples"),is(480));
    }

    @Test
    public void iteration_5() {
        assertThat(application.process("mele"),is(100));
        assertThat(application.process("pommes"),is(200));
        assertThat(application.process("pommes"),is(300));
        assertThat(application.process("apples"),is(400));
        assertThat(application.process("pommes"),is(400));
        assertThat(application.process("mele"),is(450));
        assertThat(application.process("cherries"),is(525));
        assertThat(application.process("cherries"),is(580));
    }
}
