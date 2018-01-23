package com.mul.product.model;

import java.util.Date;

public class Rating 
{
	public Rating() {}
	
	int r_no;
	int ur_get_no;
	int ur_give_no;
	int r_score;
	String r_content;
	Date r_date;
	public int getR_no() {
		return r_no;
	}
	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	public int getUr_get_no() {
		return ur_get_no;
	}
	public void setUr_get_no(int ur_get_no) {
		this.ur_get_no = ur_get_no;
	}
	public int getUr_give_no() {
		return ur_give_no;
	}
	public void setUr_give_no(int ur_give_no) {
		this.ur_give_no = ur_give_no;
	}
	public int getR_score() {
		return r_score;
	}
	public void setR_score(int r_score) {
		this.r_score = r_score;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public Date getR_date() {
		return r_date;
	}
	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((r_content == null) ? 0 : r_content.hashCode());
		result = prime * result + ((r_date == null) ? 0 : r_date.hashCode());
		result = prime * result + r_no;
		result = prime * result + r_score;
		result = prime * result + ur_get_no;
		result = prime * result + ur_give_no;
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
		Rating other = (Rating) obj;
		if (r_content == null) {
			if (other.r_content != null)
				return false;
		} else if (!r_content.equals(other.r_content))
			return false;
		if (r_date == null) {
			if (other.r_date != null)
				return false;
		} else if (!r_date.equals(other.r_date))
			return false;
		if (r_no != other.r_no)
			return false;
		if (r_score != other.r_score)
			return false;
		if (ur_get_no != other.ur_get_no)
			return false;
		if (ur_give_no != other.ur_give_no)
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rating [r_no=");
		builder.append(r_no);
		builder.append(", ur_get_no=");
		builder.append(ur_get_no);
		builder.append(", ur_give_no=");
		builder.append(ur_give_no);
		builder.append(", r_score=");
		builder.append(r_score);
		builder.append(", r_content=");
		builder.append(r_content);
		builder.append(", r_date=");
		builder.append(r_date);
		builder.append("]");
		return builder.toString();
	}
	
	
}
