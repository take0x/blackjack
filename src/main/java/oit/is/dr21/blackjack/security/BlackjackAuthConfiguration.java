package oit.is.dr21.blackjack.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class BlackjackAuthConfiguration {
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {

    UserBuilder users = User.builder();

    // $ sshrun htpasswd -nbBC 10 user1 p@ss
    UserDetails user1 = users
        .username("user1")
        .password("$2y$10$DP969EOL8QL8Va6DzZZbuetdR0W3bkQYN6nFO0EyL8B830GicQhpm")
        .roles("USER")
        .build();
    UserDetails user2 = users
        .username("user2")
        .password("$2y$10$5HVv2dGidJAB7gGhrDbK5Oq4FE8utKchpQCgeAfhgWUIWOKcImh6W")
        .roles("USER")
        .build();
    UserDetails user3 = users
        .username("user3")
        .password("$2y$10$UBp2wV615QjK.JfZHjcrme.naCEIrN06i/OUusbemopyYXQWSS/YC")
        .roles("USER")
        .build();
    UserDetails user4 = users
        .username("user4")
        .password("$2y$10$xH62ObyBg99j8/nXvFrKgurDywKocZ05Gm2/y7fN0IBjg3IQNAc0m")
        .roles("USER")
        .build();
    UserDetails user5 = users
        .username("user5")
        .password("$2y$10$ZEJ.G35WZBYRjlh6QTC3BO7eq5/gNLMis/wzV7d1Q7XfByHCibb6C")
        .roles("USER")
        .build();
    UserDetails user6 = users
        .username("user6")
        .password("$2y$10$g2ABxk3/KEI3hEE.aH5V7e0QirNXncPAHVl4NrJxD/rjgixTOLtlq")
        .roles("USER")
        .build();
    UserDetails admin = users
        .username("admin")
        .password("$2y$10$Rv3qxlWjPjqCoTJO6gLRxORrlstRFXsS3NiaZmSV0zbJarN6NQjHi")
        .roles("ADMIN")
        .build();
    return new InMemoryUserDetailsManager(user1, user2, user3, user4, user5, user6, admin);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.formLogin();
    http.authorizeHttpRequests()
        .mvcMatchers("/blackjack/**").authenticated();
    http.logout().logoutSuccessUrl("/");
    // http.csrf().disable();
    // http.headers().frameOptions().disable();
    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
