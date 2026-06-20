package com.tka.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tka.entity.Player;

public class IPLDao {
	
	private String path = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/kiran_sql";
	private String user = "root";
	private String pwd = "@TanishaA301";
	
	Connection con = null;

	public IPLDao() {

		try {

			Class.forName(path);

			con = DriverManager.getConnection(
					url, user, pwd);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// GET ALL PLAYERS

	public List<Player> getAllPlayers() {

		List<Player> list = new ArrayList<>();

		try {

			PreparedStatement pst =
					con.prepareStatement(
							"select * from ipl_player");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Player p = new Player();

				p.setPid(rs.getInt("pid"));
				p.setJn(rs.getInt("jn"));
				p.setPname(rs.getString("pname"));
				p.setRuns(rs.getInt("runs"));
				p.setWickets(rs.getInt("wickets"));
				p.setTname(rs.getString("tname"));
				p.setRole(rs.getString("role"));

				list.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// INSERT

	public void insertPlayer(Player p) {

		try {

			PreparedStatement pst =
					con.prepareStatement(
							"insert into ipl_player values(?,?,?,?,?,?,?)");

			pst.setInt(1, p.getPid());
			pst.setInt(2, p.getJn());
			pst.setString(3, p.getPname());
			pst.setInt(4, p.getRuns());
			pst.setInt(5, p.getWickets());
			pst.setString(6, p.getTname());
			pst.setString(7, p.getRole());

			System.out.println(
					pst.executeUpdate() + " Inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// UPDATE RUNS

	public void updateRuns(int pid, int runs) {

		try {

			PreparedStatement pst =
					con.prepareStatement(
							"update ipl_player set runs=? where pid=?");

			pst.setInt(1, runs);
			pst.setInt(2, pid);

			System.out.println(
					pst.executeUpdate() + " Updated");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DELETE

	public void deletePlayer(int pid) {

		try {

			PreparedStatement pst =
					con.prepareStatement(
							"delete from ipl_player where pid=?");

			pst.setInt(1, pid);

			System.out.println(
					pst.executeUpdate() + " Deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}