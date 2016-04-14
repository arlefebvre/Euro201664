package fr.arlefebvre.pronostics;


import fr.arlefebvre.pronostics.model.Account;
import fr.arlefebvre.pronostics.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Arthur on 05/04/2016.
 */
@SpringBootApplication
public class Application {

    // Start mongo : mongod.exe --dbpath d:\test\mongodb\data

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }


    @EnableWebSecurity
    @Configuration
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//        @Override
//        public void init(WebSecurity web) throws Exception{
//            web.ignoring().antMatchers("/");
//        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()//.antMatchers("/").permitAll()
                    .antMatchers("/teams.html").authenticated()
                    //.anyRequest().authenticated()
                    .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").clearAuthentication(true).permitAll()
                    .and().formLogin().loginPage("/index.html").permitAll().defaultSuccessUrl("/login.html")
                    .and().csrf().disable();
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService());
        }

        @Autowired
        AccountRepository accountRepository;

        @Override
        protected UserDetailsService userDetailsService() {
            return new UserDetailsService() {

                @Override
                public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                    //Account account = accountRepository.findByLogin(username);
                    //if(account != null) {
                    return new User(username, "", true, true, true, true,
                            AuthorityUtils.createAuthorityList("USER"));
                    //} else {
                    //    throw new UsernameNotFoundException("could not find the user '"
                    //           + username + "'");
                    //}
                }

            };
        }
    }

}
