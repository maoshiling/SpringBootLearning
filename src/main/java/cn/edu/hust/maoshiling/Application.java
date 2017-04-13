package cn.edu.hust.maoshiling;
/**
 * Created by 15352 on 2017/4/6.
 */
import cn.edu.hust.maoshiling.auditor.AuditorDateTimeProvider;
import cn.edu.hust.maoshiling.auditor.SpringSecurityAuditorAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "cn.edu.hust.maoshiling.repository")
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider",auditorAwareRef = "auditorProvider")
@EntityScan(basePackages = "cn.edu.hust.maoshiling.entity",basePackageClasses = {Jsr310JpaConverters.class})
public class Application {

    @Bean
    AuditorAware<String> auditorProvider() {
        return new SpringSecurityAuditorAware();
    }

    @Bean
    DateTimeProvider dateTimeProvider() {
        return new AuditorDateTimeProvider();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application .class, args);
    }
}
