package tr.gov.adalet.demo.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.stream.Stream;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    private String principalRequestHeader;
    private String principalRequestToken;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        ApiKeyAuthFilter authFilter = new ApiKeyAuthFilter(principalRequestHeader);
        authFilter.setAuthenticationManager(new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String principal = (String) authentication.getPrincipal();
                if (!principalRequestToken.equals(principal)) {
                    throw new BadCredentialsException("Geçersiz Api Key Değeri!");
                }
                authentication.setAuthenticated(true);
                return authentication;
            }

        });

        httpSecurity.antMatcher("/mahkeme/**")
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(authFilter)
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated();
    }

    private Stream<String> swaggerurls() {
        return Stream.of("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/security", "/h2-console/**",
                "h2-console/**", "/swagger-ui.html", "/swagger-ui/**", "/webjars/**");
    }
}
