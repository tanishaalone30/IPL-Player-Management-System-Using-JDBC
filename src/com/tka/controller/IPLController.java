package com.tka.controller;

import java.util.List;
import java.util.Scanner;

import com.tka.entity.Player;
import com.tka.service.IPLService;

public class IPLController {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		IPLService service =
				new IPLService();

		while (true) {

			System.out.println("\n===== IPL MENU =====");

			System.out.println("1.Get All Players");
			System.out.println("2.Insert");
			System.out.println("3.Update Runs");
			System.out.println("4.Delete");
			System.out.println("5.Bowlers");
			System.out.println("6.Batters");
			System.out.println("7.All Rounders");
			System.out.println("8.Team Wise");
			System.out.println("9.Exit");

			int ch = sc.nextInt();

			switch (ch) {

			case 1:

				service.getAllPlayers()
						.forEach(System.out::println);
				break;

			case 2:

				Player p = new Player();

				System.out.println("PID");
				p.setPid(sc.nextInt());

				System.out.println("Jersey");
				p.setJn(sc.nextInt());

				sc.nextLine();

				System.out.println("Name");
				p.setPname(sc.nextLine());

				System.out.println("Runs");
				p.setRuns(sc.nextInt());

				System.out.println("Wickets");
				p.setWickets(sc.nextInt());

				sc.nextLine();

				System.out.println("Team");
				p.setTname(sc.nextLine());

				System.out.println("Role");
				p.setRole(sc.nextLine());

				service.addPlayer(p);

				break;

			case 3:

				System.out.println("PID");

				int pid = sc.nextInt();

				System.out.println("New Runs");

				int runs = sc.nextInt();

				service.updateRuns(pid, runs);

				break;

			case 4:

				System.out.println("PID");

				int deleteId = sc.nextInt();

				service.deletePlayer(deleteId);

				break;

			case 5:

				service.getBowlers()
						.forEach(System.out::println);

				break;

			case 6:

				service.getBatters()
						.forEach(System.out::println);

				break;

			case 7:

				service.getAllRounders()
						.forEach(System.out::println);

				break;

			case 8:

				sc.nextLine();

				System.out.println(
						"Enter Team Name");

				String team =
						sc.nextLine();

				service.getTeamPlayers(team)
						.forEach(System.out::println);

				break;

			case 9:

				System.exit(0);
			}
		}
	}
}
