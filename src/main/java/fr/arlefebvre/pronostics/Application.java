/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Arthur Lefebvre
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package fr.arlefebvre.pronostics;


import fr.arlefebvre.pronostics.model.Account;
import fr.arlefebvre.pronostics.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()//.antMatchers("/").permitAll()
                    .antMatchers(
                            "/teams.html",
                            "/menu.html"
                    ).authenticated()
                    //.anyRequest().authenticated()
                    .and().logout().logoutUrl("/logout").logoutSuccessUrl("/index.html").clearAuthentication(true).permitAll()
                    .and().formLogin().loginPage("/index.html").permitAll().defaultSuccessUrl("/menu.html")
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
                    Account account = accountRepository.findByLogin(username);
                    if(account != null) {
                    return new User(account.getLogin(), account.getPassword(), true, true, true, true,
                            AuthorityUtils.createAuthorityList("USER"));
                    } else {
                        throw new UsernameNotFoundException("could not find the user '"
                               + username + "'");
                    }
                }

            };
        }
    }

}
