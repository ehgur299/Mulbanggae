package com.koitt.shopping.model;

public class Admin {
	private int Anumber;
	private int Aid;
	private String Apwd;
	
	public Admin() {}

	public Admin(int anumber, int aid, String apwd) {
		super();
		Anumber = anumber;
		Aid = aid;
		Apwd = apwd;
	}

	public int getAnumber() {
		return Anumber;
	}

	public void setAnumber(int anumber) {
		Anumber = anumber;
	}

	public int getAid() {
		return Aid;
	}

	public void setAid(int aid) {
		Aid = aid;
	}

	public String getApwd() {
		return Apwd;
	}

	public void setApwd(String apwd) {
		Apwd = apwd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Aid;
		result = prime * result + Anumber;
		result = prime * result + ((Apwd == null) ? 0 : Apwd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (Aid != other.Aid)
			return false;
		if (Anumber != other.Anumber)
			return false;
		if (Apwd == null) {
			if (other.Apwd != null)
				return false;
		} else if (!Apwd.equals(other.Apwd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Admin [Anumber=");
		builder.append(Anumber);
		builder.append(", Aid=");
		builder.append(Aid);
		builder.append(", Apwd=");
		builder.append(Apwd);
		builder.append("]");
		return builder.toString();
	}
	
}
