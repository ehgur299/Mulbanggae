package com.mul.product.model;

import java.util.Date;

public class Comment {

	Integer cmt_num;
	Integer product_num;
	Integer user_num;
	String cmt_content;
	Date cmt_date;
	
	public Comment() {}
	
	public Comment(Integer cmt_num, Integer product_num, Integer user_num, String cmt_content, Date cmt_date) {
		super();
		this.cmt_num = cmt_num;
		this.product_num = product_num;
		this.user_num = user_num;
		this.cmt_content = cmt_content;
		this.cmt_date = cmt_date;
	}

	public Integer getCmt_num() {
		return cmt_num;
	}

	public void setCmt_num(Integer cmt_num) {
		this.cmt_num = cmt_num;
	}

	public Integer getProduct_num() {
		return product_num;
	}

	public void setProduct_num(Integer product_num) {
		this.product_num = product_num;
	}

	public Integer getUser_num() {
		return user_num;
	}

	public void setUser_num(Integer user_num) {
		this.user_num = user_num;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cmt_content == null) ? 0 : cmt_content.hashCode());
		result = prime * result + ((cmt_date == null) ? 0 : cmt_date.hashCode());
		result = prime * result + ((cmt_num == null) ? 0 : cmt_num.hashCode());
		result = prime * result + ((product_num == null) ? 0 : product_num.hashCode());
		result = prime * result + ((user_num == null) ? 0 : user_num.hashCode());
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
		if (cmt_num == null) {
			if (other.cmt_num != null)
				return false;
		} else if (!cmt_num.equals(other.cmt_num))
			return false;
		if (product_num == null) {
			if (other.product_num != null)
				return false;
		} else if (!product_num.equals(other.product_num))
			return false;
		if (user_num == null) {
			if (other.user_num != null)
				return false;
		} else if (!user_num.equals(other.user_num))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comment [cmt_num=");
		builder.append(cmt_num);
		builder.append(", product_num=");
		builder.append(product_num);
		builder.append(", user_num=");
		builder.append(user_num);
		builder.append(", cmt_content=");
		builder.append(cmt_content);
		builder.append(", cmt_date=");
		builder.append(cmt_date);
		builder.append("]");
		return builder.toString();
	}
}
