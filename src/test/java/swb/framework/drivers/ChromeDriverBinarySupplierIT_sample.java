package swb.framework.drivers;

import org.junit.Test;

import java.nio.file.Paths;

public class ChromeDriverBinarySupplierIT_sample {

    @Test
    public void acquireChrome() throws Exception {
        new ChromeDriverBinarySupplier().get(Paths.get("target"));
    }

}