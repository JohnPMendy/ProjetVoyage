package fr.projetjeu.repo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractRepositorySql<T> {
protected Connection connection = null;
	
	protected Connection connect() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/projet", "postgres", SqlProperties.getMdp());
		
		return this.connection;
	}
	
	protected PreparedStatement prepare(String query) throws SQLException {
		return this.connect().prepareStatement(query);
	}
	
	protected void disconnect() {
		if (this.connection != null) {
			try {
				this.connection.close();
			}
			
			catch (SQLException e) {
				System.out.println("La déconnexion n'a pas fonctionné.");
			}
		}
	}
	
	protected abstract T map(ResultSet result);
}
