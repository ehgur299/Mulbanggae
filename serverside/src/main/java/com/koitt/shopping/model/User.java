package com.koitt.shopping.model;

import java.util.Date;

public class User {
	private int Unumber;
	private String Unickname;
	private String Uid;
	private String Upwd;
	private int Ugender;
	private Date Ubirth;
	
	public User() {}

	public User(int unumber, String unickname, String uid, String upwd, int ugender, Date ubirth) {
		super();
		Unumber = unumber;
		Unickname = unickname;
		Uid = uid;
		Upwd = upwd;
		Ugender = ugender;
		Ubirth = ubirth;
	}

	public int getUnumber() {
		return Unumber;
	}

	public void setUnumber(int unumber) {
		Unumber = unumber;
	}

	public String getUnickname() {
		return Unickname;
	}

	public void setUnickname(String unickname) {
		Unickname = unickname;
	}

	public String getUid() {
		return Uid;
	}

	public void setUid(String uid) {
		Uid = uid;
	}

	public String getUpwd() {
		return Upwd;
	}

	public void setUpwd(String upwd) {
		Upwd = upwd;
	}

	public int getUgender() {
		return Ugender;
	}

	public void setUgender(int ugender) {
		Ugender = ugender;
	}

	public Date getUbirth() {
		return Ubirth;
	}

	public void setUbirth(Date ubirth) {
		Ubirth = ubirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ubirth == null) ? 0 : Ubirth.hashCode());
		result = prime * result + Ugender;
		result = prime * result + ((Uid == null) ? 0 : Uid.hashCode());
		result = prime * result + ((Unickname == null) ? 0 : Unickname.hashCode());
		result = prime * result + Unumber;
		result = prime * result + ((Upwd == null) ? 0 : Upwd.hashCode());
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
		User other = (User) obj;
		if (Ubirth == null) {
			if (other.Ubirth != null)
				return false;
		} else if (!Ubirth.equals(other.Ubirth))
			return false;
		if (Ugender != other.Ugender)
			return false;
		if (Uid == null) {
			if (other.Uid != null)
				return false;
		} else if (!Uid.equals(other.Uid))
			return false;
		if (Unickname == null) {
			if (other.Unickname != null)
				return false;
		} else if (!Unickname.equals(other.Unickname))
			return false;
		if (Unumber != other.Unumber)
			return false;
		if (Upwd == null) {
			if (other.Upwd != null)
				return false;
		} else if (!Upwd.equals(other.Upwd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [Unumber=");
		builder.append(Unumber);
		builder.append(", Unickname=");
		builder.append(Unickname);
		builder.append(", Uid=");
		builder.append(Uid);
		builder.append(", Upwd=");
		builder.append(Upwd);
		builder.append(", Ugender=");
		builder.append(Ugender);
		builder.append(", Ubirth=");
		builder.append(Ubirth);
		builder.append("]");
		return builder.toString();
	}
}
