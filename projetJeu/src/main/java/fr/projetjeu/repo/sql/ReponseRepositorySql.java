package fr.projetjeu.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.projetjeu.model.Reponse;
import fr.projetjeu.repo.IReponseRepository;


public class ReponseRepositorySql extends AbstractRepositorySql<Reponse> implements IReponseRepository{
	


	@Override
	protected Reponse map(ResultSet result) {
		Reponse myReponse = new Reponse();
		
		try {
			myReponse.setTexte(result.getString("rep_texte"));
			myReponse.setEvenementId(result.getInt("rep_evenement_id"));
			myReponse.setProchainEvenementId(result.getInt("rep_prochain_evenement_id"));
			
			return myReponse;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
		
	}
	//Selection de reponses en fonction de leur id d'origine
	public List<Reponse> findByEvenementId(int id){
		List<Reponse> reponses = new ArrayList<>();
		
		try {
			
			String query = "SELECT * FROM reponse WHERE rep_evenement_id = ?";
			
			PreparedStatement myStatement = this.prepare(query);
			myStatement.setInt(1,id);
			
			ResultSet myResult = myStatement.executeQuery();
			
			while(myResult.next()) {
				reponses.add(this.map(myResult));
				
			}
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		return reponses;
		
	}

	@Override
	public List<Reponse> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reponse findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Reponse entity) {
		try {
			
		
			if (entity.getId() == 0)
				//Insert reponse
			{
			String query = ("INSERT INTO reponse (rep_texte, rep_evenement_id, rep_prochain_evenement_id) values (?, ?, ?)");
			PreparedStatement myStatement = prepare(query);
			
			myStatement.setString(1, entity.getTexte());
			myStatement.setInt(2, entity.getEvenementId());
			myStatement.setInt(3, entity.getProchainEvenementId());
			
			myStatement.executeUpdate();
			
			
			}
			else {
				//Update
				String query = "UPDATE reponse SET rep_texte= ?, "
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}



}
