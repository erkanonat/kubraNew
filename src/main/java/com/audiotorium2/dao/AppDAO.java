package com.audiotorium2.dao;

import javax.sql.DataSource;

import com.audiotorium2.core.*;
import com.audiotorium2.entity.Criteria;
import com.audiotorium2.entity.Product;
import com.audiotorium2.entity.Range;
import com.audiotorium2.entity.SongView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppDAO implements IAppDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	@Override
	public EntityCriteria saveCriteria(EntityCriteria c) {

		String sql = "INSERT INTO sys.criteria "
				+ "(id, issue_id, name, weight) VALUES (?,?,?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, c.getId());
			ps.setInt(2, c.getIssue_id());
			ps.setString(3, c.getName());
			ps.setDouble(4,c.getWeight());

			ps.executeUpdate();
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					c.setId(generatedKeys.getInt(1));
				}
				else {
					throw new SQLException("Creating record failed, no ID obtained.");
				}
			}

			ps.close();
			return c;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	@Override
	public EntityRange saveRange(EntityRange range) {
		String sql = "INSERT INTO sys.range "
				+ "(id, criteria_id , range_name , range_value ) VALUES (?,?,?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, range.getId());
			ps.setInt(2, range.getCriteria_id());
			ps.setString(3, range.getRange_name());
			ps.setDouble(4, range.getRange_value());

			ps.executeUpdate();

			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					range.setId(generatedKeys.getInt(1));
				}
				else {
					throw new SQLException("Creating record failed, no ID obtained.");
				}
			}

			ps.close();
			return range;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public EntityProduct saveProduct(EntityProduct product) {
		String sql = "INSERT INTO sys.product "
				+ "(id, name, issue_id, grade, price, issue_id  ) VALUES (?,?,?,?,?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setInt(3, product.getIssue_id());
			ps.setDouble(4, product.getGrade());
			ps.setDouble(5,product.getPrice());
			ps.setInt(6,product.getIssue_id());

			ps.executeUpdate();

			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					product.setId(generatedKeys.getInt(1));
				}
				else {
					throw new SQLException("Creating record failed, no ID obtained.");
				}
			}

			ps.close();
			return  product;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public EntityProductDetails saveProductDetails(EntityProductDetails details) {

		String sql = "INSERT INTO sys.product_details "
				+ "(id, product_id, criteria_id , range_id, weight ) VALUES (?,?,?,?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, details.getId());
			ps.setInt(2, details.getProduct_id());
			ps.setInt(3, details.getCriteria_id());
			ps.setInt(4, details.getRange_id());
			ps.setDouble(5, details.getWeight());
			ps.executeUpdate();


			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					details.setId(generatedKeys.getInt(1));
				}
				else {
					throw new SQLException("Creating record failed, no ID obtained.");
				}
			}

			ps.close();
			return  details;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	@Override
	public void updateProduct(int productId, double grade, String name, double price, int selected) {


		String sql = "UPDATE sys.product "
				+ " SET name=?, grade=?, price=?, selected=? WHERE id=? ";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setDouble(2, grade);
			ps.setDouble(3, price);
			ps.setInt(4, selected);
			ps.setInt(5, productId);
			ps.executeUpdate();

			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	@Override
	public List<EntityIssue> listIssuesByStatus(int status) {
		String sql = "select m.* " +
				"from sys.Issue m" +
				"where m.status = ? " ;

		Connection conn = null;
		List<EntityIssue> swList = new ArrayList<EntityIssue>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EntityIssue issue = new EntityIssue();
				issue.setId(rs.getInt("id"));
				issue.setUser_id(rs.getInt("user_id"));
				issue.setIssue_name(rs.getString("issue_name"));
				issue.setStatus(rs.getInt("status"));

				swList.add(issue);

			}
			rs.close();
			ps.close();
			return swList;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}
	}

	@Override
	public List<EntityIssue> listMyIssues(int userId) {

		String sql = "select m.* " +
				"from sys.Issue m " +
				"where m.user_id = ? " ;

		Connection conn = null;
		List<EntityIssue> swList = new ArrayList<EntityIssue>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EntityIssue issue = new EntityIssue();
				issue.setId(rs.getInt("id"));
				issue.setUser_id(rs.getInt("user_id"));
				issue.setIssue_name(rs.getString("issue_name"));
				issue.setStatus(rs.getInt("status"));

				swList.add(issue);

			}
			rs.close();
			ps.close();
			return swList;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}
	}

	@Override
	public List<ProductView> listProductsView(int issueid) {
		String sql = "select p.* " +
				"from sys.product p " +
				"where p.issue_id = ? " ;

		Connection conn = null;
		List<ProductView> swList = new ArrayList<ProductView>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, issueid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductView pw = new ProductView();
				pw.setName(rs.getString("name"));
				pw.setGrade(rs.getDouble("grade"));
				pw.setPrice(rs.getDouble("price"));
				pw.setProduct_id(rs.getInt("id"));
				pw.setSelected(rs.getInt("selected"));
				swList.add(pw);
			}
			rs.close();
			ps.close();
			return swList;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}
	}

	@Override
	public List<CriteriaRangeView> listProductDetail(int productId) {
		String sql = "select c.name as cname, r.range_name as rname " +
				"from sys.product_details pd , sys.criteria c , sys.range r  " +
				"where pd.criteria_id = c.id and pd.range_id=r.id and pd.product_id = ? " ;

		Connection conn = null;
		List<CriteriaRangeView> swList = new ArrayList<CriteriaRangeView>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CriteriaRangeView pw = new CriteriaRangeView();
				pw.setCriteriaName(rs.getString("cname"));
				pw.setRangeName(rs.getString("rname"));
				swList.add(pw);
			}
			rs.close();
			ps.close();
			return swList;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}
	}



	@Override
	public EntityIssue saveIssue(EntityIssue issue) {

		String sql = "INSERT INTO sys.Issue "
				+ "(id, user_id, issue_name) VALUES (?,?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, issue.getId());
			ps.setInt(2, issue.getUser_id());
			ps.setString(3, issue.getIssue_name());

			int affectedRows = ps.executeUpdate();


			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					issue.setId(generatedKeys.getInt(1));
				}
				else {
					throw new SQLException("Creating record failed, no ID obtained.");
				}
			}
			ps.close();
			return issue;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}



}
