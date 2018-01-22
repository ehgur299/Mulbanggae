package com.mul.product.model;

import java.util.Date;

public class Comment 
{
	public Comment() {}
	
	public Comment(int cmt_no, int product_no, int user_no, String cmt_content, Date cmt_date) {
		super();
		this.cmt_no = cmt_no;
		this.product_no = product_no;
		this.user_no = user_no;
		this.cmt_content = cmt_content;
		this.cmt_date = cmt_date;
	}

	int cmt_no;
	int product_no;
	int user_no;
	String cmt_content;
	Date cmt_date;
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comment [cmt_no=");
		builder.append(cmt_no);
		builder.append(", product_no=");
		builder.append(product_no);
		builder.append(", user_no=");
		builder.append(user_no);
		builder.append(", cmt_content=");
		builder.append(cmt_content);
		builder.append(", cmt_date=");
		builder.append(cmt_date);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cmt_content == null) ? 0 : cmt_content.hashCode());
		result = prime * result + ((cmt_date == null) ? 0 : cmt_date.hashCode());
		result = prime * result + cmt_no;
		result = prime * result + product_no;
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
		Comment other = (Comment) obj;
		if (cmt_content == null) {
			if (other.cmt_content != null)
				return false;
		} else if (!cmt_content.equals(other.cmt_content))
			return false;
		if (cmt_date == null) {
			if (other.cmt_date != null)
				return false;
		} else if (!cmt_date.equals(other.cmt_date))
			return false;
		if (cmt_no != other.cmt_no)
			return false;
		if (product_no != other.product_no)
			return false;
		if (user_no != other.user_no)
			return false;
		return true;
	}

	public int getCmt_no() {
		return cmt_no;
	}
	public void setCmt_no(int cmt_no) {
		this.cmt_no = cmt_no;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getCmt_content() {
		return cmt_content;
	}
	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}
	public Date getCmt_date() {
		return cmt_date;
	}
	public void setCmt_date(Date cmt_date) {
		this.cmt_date = cmt_date;
	}
}
