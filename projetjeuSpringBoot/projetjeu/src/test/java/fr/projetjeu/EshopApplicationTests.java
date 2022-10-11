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
		Compte admin1 =new Compte("admin@gmail.com","ROLE_ADMIN",passwordEncoder.encode("admin"));
		compteRepo.save(admin1);
		Compte user1=new Compte("user@gmail.com", "ROLE_USER", passwordEncoder.encode("user"));
		compteRepo.save(user1);
	}

}
