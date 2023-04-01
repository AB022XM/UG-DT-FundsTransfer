package ug.co.absa.transfer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import ug.co.absa.transfer.FundsTransferApiGenericApp;
import ug.co.absa.transfer.config.AsyncSyncConfiguration;
import ug.co.absa.transfer.config.EmbeddedElasticsearch;
import ug.co.absa.transfer.config.EmbeddedKafka;
import ug.co.absa.transfer.config.EmbeddedRedis;
import ug.co.absa.transfer.config.EmbeddedSQL;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { FundsTransferApiGenericApp.class, AsyncSyncConfiguration.class })
@EmbeddedRedis
@EmbeddedElasticsearch
@EmbeddedKafka
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public @interface IntegrationTest {
}
