package edu.sollers.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.sollers.mvc.ResumeElement;

/**
 * @author rutpatel
 */

public class Publication extends ResumeElement {

	private String authName;
	private String title;
	private int year;
	private String summary;

	/**
	 * @param authName
	 * @param title
	 * @param year
	 * @param summary
	 */
	public Publication(String authName, String title, int year, String summary) {
		this.authName = authName;
		this.title = title;
		this.year = year;
		this.summary = summary;
	}

	/**
	 * @return the authName
	 */
	public String getAuthName() {
		return authName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	public static String getFieldOrder() {
		return "id, auth_name, title, year, summary";
	}

	public static String getTableName() {
		return "publication";
	}

	public static String getSelectClause() {
		return "select " + getFieldOrder() + " from " + getTableName();
	}

	public String getInsertStatement(int id) {
		return "insert into " + getTableName() + " (" + getFieldOrder() + ") values (" + id + ", '" + authName + "', '"
				+ title + "', " + year + ", '" + summary + "')";
	}

	public String getUpdateStatement(int id) {
		return "update " + getTableName() + " set " + "summary = '" + summary + "' " + "where id = " + id;
	}

	public void save() {
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(getSelectClause());

			boolean pubExists = false;
			while (rs.next()) {
				if (authName.equals(rs.getString("auth_name")) && title.equals(rs.getString("title"))
						&& year == rs.getInt("year")) {
					pubExists = true;
					stmt.executeUpdate(getUpdateStatement(rs.getInt("id")));
					System.out.print("Publication Summary updated into database");
				}
			}
			if (!pubExists) {
				rs = stmt.executeQuery("select max(id) FROM " + getTableName());
				rs.next();
				int id = (rs.getInt(1) == 0) ? 1 : rs.getInt(1) + 1;
				stmt.executeUpdate(getInsertStatement(id));
				System.out.print("Publication Info inserted into database");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
