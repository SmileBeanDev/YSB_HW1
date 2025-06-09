package dev.smilebean.ysb_hw1.confg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.security.PublicKey;

@Configuration
public class DatabaseLogger {
    @Autowired
    private DataSource dataSource;

    @Bean
    public ApplicationRunner logDatabaseConnectionInfo() {
        return args -> {
            System.out.println("🔌 Connected to Database: " + dataSource.getConnection().getMetaData().getURL());
            System.out.println("👤 DB Username: " + dataSource.getConnection().getMetaData().getUserName());
            System.out.println("🛠 DB Driver: " + dataSource.getConnection().getMetaData().getDriverName());
        };
    }
}
