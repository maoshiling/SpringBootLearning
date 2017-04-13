package cn.edu.hust.maoshiling;

import cn.edu.hust.maoshiling.auditor.AuditorDateTimeProvider;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by 15352 on 2017/4/13.
 */
@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "cn.edu.hust.maoshiling.repository")
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider",auditorAwareRef = "auditorProvider")
@EntityScan(basePackages = "cn.edu.hust.maoshiling.entity",basePackageClasses = {Jsr310JpaConverters.class})
public class ApplicationTest {
    @Bean
    AuditorAware<String> auditorProvider() {
        return ()->"admin";
    }

    @Bean
    DateTimeProvider dateTimeProvider() {
        return new AuditorDateTimeProvider();
    }
}
