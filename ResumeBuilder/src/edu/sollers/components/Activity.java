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
public class Activity extends ResumeElement {
	private String activity;

	/**
	 * Constructor with parameter
	 * 
	 * @param membership String
	 */
	public Activity(String activity) {
		this.activity = activity;
	}

	// Static methods cannot be overridden

	public static String getTableName() {
		return "activity";
	}

	public static String getFieldOrder() {
		return "activity";
	}

	public static String getSelectClause() {
		return "select " + getFieldOrder() + " from " + getTableName();
	}

	@Override
	public String getInsertStatement() {
		return "insert into " + getTableName() + " (" + getFieldOrder() + ") values ('" + activity + "')";
	}

	@Override
	public void save() {
		try {
			Statement stmt = getConnection().createStatement();
			int row = stmt.executeUpdate(getInsertStatement());
			if (row == 1)
				System.out.println("Inserted activity object into table");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the activity
	 */
	public String getActivity() {
		return activity;
	}

	@Override
	public String toString() {
		return "Activity: " + activity + "\n";
	}

}
