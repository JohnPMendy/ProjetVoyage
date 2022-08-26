package fr.projetjeu.repo.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.projetjeu.model.Events;
import fr.projetjeu.repo.IEventRepository;

public class EventsRepositorySql extends AbstractRepositorySql<Events> implements IEventRepository {

	@Override
	public List<Events> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Events findById(int id) {
		try {
			PreparedStatement myStatement = this.prepare("SELECT * FROM evenement WHERE evt_id = ?");
			myStatement.setInt(1, id);
			ResultSet myResult = myStatement.executeQuery();
			
			Events monEvent =null;
			
			if(myResult.next()) {
				monEvent =this.map(myResult);
			}
			return monEvent;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {
			this.disconnect();
		}
		
		
		// TODO Auto-generated method stub
	}

	@Override
	public void save(Events entity) {
		PreparedStatement myStatement = null;
		try {
			if(entity.getId()==0) {
				myStatement = this.prepare("INSERT INTO evenement(evt_histoire) VALUES (?)");	
			}
			else {
				myStatement = this.prepare("UPDATE evenement SET evt_histoire= ? WHERE evt_id=?");
				myStatement.setInt(2, entity.getId());
			}
			myStatement.setString(1, entity.getHistoire());
			myStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	@Override
	protected Events map(ResultSet result) {
		try {
			Events event = new Events();
			event.setId(result.getInt("evt_id"));
			event.setHistoire(result.getString("evt_histoire"));
			event.setReponse(new ArrayList<>());
			return event; 
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
	}

}
