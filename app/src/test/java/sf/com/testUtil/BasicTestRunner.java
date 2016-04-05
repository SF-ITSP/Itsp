
package sf.com.testUtil;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.internal.bytecode.InstrumentationConfiguration;

import sf.com.itsp.shadows.ShadowApiProxy;
import sf.com.itsp.utils.ConnectionProxy;

public class BasicTestRunner extends RobolectricGradleTestRunner {
    public BasicTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    public InstrumentationConfiguration createClassLoaderConfig() {
        InstrumentationConfiguration.Builder builder = InstrumentationConfiguration.newBuilder();

//        builder.addInstrumentedClass(ShadowHttpClient.class.getName());
        builder.addInstrumentedClass(ShadowApiProxy.class.getName());
        builder.addInstrumentedClass(ConnectionProxy.class.getName());

        return builder.build();
    }
}