package pl.stepwise.micronaut.hibernate.demo.config;

import javax.inject.Singleton;
import java.sql.SQLException;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Requires;
import org.h2.tools.Server;

@Factory
public class BootstrapFactory {

    @Context
    @Bean(preDestroy = "stop")
    @Singleton
    @Requires(property = "h2.console.enabled", value = "true")
    public Server h2WebServer() throws SQLException {
        return Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
    }
}