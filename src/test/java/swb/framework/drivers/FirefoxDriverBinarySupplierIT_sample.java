package swb.framework.drivers;

import org.junit.Test;

import java.nio.file.Paths;

public class FirefoxDriverBinarySupplierIT_sample {

    @Test
    public void acquireFirefox() throws Exception {
        new FirefoxDriverBinarySupplier().get(Paths.get("target"));
    }

}