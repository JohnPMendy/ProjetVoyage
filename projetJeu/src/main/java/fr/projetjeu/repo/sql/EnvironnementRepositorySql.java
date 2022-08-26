package fr.projetjeu.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.projetjeu.model.Environnement;
import fr.projetjeu.model.Meteo;
import fr.projetjeu.model.TypeEnvironnement;
import fr.projetjeu.repo.IEnvironnementRepository;

public class EnvironnementRepositorySql extends AbstractRepositorySql<Environnement> implements IEnvironnementRepository {

	@Override
	public List<Environnement> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environnement findById(int id) {
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM environnement WHERE env_id = ?");
			myStatement.setInt(1,id);
			ResultSet myResult = myStatement.executeQuery();
			
			Environnement monEnvironnement = null;
			
			if(myResult.next()) {
				monEnvironnement = this.map(myResult);
			}
			return monEnvironnement;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {
			this.disconnect();
		}
		
	}

	@Override
	public void save(Environnement entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Environnement map(ResultSet result) {
		try {
			Environnement env = new Environnement();
			env.setId(result.getInt("env_id"));
			env.setTemperature(result.getFloat("env_temperature"));
			env.setEnvironnement(TypeEnvironnement.valueOf(result.getString("env_type_environnement")));
			env.setMeteo(Meteo.valueOf(result.getString("env_type_meteo")));
			return env;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
}
