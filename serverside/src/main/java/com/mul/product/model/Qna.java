package com.mul.product.model;

import java.util.Date;

public class Qna 
{
	public Qna() {}
	
	int qna_no;
	int user_no;
	String qna_title;
	String qna_content;
	Date qna_date;
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public Date getQna_date() {
		return qna_date;
	}
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((qna_content == null) ? 0 : qna_content.hashCode());
		result = prime * result + ((qna_date == null) ? 0 : qna_date.hashCode());
		result = prime * result + qna_no;
		result = prime * result + ((qna_title == null) ? 0 : qna_title.hashCode());
		result = prime * result + user_no;
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
		Qna other = (Qna) obj;
		if (qna_content == null) {
			if (other.qna_content != null)
				return false;
		} else if (!qna_content.equals(other.qna_content))
			return false;
		if (qna_date == null) {
			if (other.qna_date != null)
				return false;
		} else if (!qna_date.equals(other.qna_date))
			return false;
		if (qna_no != other.qna_no)
			return false;
		if (qna_title == null) {
			if (other.qna_title != null)
				return false;
		} else if (!qna_title.equals(other.qna_title))
			return false;
		if (user_no != other.user_no)
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rating [qna_no=");
		builder.append(qna_no);
		builder.append(", user_no=");
		builder.append(user_no);
		builder.append(", qna_title=");
		builder.append(qna_title);
		builder.append(", qna_content=");
		builder.append(qna_content);
		builder.append(", qna_date=");
		builder.append(qna_date);
		builder.append("]");
		return builder.toString();
	}
	public Qna(int qna_no, int user_no, String qna_title, String qna_content, Date qna_date) {
		super();
		this.qna_no = qna_no;
		this.user_no = user_no;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_date = qna_date;
	}
}
