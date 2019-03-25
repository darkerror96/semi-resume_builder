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
public class Education extends ResumeElement {
	private String schoolName;
	private String schoolCity;
	private String schoolState;
	private String degree;
	private String major;
	private String gradMonth;
	private int gradYear;
	private boolean isAnticipated;

	/**
	 * @param schoolName
	 * @param schoolCity
	 * @param schoolState
	 * @param degree
	 * @param major
	 * @param graduationMonth
	 * @param gratuationYear
	 * @param isAnticipated
	 */
	public Education(String schoolName, String schoolCity, String schoolState, String degree, String major,
			String gradMonth, int gradYear, boolean isAnticipated) {
		super();
		this.schoolName = schoolName;
		this.schoolCity = schoolCity;
		this.schoolState = schoolState;
		this.degree = degree;
		this.major = major;
		this.gradMonth = gradMonth;
		this.gradYear = gradYear;
		this.isAnticipated = isAnticipated;
	}

	public static String getTableName() {
		return "education";
	}

	public static String getFieldOrder() {
		return "id, school_name, school_city, school_state, degree, major, grad_month, grad_year, is_anticipated";
	}

	public static String getSelectClause() {
		return "select " + getFieldOrder() + " from " + getTableName();
	}

	public String getInsertStatement(int id) {

		return "insert into " + getTableName() + " (" + getFieldOrder() + ") values (" + id + ", '" + schoolName
				+ "', '" + schoolCity + "', '" + schoolState + "', '" + degree + "', '" + major + "', '" + gradMonth
				+ "', " + gradYear + ", " + isAnticipated + ")";
	}

	/**
	 * Updates education row with given id
	 * 
	 * @param id
	 * @return update query statement
	 */
	public String getUpdateStatement(int id) {
		return "update " + getTableName() + " set " + "school_name = '" + schoolName + "', " + "school_city = '"
				+ schoolCity + "', " + "school_state = '" + schoolState + "', " + "degree = '" + degree + "', "
				+ "major = '" + major + "', " + "grad_month = '" + gradMonth + "', " + "grad_year = " + gradYear + ", "
				+ "is_anticipated = " + isAnticipated + " WHERE id = " + id;
	}

	public void save() {
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(getSelectClause());

			boolean schoolExists = false;
			while (rs.next()) {
				if (schoolName.equals(rs.getString("school_name")) && schoolCity.equals(rs.getString("school_city"))) {

					schoolExists = true;
					// school exists in table so perform an UPDATE
					stmt.executeUpdate(getUpdateStatement(rs.getInt("id")));
				}
			}
			if (!schoolExists) {
				// if no matching school found in table, insert new school
				rs = stmt.executeQuery("SELECT max(id) FROM " + getTableName());
				rs.next();
				int id = (rs.getInt(1) == 0) ? 1 : rs.getInt(1) + 1;
				stmt.executeUpdate(getInsertStatement(id));
			}
			System.out.println("Inserted Education object into table");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ----------------------------
	// Getters
	// ----------------------------

	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * @return the schoolCity
	 */
	public String getSchoolCity() {
		return schoolCity;
	}

	/**
	 * @return the schoolState
	 */
	public String getSchoolState() {
		return schoolState;
	}

	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @return the gradMonth
	 */
	public String getGradMonth() {
		return gradMonth;
	}

	/**
	 * @return the gradYear
	 */
	public int getGradYear() {
		return gradYear;
	}

	/**
	 * @return the isAnticipated
	 */
	public boolean isAnticipated() {
		return isAnticipated;
	}

	@Override
	public String toString() {
		return "School Name: " + schoolName + "\n" + "School City: " + schoolCity + "\n" + "School State: "
				+ schoolState + "\n" + "Degree: " + degree + "\n" + "Major: " + major + "\n" + "Grad Month: "
				+ gradMonth + "\n" + "Grad Year: " + gradYear + "\n" + "IsAnticipated: " + isAnticipated + "\n";
	}
}
