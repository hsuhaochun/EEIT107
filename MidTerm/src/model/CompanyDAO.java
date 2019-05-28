package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CompanyDAO {

	DataSource ds = null;

	public CompanyDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/CompanyDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String insertStmt = "insert into company values(?,?,?,?,?,?)";

	public int insert(CompanyBean bean) throws SQLException {
		int updateCount = 0;
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(insertStmt);) {
			pstmt.setInt(1, bean.getComco());
			pstmt.setString(2, bean.getComname());
			pstmt.setString(3, bean.getIndustry());
			pstmt.setString(4, bean.getChariman());
			java.util.Date t = bean.getListdate();
			if (t != null) {
				pstmt.setDate(5, new java.sql.Date(t.getTime()));
			} else {
				pstmt.setDate(5, null);
			}
			pstmt.setString(6, bean.getEmail());
			updateCount = pstmt.executeUpdate();
		}

		return updateCount;
	}

	private static final String UPDATE_BY_ID = "update company set comname=?,industry=?,chariman=?,listdate=?,email=? where comco=?";

	public int update(CompanyBean bean) {
		int updateCount = 0;
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(UPDATE_BY_ID);) {
			pstmt.setString(1, bean.getComname());
			pstmt.setString(2, bean.getIndustry());
			pstmt.setString(3, bean.getChariman());
			java.util.Date t = bean.getListdate();
			if (t != null) {
				pstmt.setDate(4, new java.sql.Date(t.getTime()));
			} else {
				pstmt.setDate(4, null);
			}
			pstmt.setString(5, bean.getEmail());
			pstmt.setInt(6, bean.getComco());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return updateCount;
	}

	private static final String SELECT_BY_ID = "Select comco,comname,industry,chariman,listdate,email from company where comco = ?";

	public CompanyBean select(int comco) {
		CompanyBean result = null;
		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {

			stmt.setInt(1, comco);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				result = new CompanyBean();
				result.setComco(rset.getInt("comco"));
				result.setComname(rset.getString("comname"));
				result.setIndustry(rset.getString("industry"));
				result.setChariman(rset.getString("chariman"));
				result.setListdate(new java.sql.Date(rset.getDate("listdate").getTime()));
				result.setEmail(rset.getString("email"));

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return result;
	}

	private static final String DELETE = "delete from company where comco=?";

	public int remove(int comco) {
		int updateCount = 0;
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(DELETE);) {
			pstmt.setInt(1, comco);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateCount;
	}

	private static final String SELECT_ALL = "Select * from company";

	public List<CompanyBean> selectAll() {
		List<CompanyBean> result = null;
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rs = stmt.executeQuery();) {
			result = new ArrayList<>();
			while (rs.next()) {
				CompanyBean cb = new CompanyBean();
				cb.setComco(rs.getInt("comco"));
				cb.setComname(rs.getString("comname"));
				cb.setIndustry(rs.getString("industry"));
				cb.setChariman(rs.getString("chariman"));
				cb.setListdate(new java.sql.Date(rs.getDate("listdate").getTime()));
				cb.setEmail(rs.getString("email"));
				result.add(cb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
