package fr.projetjeu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.projetjeu.repo.ICompteRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private ICompteRepository compteRepo;
	
	//charge à partir d'un username (recupere par un formulaire ou ????) un object UserDetails(Utilisateur pour Spring)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return compteRepo.findByLogin(username).orElseThrow(()->{
			throw new UsernameNotFoundException("utilisateur inconnu");
		});
	}

}
