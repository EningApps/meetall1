package meetall.com.meetall1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Meetall1Application {

    public static void main(String[] args) {
        SpringApplication.run(Meetall1Application.class, args);
    }
}
