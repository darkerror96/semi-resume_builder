package edu.sollers.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.sollers.mvc.ResumeElement;

// extends the ResumeElement class
public class Summary extends ResumeElement {
	private String summary;

	/**
	 * Constructor with parameter
	 * 
	 * @param summary String
	 */
	public Summary(String summary) {
		this.summary = summary;
	}

	// Static methods cannot be overridden

	public static String getTableName() {
		return "summary";
	}

	public static String getFieldOrder() {
		return "summary";
	}

	public static String getSelectClause() {
		return "select " + getFieldOrder() + " from " + getTableName();
	}

	@Override
	public String getInsertStatement() {
		return "insert into " + getTableName() + " (" + getFieldOrder() + ") values ('" + summary + "')";
	}

	@Override
	public String getUpdateStatement() {
		return "update " + getTableName() + " set summary=" + summary;
	}

	@Override
	public void save() {
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT count(summary) FROM summary");
			rs.next();
			if (rs.getInt(1) == 0) {

				// no summary row, so INSERT
				int row = stmt.executeUpdate(getInsertStatement());
				if (row == 1)
					System.out.println("Inserted Summary object into table");
			} else {

				// row exists, so UPDATE
				int row = stmt.executeUpdate(getUpdateStatement());
				if (row == 1)
					System.out.println("Updated Summary object in table");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * Return string representation of object
	 */
	@Override
	public String toString() {
		return "Summary: " + summary + "\n";
	}
}
