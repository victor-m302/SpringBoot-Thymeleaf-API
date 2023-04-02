package com.ifrs17.bradseg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ifrs17.bradseg.dominio.PerfilTipo;
import com.ifrs17.bradseg.service.UsuarioService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String ADMIN = PerfilTipo.ADMIN.getDesc();
    private static final String MEDICO = PerfilTipo.MEDICO.getDesc();
    private static final String PACIENTE = PerfilTipo.PACIENTE.getDesc();
	
    //NOVOS USERS
    private static final String ANALISTA = PerfilTipo.ANALISTA.getDesc();
    private static final String CONSULTA = PerfilTipo.CONSULTA.getDesc();
	
    
    
	@Autowired
	private UsuarioService service;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			// acessos públicos liberados
			.antMatchers("/info/**").permitAll()
			.antMatchers("/analistas/**").permitAll()
			
			.antMatchers("/webjars/**", "/css/**", "/image/**", "/js/**").permitAll()
			.antMatchers("/", "/home").permitAll()
			

			
			// acessos privados admin
			.antMatchers("/u/editar/senha", "/u/confirmar/senha").hasAnyAuthority(PACIENTE, MEDICO)
			.antMatchers("/u/**").hasAuthority(ADMIN)
			
			// acessos privados medicos
			.antMatchers("/medicos/especialidade/titulo/*").hasAnyAuthority(PACIENTE, MEDICO)
			.antMatchers("/medicos/dados", "/medicos/salvar", "/medicos/editar").hasAnyAuthority(MEDICO, ADMIN)
			.antMatchers("/medicos/**").hasAuthority(MEDICO)
			
			// acessos privados pacientes
			.antMatchers("/pacientes/**").hasAuthority(PACIENTE)	
		
			// acessos privados especialidades
			.antMatchers("/especialidades/datatables/server/medico/*").hasAnyAuthority(MEDICO, ADMIN)
			.antMatchers("/especialidades/titulo").hasAnyAuthority(MEDICO, ADMIN, PACIENTE)
			.antMatchers("/especialidades/**").hasAuthority(ADMIN)
			
			// novos users
			
			
			// acessos privados analistas
			//.antMatchers("/analistas/**").hasAuthority(ANALISTA)	
			
			
			// acessos privados analistas
			.antMatchers("/consultas/**").hasAuthority(CONSULTA)	
			
					
			
			.anyRequest().authenticated()
			.and()
				.formLogin()
				//.loginPage("/login")
				.defaultSuccessUrl("/", true)
				.failureUrl("/login-error")
				.permitAll()
			.and()
				.logout()
				.logoutSuccessUrl("/")
			.and()
				.exceptionHandling()
				.accessDeniedPage("/acesso-negado");
		
		//.csrf().disable() //.formLogin().disable()
		
		System.out.println("SecurityConfig 0001");
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
		System.out.println("SecurityConfig 0002");
	}
	
	

}
