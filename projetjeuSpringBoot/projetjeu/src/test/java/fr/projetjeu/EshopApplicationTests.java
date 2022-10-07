package fr.projetjeu;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import fr.projetjeu.model.Compte;
import fr.projetjeu.repo.ICompteRepository;


@SpringBootTest
class EshopApplicationTests {

	@Autowired
	private ICompteRepository compteRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	@Transactional
	@Commit
	void initUser() {
		Compte admin =new Compte("admin","ROLE_ADMIN",passwordEncoder.encode("admin"));
		compteRepo.save(admin);
		Compte user=new Compte("user", "ROLE_USER", passwordEncoder.encode("user"));
		compteRepo.save(user);
	}

}
