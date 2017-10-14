package spring.boot;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * The Class HealthCheck. http://www.baeldung.com/spring-boot-actuators
 */
@Component
public class HealthCheck implements HealthIndicator {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.boot.actuate.health.HealthIndicator#health()
     */
    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    /**
     * Check.
     *
     * @return the int
     */
    public int check() {
        // Your logic to check health
        return 1;
    }
}