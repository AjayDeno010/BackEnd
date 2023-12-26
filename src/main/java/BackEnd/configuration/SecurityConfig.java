package BackEnd.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeHttpRequests((authorize) -> {
            authorize.requestMatchers(HttpMethod.POST, "/api/**").hasRole("admin");
              authorize.anyRequest().authenticated();
        }).httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return  configuration.getAuthenticationManager();

    }
//    @Bean
//    public UserDetailsService userDetailsService(){
//       UserDetails ADMIN= User.builder().username("Ajay")
////                 .password("Ajay").roles("ADMIN").build();
//               .password(passwordEncoder().encode("Ajay")).roles("ADMIN").build();
//      UserDetails USER=  User.builder().username("User")
////              .password("User").roles("USER").build();
//              .password(passwordEncoder().encode("User")).roles("USER").build();
//     return new InMemoryUserDetailsManager(ADMIN,USER);
//    }

}

