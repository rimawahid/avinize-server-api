package bd.com.deepsense.avinize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvinizeAppServerApiApplication {
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(AvinizeAppServerApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AvinizeAppServerApiApplication.class, args);
		LOG.info("\n\nAvinize Server Api Successfully Running\n\n http://localhost:9201/swagger-ui/index.html \n\n");
	}
}
