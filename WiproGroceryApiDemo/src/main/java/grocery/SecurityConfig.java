package grocery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/grocery/public").permitAll() 
	                .anyRequest().authenticated()                  
	            )
	            .httpBasic(Customizer.withDefaults())              
	            .csrf(csrf -> csrf.disable());                     

	        return http.build();
	    }
	 @Bean
	    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
	        UserDetails user = User.withUsername("user")
	                .password(passwordEncoder.encode("password"))
	                .roles("USER")
	                .build();

	        UserDetails admin = User.withUsername("admin")
	                .password(passwordEncoder.encode("adminpass"))
	                .roles("ADMIN")
	                .build();

	        return new InMemoryUserDetailsManager(user, admin);
	    }
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

}
