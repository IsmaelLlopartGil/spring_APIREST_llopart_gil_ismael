package s05t02n01_llopart_gil_ismael.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private final UserDetailsService userDetailsService;
	
	@Autowired
	private final JwtAuthorizationFilter jwtAuthorizationFilter;
	
	
	public SecurityConfiguration(UserDetailsService userDetailsService, JwtAuthorizationFilter jwtAuthorizationFilter) {
		this.userDetailsService = userDetailsService;
		this.jwtAuthorizationFilter = jwtAuthorizationFilter;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
		
		JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();
		jwtAuthenticationFilter.setAuthenticationManager(authManager);
	//	jwtAuthenticationFilter.setFilterProcessesUrl("/login");
		
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/jocdelset", "/jocdelset/**").permitAll()
				.requestMatchers("/images/**", "/**").permitAll()
				.requestMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated())
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.formLogin(withDefaults())
				.logout().logoutSuccessUrl("/jocdelset")
				.and()
				.addFilter(jwtAuthenticationFilter)
				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	/*
	 * @Bean public UserDetailsService userDetailsService() {
	 * InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	 * manager.createUser(User.withUsername("admin")
	 * .password(passwordEncoder().encode("admin")) .roles("ADMIN") .build());
	 * 
	 * manager.createUser(User.withUsername("anonymous")
	 * .password(passwordEncoder().encode("anonymous")) .roles("USER") .build());
	 * 
	 * return manager; }
	 */

	
	@Bean 
	public AuthenticationManager authManager (HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
		.userDetailsService(userDetailsService) 
		.passwordEncoder(passwordEncoder())
		.and() 
		.build();  
		}
	  
		
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception {
	 */

	/*
	 * http.anonymous();
	 * http.authorizeHttpRequests().requestMatchers("/jocdelset").permitAll();
	 * http.authorizeHttpRequests().requestMatchers("/login").permitAll();
	 * http.authorizeHttpRequests().requestMatchers("/loginerror").permitAll();
	 * http.authorizeHttpRequests().anyRequest().authenticated();
	 * 
	 * 
	 * 
	 * http.formLogin().loginPage("/login");
	 * http.formLogin().usernameParameter("username");
	 * http.formLogin().passwordParameter("password");
	 * http.formLogin().defaultSuccessUrl("/players");
	 * http.formLogin().failureUrl("/loginerror");
	 * 
	 * http.logout().logoutUrl("/logout");
	 * http.logout().logoutSuccessUrl("/jocdelset");
	 * 
	 * http.csrf().disable();
	 * 
	 * return http.build();
	 */

	/*
	 * return http .csrf().disable() .authorizeHttpRequests()
	 * .requestMatchers("/socdelset") .hasRole("ROLE_SOMETHING") .anyRequest()
	 * .denyAll() .and() .httpBasic() .and() .sessionManagement()
	 * .sessionCreationPolicy(SessionCreationPolicy.ALWAYS) .and() .build();
	 */
	/*
	 * }
	 */



	

	 



}
