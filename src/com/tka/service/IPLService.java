package com.tka.service;

import java.util.ArrayList;
import java.util.List;

import com.tka.dao.IPLDao;
import com.tka.entity.Player;

public class IPLService {

	IPLDao dao = new IPLDao();

	public List<Player> getAllPlayers() {
		return dao.getAllPlayers();
	}

	public void addPlayer(Player p) {
		dao.insertPlayer(p);
	}

	public void updateRuns(int pid, int runs) {
		dao.updateRuns(pid, runs);
	}

	public void deletePlayer(int pid) {
		dao.deletePlayer(pid);
	}

	// BOWLERS

	public List<Player> getBowlers() {

		List<Player> list = dao.getAllPlayers();

		List<Player> bowlers =
				new ArrayList<>();

		for (Player p : list) {

			if (p.getRole()
					.equalsIgnoreCase("Bowler")) {

				bowlers.add(p);
			}
		}

		return bowlers;
	}

	// BATTERS

	public List<Player> getBatters() {

		List<Player> list = dao.getAllPlayers();

		List<Player> batters =
				new ArrayList<>();

		for (Player p : list) {

			if (p.getRole()
					.equalsIgnoreCase("Batter")) {

				batters.add(p);
			}
		}

		return batters;
	}

	// ALL ROUNDER

	public List<Player> getAllRounders() {

		List<Player> list = dao.getAllPlayers();

		List<Player> allrounders =
				new ArrayList<>();

		for (Player p : list) {

			if (p.getRole()
					.equalsIgnoreCase("AllRounder")) {

				allrounders.add(p);
			}
		}

		return allrounders;
	}

	// TEAM FILTER

	public List<Player> getTeamPlayers(String team) {

		List<Player> list = dao.getAllPlayers();

		List<Player> teamPlayers =
				new ArrayList<>();

		for (Player p : list) {

			if (p.getTname()
					.equalsIgnoreCase(team)) {

				teamPlayers.add(p);
			}
		}

		return teamPlayers;
	}
}