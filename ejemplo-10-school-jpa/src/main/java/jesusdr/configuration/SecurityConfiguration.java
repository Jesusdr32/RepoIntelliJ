package jesusdr.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth.requestMatchers("/h2-console", "/h2-console/*").permitAll())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/students", "/students/").permitAll())
                // .authorizeHttpRequests(auth-> auth.requestMatchers("/students", "/students/").authenticated())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/teachers", "/teachers/*").permitAll())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                //.httpBasic(Customizer.withDefaults());
                .csrf(csrf -> csrf.ignoringRequestMatchers("/teachers/*", "/h2-console/*"))
                .headers(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults());

        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new  BCryptPasswordEncoder();
    }
}
