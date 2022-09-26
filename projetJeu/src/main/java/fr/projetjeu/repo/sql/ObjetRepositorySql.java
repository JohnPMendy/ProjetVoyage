package fr.projetjeu.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.projetjeu.model.Events;
import fr.projetjeu.model.Objet;
import fr.projetjeu.model.Reponse;
import fr.projetjeu.model.TypeObjets;
import fr.projetjeu.repo.IObjetRepository;

public class ObjetRepositorySql extends AbstractRepositorySql<Objet> implements IObjetRepository{

	@Override
	protected Objet map(ResultSet result) {
		try {
			// Pour chaque résultat, il faudra créer un nouveau Fournisseur
			Objet monObjet = new Objet();
			
			// On associe toutes les infos du fournisseur
			monObjet.setId(result.getInt("obj_id") );
			monObjet.setNom( result.getString("obj_nom") );
			monObjet.setTypeObjetAlimentaire(result.getBoolean("obj_type_alimentaire"));
			monObjet.setPrix(result.getFloat("obj_prix"));
			//monObjet.setTypeObjets(TypeObjets.valueOf(result.getString("obj_type")));
			monObjet.setTypeObjets(TypeObjets.values()[result.getInt("obj_type")]);
			monObjet.setQuantiteBoutique(result.getInt("obj_quantite_boutique"));
			monObjet.setQuantiteInventaire(result.getInt("obj_quantite_inventaire"));
			monObjet.getBoutique().setId(result.getInt("obj_boutique_id"));
			monObjet.getInventaire().setId(result.getInt("obj_inventaire_id"));

			return monObjet;
		}
		
		catch (SQLException e) {
			return null;
		}
	}

	
	public void save(Objet entity) {
		PreparedStatement myStatement = null;
		try {
			if(entity.getId()==0) {
				myStatement = this.prepare("INSERT INTO objet(obj_nom,obj_type_alimentaire,obj_prix,obj_type,obj_quantite_boutique,obj_quantite_inventaire,obj_boutique_id,obj_inventaire_id) VALUES (?,?,?,?,?,?,?,?)");	
			}
			else {//update
				myStatement = this.prepare("UPDATE objet SET "
						+"obj_nom = ?, "
						+"obj_type_alimentaire=?,"
						+"obj_prix=? ,"
						+"obj_type=?,"
						+"obj_quantite_boutique= ?, "
						+"obj_quantite_inventaire=? ,"
						+"obj_boutique_id=?,"
						+"obj_inventaire_id=?"
						+"WHERE obj_id = ?");
				myStatement.setInt(9, entity.getId());
			}
			myStatement.setString  (1, entity.getNom());
			myStatement.setBoolean (2, entity.getTypeObjetAlimentaire());
			myStatement.setFloat(3, entity.getPrix());
			myStatement.setInt(4, entity.getTypeObjets().ordinal());
			myStatement.setInt(5, entity.getQuantiteBoutique());
			myStatement.setInt(6, entity.getQuantiteInventaire());
			myStatement.setInt(7, entity.getBoutique().getId());
			myStatement.setInt(8, entity.getInventaire().getId());

			myStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
	}

	public List<Objet> findAll() {
		List<Objet> objets = new ArrayList<>();
		
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM objet");
			ResultSet myResult = myStatement.executeQuery();
			
			while (myResult.next()) {
				objets.add(this.map(myResult));
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace(); // On le laisse en dév | TODO : à supprimer plus tard
		}
		
		finally {
			this.disconnect();
		}
		
		return objets;
	}
	
	
	public List<Objet> findAllByInventaireId(int id) {
		List<Objet> objets = new ArrayList<>();
		
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM objet, inventaire where inv_id=? ");
			myStatement.setInt(1, id);
			ResultSet myResult = myStatement.executeQuery();

			
			while (myResult.next()) {
				objets.add(this.map(myResult));
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace(); // On le laisse en dév | TODO : à supprimer plus tard
		}
		
		finally {
			this.disconnect();
		}
		
		return objets;
	}

	
	public List<Objet> findAllByBoutiqueId(int id) {
		List<Objet> objets = new ArrayList<>();
		
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM objet, boutique where btq_id=? ");
			myStatement.setInt(1, id);
			ResultSet myResult = myStatement.executeQuery();

			
			while (myResult.next()) {
				objets.add(this.map(myResult));
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace(); // On le laisse en dév | TODO : à supprimer plus tard
		}
		
		finally {
			this.disconnect();
		}
		
		return objets;
	}

	@Override
	public Objet findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}



}


