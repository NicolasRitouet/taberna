package io.taberna;

import com.codahale.metrics.health.HealthCheck;

public class TabernaHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
