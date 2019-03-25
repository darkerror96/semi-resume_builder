/**
 * 
 */
package edu.sollers.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.sollers.mvc.ResumeElement;

/**
 * @author Karanveer
 *
 */
public class Objective extends ResumeElement {
	private String objective;

	/**
	 * Constructor with parameter
	 * 
	 * @param objective String
	 */
	public Objective(String objective) {
		this.objective = objective;
	}

	// Static methods cannot be overridden

	public static String getTableName() {
		return "objective";
	}

	public static String getFieldOrder() {
		return "objective";
	}

	public static String getSelectClause() {
		return "select " + getFieldOrder() + " from " + getTableName();
	}

	@Override
	public String getInsertStatement() {
		return "insert into " + getTableName() + " (" + getFieldOrder() + ") values ('" + objective + "')";
	}

	@Override
	public String getUpdateStatement() {
		return "update " + getTableName() + " set objective=" + objective;
	}

	@Override
	public void save() {
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT count(objective) FROM objective");
			rs.next();
			if (rs.getInt(1) == 0) {

				// no objective row, so INSERT
				int row = stmt.executeUpdate(getInsertStatement());
				if (row == 1)
					System.out.println("Inserted Objective object into table");
			} else {

				// row exists, so UPDATE
				int row = stmt.executeUpdate(getUpdateStatement());
				if (row == 1)
					System.out.println("Updated Objective object in table");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the objective
	 */
	public String getObjective() {
		return objective;
	}

	@Override
	public String toString() {
		return "Objective: " + objective + "\n";
	}
}
