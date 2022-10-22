package com.digimind.services.topreputation;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Integration test to check if spring context configured from {@link TopReputationDatasourceApplication} is
 * successfully initialized.
 *
 * @author <a href="mailto:guillaume.gageonnet@digimind.com">Gageonnet Guillaume</a>
 **/
@ActiveProfiles("it")
@SpringBootTest
class ContextBootstrapTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContextBootstrapTest.class);

    @Test
    void contextLoads() {
        LOGGER.info("AggregationApplication started");
    }
}
