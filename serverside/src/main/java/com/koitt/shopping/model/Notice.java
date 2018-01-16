package com.koitt.shopping.model;

import java.util.Date;

public class Notice {
	private int Nnumber;
	private String Ntitle;
	private String Ncontent;
	private String Nurl;
	private Date Ndate;
	
	public Notice() {}

	public Notice(int nnumber, String ntitle, String ncontent, String nurl, Date ndate) {
		super();
		Nnumber = nnumber;
		Ntitle = ntitle;
		Ncontent = ncontent;
		Nurl = nurl;
		Ndate = ndate;
	}

	public int getNnumber() {
		return Nnumber;
	}

	public void setNnumber(int nnumber) {
		Nnumber = nnumber;
	}

	public String getNtitle() {
		return Ntitle;
	}

	public void setNtitle(String ntitle) {
		Ntitle = ntitle;
	}

	public String getNcontent() {
		return Ncontent;
	}

	public void setNcontent(String ncontent) {
		Ncontent = ncontent;
	}

	public String getNurl() {
		return Nurl;
	}

	public void setNurl(String nurl) {
		Nurl = nurl;
	}

	public Date getNdate() {
		return Ndate;
	}

	public void setNdate(Date ndate) {
		Ndate = ndate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ncontent == null) ? 0 : Ncontent.hashCode());
		result = prime * result + ((Ndate == null) ? 0 : Ndate.hashCode());
		result = prime * result + Nnumber;
		result = prime * result + ((Ntitle == null) ? 0 : Ntitle.hashCode());
		result = prime * result + ((Nurl == null) ? 0 : Nurl.hashCode());
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
		Notice other = (Notice) obj;
		if (Ncontent == null) {
			if (other.Ncontent != null)
				return false;
		} else if (!Ncontent.equals(other.Ncontent))
			return false;
		if (Ndate == null) {
			if (other.Ndate != null)
				return false;
		} else if (!Ndate.equals(other.Ndate))
			return false;
		if (Nnumber != other.Nnumber)
			return false;
		if (Ntitle == null) {
			if (other.Ntitle != null)
				return false;
		} else if (!Ntitle.equals(other.Ntitle))
			return false;
		if (Nurl == null) {
			if (other.Nurl != null)
				return false;
		} else if (!Nurl.equals(other.Nurl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Notice [Nnumber=");
		builder.append(Nnumber);
		builder.append(", Ntitle=");
		builder.append(Ntitle);
		builder.append(", Ncontent=");
		builder.append(Ncontent);
		builder.append(", Nurl=");
		builder.append(Nurl);
		builder.append(", Ndate=");
		builder.append(Ndate);
		builder.append("]");
		return builder.toString();
	}
	
}
