/**
 * 
 */
package edu.sollers.components;

import java.sql.SQLException;
import java.sql.Statement;

import edu.sollers.mvc.ResumeElement;

/**
 * @author Karanveer
 *
 */
public class Membership extends ResumeElement {
	private String membership;

	/**
	 * Constructor with parameter
	 * 
	 * @param membership String
	 */
	public Membership(String membership) {
		this.membership = membership;
	}

	// Static methods cannot be overridden

	public static String getTableName() {
		return "membership";
	}

	public static String getFieldOrder() {
		return "membership";
	}

	public static String getSelectClause() {
		return "select " + getFieldOrder() + " from " + getTableName();
	}

	@Override
	public String getInsertStatement() {
		return "insert into " + getTableName() + " (" + getFieldOrder() + ") values ('" + membership + "')";
	}

	@Override
	public void save() {
		try {
			Statement stmt = getConnection().createStatement();
			int row = stmt.executeUpdate(getInsertStatement());
			if (row == 1)
				System.out.println("Inserted membership object into table");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the membership
	 */
	public String getMembership() {
		return membership;
	}

	@Override
	public String toString() {
		return "Membership: " + membership + "\n";
	}

}
