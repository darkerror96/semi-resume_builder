package edu.sollers.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.sollers.mvc.ResumeElement;

/**
 * @author rutpatel
 */

public class Experience extends ResumeElement {

	private String cmpName;
	private String pos;
	private String cmpLoc;
	private String startDate;
	private String endDate;
	private String cmpSumm;

	/**
	 * @param cmpName
	 * @param pos
	 * @param cmpLoc
	 * @param startDate
	 * @param endDate
	 * @param cmpSumm
	 */
	public Experience(String cmpName, String pos, String cmpLoc, String startDate, String endDate, String cmpSumm) {
		this.cmpName = cmpName;
		this.pos = pos;
		this.cmpLoc = cmpLoc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.cmpSumm = cmpSumm;
	}

	/**
	 * @return the cmpName
	 */
	public String getCmpName() {
		return cmpName;
	}

	/**
	 * @return the pos
	 */
	public String getPos() {
		return pos;
	}

	/**
	 * @return the cmpLoc
	 */
	public String getCmpLoc() {
		return cmpLoc;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @return the cmpSumm
	 */
	public String getCmpSumm() {
		return cmpSumm;
	}

	public static String getFieldOrder() {
		return "id, cmp_name, pos, cmp_loc, start_date, end_date, cmp_summ";
	}

	public static String getTableName() {
		return "experience";
	}

	public static String getSelectClause() {
		return "select " + getFieldOrder() + " from " + getTableName();
	}

	public String getInsertStatement(int id) {
		return "insert into " + getTableName() + " (" + getFieldOrder() + ") values (" + id + ", '" + cmpName + "', '"
				+ pos + "', '" + cmpLoc + "', '" + startDate + "', '" + endDate + "', '" + cmpSumm + "')";
	}

	public String getUpdateStatement(int id) {
		return "update " + getTableName() + " set " + "cmp_summ = '" + cmpSumm + "' " + "where id = " + id;
	}

	public void save() {
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(getSelectClause());

			boolean expExists = false;
			while (rs.next()) {
				if (cmpName.equals(rs.getString("cmp_name")) && pos.equals(rs.getString("pos"))
						&& cmpLoc.equals(rs.getString("cmp_loc")) && startDate.equals(rs.getString("start_date"))
						&& endDate.equals(rs.getString("end_date"))) {
					expExists = true;
					stmt.executeUpdate(getUpdateStatement(rs.getInt("id")));
					System.out.print("Experience Summary updated into database");
				}
			}
			if (!expExists) {
				rs = stmt.executeQuery("select max(id) FROM " + getTableName());
				rs.next();
				int id = (rs.getInt(1) == 0) ? 1 : rs.getInt(1) + 1;
				stmt.executeUpdate(getInsertStatement(id));
				System.out.print("Experience Info inserted into database");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
