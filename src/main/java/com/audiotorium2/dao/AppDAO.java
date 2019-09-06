package com.audiotorium2.dao;

import javax.sql.DataSource;

import com.audiotorium2.core.*;
import com.audiotorium2.entity.Criteria;
import com.audiotorium2.entity.Product;
import com.audiotorium2.entity.Range;

import java.sql.*;

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
				+ "(id, name, issue_id, grade  ) VALUES (?,?,?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setInt(3, product.getIssue_id());
			ps.setDouble(4, product.getGrade());

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
