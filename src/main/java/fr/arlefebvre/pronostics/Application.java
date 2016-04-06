package fr.arlefebvre.pronostics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Arthur on 05/04/2016.
 */
@SpringBootApplication
public class Application {

    // Start mongo : mongod.exe --dbpath d:\test\mongodb\data

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
