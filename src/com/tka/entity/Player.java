package com.tka.entity;

public class Player {
	
		private int pid;
		private int jn;
		private String pname;
		private int runs;
		private int wickets;
		private String tname;
		private String role;

		public Player() {
		}

		public Player(int pid, int jn, String pname, int runs,
				int wickets, String tname, String role) {

			this.pid = pid;
			this.jn = jn;
			this.pname = pname;
			this.runs = runs;
			this.wickets = wickets;
			this.tname = tname;
			this.role = role;
		}

		public int getPid() {
			return pid;
		}

		public void setPid(int pid) {
			this.pid = pid;
		}

		public int getJn() {
			return jn;
		}

		public void setJn(int jn) {
			this.jn = jn;
		}

		public String getPname() {
			return pname;
		}

		public void setPname(String pname) {
			this.pname = pname;
		}

		public int getRuns() {
			return runs;
		}

		public void setRuns(int runs) {
			this.runs = runs;
		}

		public int getWickets() {
			return wickets;
		}

		public void setWickets(int wickets) {
			this.wickets = wickets;
		}

		public String getTname() {
			return tname;
		}

		public void setTname(String tname) {
			this.tname = tname;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		@Override
		public String toString() {
			return pid + " " + jn + " " + pname + " "
					+ runs + " " + wickets + " "
					+ tname + " " + role;
		}
	}