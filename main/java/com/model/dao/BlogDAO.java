package com.model.dao;

import javax.servlet.http.HttpServletRequest;
import com.core.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import com.model.dto.Blog;

/**
 * �Խ��� DAO
 *
 */
public class BlogDAO {
	/**
	 * �Խñ� �ۼ�
	 * 
	 * @param request
	 * @return �Խñ� �ۼ� ������ ��ϵ� �Խñ� ��ȣ(0�̸� ����...)
	 */
	public int write(HttpServletRequest request) {
		int idx = 0;
		String sql = "INSERT INTO blog (poster, subject, content) VALUES(?, ?, ?)";
		try (Connection conn = DB.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			request.setCharacterEncoding("UTF-8");
			String poster = request.getParameter("poster");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			pstmt.setString(1, poster);
			pstmt.setString(2, subject);
			pstmt.setString(3, content);

			int result = pstmt.executeUpdate();
			if (result > 0) { // �Խñ� ����� �� �� ���
				ResultSet rs = pstmt.getGeneratedKeys();
				/**
				 * // .next() -> ���� ���÷� ������ true, �̵� // .getXxx(�Ӽ� ���� ��ȣ(1~), �Ӽ���)
				 */
				if (rs.next()) {
					idx = rs.getInt(1);
				}

				rs.close();
			}
		} catch (IOException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		}
		return idx;
	}
	
	/**
	 * �Խñ� ��ȸ
	 * 
	 * @param idx
	 * @return
	 */
	public Blog get(int idx) {
		Blog blog = null;
		String sql = "SELECT * FROM blog WHERE idx = ?";
		try (Connection conn = DB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, idx);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				blog = new Blog(rs);
			}
			rs.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return blog;
	}

	public ArrayList<Blog> getList(int page, int limit) {
		ArrayList<Blog> list = new ArrayList<>();

		page = (page == 0) ? 1 : page;
		limit = (limit == 0) ? 5 : limit;

		int offset = (page - 1) * limit; // ���� ����

		String sql = "SELECT * FROM blog ORDER BY idx LIMIT ?, ?";
		try (Connection conn = DB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, offset);
			pstmt.setInt(2, limit);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { // ���� ������ ������ true -> �������� �̵�
				list.add(new Blog(rs));
			}
			rs.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}


}
	