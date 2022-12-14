package fr.projetjeu.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "compte")
public class Compte implements UserDetails {
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonView(JsonViews.Common.class)
	@Column(name = "login", nullable = false, unique = true, length = 50)
	private String login;
	
	@JsonView(JsonViews.Common.class)
	@Column(name = "role", nullable = false, length = 50)
	private String role;
	
	@Column(name = "mdp", nullable = false)
	private String mdp;
	
	@JsonIgnore
	@OneToMany(mappedBy="compte")
	private List<Partie> parties;

	// private boolean banni=false;
	public Compte() {

	}

	
	public Compte(String login, String role, String mdp) {
		super();
		this.login = login;
		this.role = role;
		this.mdp = mdp;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	
	public List<Partie> getParties() {
		return parties;
	}


	public void setParties(List<Partie> parties) {
		this.parties = parties;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Role de l'utilisateur
		// pour spring 1 role =>objet de type GrantedAuthority
		// SimpleGrantedAuthority => permet de construire un GrantedAuthority ?? partir d'un string
//		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority(role));
//		return authorities;
		
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}

	@Override
	public String getPassword() {
		// propriete ?? associer au Password pour spring
		return mdp;
	}

	@Override
	public String getUsername() {
		// propriete ?? associer au Username pour spring security
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// expiration dans le temps
		// true=>compte valide
		// false=>compte expir??
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// verouillage du compte
		// true=>non verouill??
		// false=>verouill??
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// la duree de vie du mot de passe
		return true;
	}

	@Override
	public boolean isEnabled() {
		// false=>compte d'activ??
		// true=>compte activ??
		// return !banni;
		return true;
	}

}
