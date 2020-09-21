package com.dts.rentgameapi.config;

import com.dts.rentgameapi.RentConstant;
import com.dts.rentgameapi.security.*;
import com.dts.rentgameapi.security.login.JwtAuthenticationLoginProvider;
import com.dts.rentgameapi.security.match.MatchLoginRegister;
import com.dts.rentgameapi.security.match.SkipPathRequestMatcher;
import com.dts.rentgameapi.security.register.JwtRegisterProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rin-DTS
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationEntryPoint entryPoint;

    @Autowired
    private JwtAuthenticationLoginRegisterSuccessHandler jwtAuthenticationLoginRegisterSuccessHandler;

    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Autowired
    private JwtRegisterProvider jwtRegisterProvider;

    @Autowired
    private JwtAuthenticationLoginProvider jwtAuthenticationLoginProvider;


    @Autowired
    private ObjectMapper objectMapper;


//    @Bean
//    public AuthenticationManager authenticationManager() {
//        return new ProviderManager(Arrays.asList(jwtAuthenticationProvider,
//                jwtRegisterProvider, jwtAuthenticationLoginProvider));
//    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(jwtAuthenticationProvider);
        auth.authenticationProvider(jwtRegisterProvider);
        auth.authenticationProvider(jwtAuthenticationLoginProvider);
    }

    protected JwtLoginRegisterProcessingFilter jwtLoginRegisterProcessingFilter() {
        List<String> matchs = new ArrayList<>();
        matchs.add(RentConstant.ENPOINT_LOGIN);
        matchs.add(RentConstant.ENPOINT_REGISTER);
        MatchLoginRegister matchLoginRegister = new MatchLoginRegister(matchs);
        JwtLoginRegisterProcessingFilter filter =
                new JwtLoginRegisterProcessingFilter(matchLoginRegister,
                        jwtAuthenticationLoginRegisterSuccessHandler,
                        new JwtAuthenticationLoginRegisterFailureHandler(objectMapper),
                        objectMapper);
        try {
            filter.setAuthenticationManager(authenticationManagerBean());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filter;
    }


    protected JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        List<String> listNotmap = new ArrayList<>();
        listNotmap.add(RentConstant.ENPOINT_LOGIN);
        listNotmap.add(RentConstant.ENPOINT_REGISTER);
        listNotmap.add(RentConstant.ENPOINT_MATCH_API);
        RequestMatcher matcher = new SkipPathRequestMatcher(listNotmap, RentConstant.ENPOINT_MATCH_AUTH_API);
        JwtAuthenticationTokenFilter filter =
                new JwtAuthenticationTokenFilter(matcher);
        try {
            filter.setAuthenticationManager(authenticationManagerBean());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new
                UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // http.cors().and();
        // http.cors().and();
        http.csrf().disable().cors().and()
                .exceptionHandling()
                .authenticationEntryPoint(entryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers(RentConstant.ENPOINT_LOGIN, RentConstant.ENPOINT_LOGIN).permitAll() // Login end-point
                .and().authorizeRequests()
                .antMatchers(RentConstant.ENPOINT_MATCH_AUTH_API).authenticated()
                .and().authorizeRequests()
                .antMatchers(RentConstant.ENPOINT_MATCH_API).permitAll()
                .and()
                .addFilterBefore(jwtLoginRegisterProcessingFilter(),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthenticationTokenFilter(),
                        UsernamePasswordAuthenticationFilter.class);

    }

}
