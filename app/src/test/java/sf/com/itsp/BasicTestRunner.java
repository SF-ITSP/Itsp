
package sf.com.itsp;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.internal.bytecode.InstrumentationConfiguration;

import com.sf.app.library.utils.ConnectionProxy;

public class BasicTestRunner extends RobolectricGradleTestRunner {
    public BasicTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    public InstrumentationConfiguration createClassLoaderConfig() {
        InstrumentationConfiguration.Builder builder = InstrumentationConfiguration.newBuilder();
        builder.addInstrumentedClass(ConnectionProxy.class.getName());
        return builder.build();
    }
}