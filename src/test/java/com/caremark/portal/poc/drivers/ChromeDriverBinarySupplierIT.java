package com.caremark.portal.poc.drivers;

import org.junit.Test;

import java.nio.file.Paths;

public class ChromeDriverBinarySupplierIT {

    @Test
    public void acquireChrome() throws Exception {
        new ChromeDriverBinarySupplier().get(Paths.get("target"));
    }

}