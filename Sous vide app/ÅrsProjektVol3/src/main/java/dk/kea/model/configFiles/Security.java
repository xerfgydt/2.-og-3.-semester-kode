package dk.kea.model.configFiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import dk.kea.model.entities.User;

    @Configuration
    @EnableWebSecurity
    public class Security extends WebSecurityConfigurerAdapter {

        User u = new User();


        @Autowired //her definere vi hvem der skal identificeres og hvilken rolle de skal have
        public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
                throws Exception {
            auth.inMemoryAuthentication().withUser(u.getName()).password(u.getPassword())
                    .roles(u.getRole());

        }


        @Override
        protected void configure(HttpSecurity http) throws Exception //Throws smider answaret videre til den der kalder metoden
        {
            http.authorizeRequests()
                    // her difineres login url
                    .antMatchers("/login").permitAll()
                    // her defineres hvilke html sites der IKKE må tilgås uden et login og den rigtige rolle
                    .antMatchers("/*oste*/**","/*mad*/**","/*homepage*/**").access("hasRole('USER')").and()
                    // HVIS DU IKKE HAR DEN RIGTIGE ROLLE BLIVER MAN SENDT TIL .formlogin()
                    .formLogin()
                    //Start siden efter login
                    .defaultSuccessUrl("/homepage.html").and().exceptionHandling()
                    .accessDeniedPage("/access-denied");


        }





    }
