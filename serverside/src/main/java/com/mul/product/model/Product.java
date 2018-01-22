package com.mul.product.model;

import java.util.Date;

public class Product {
	public Product() {
	}

	public Product(Integer no, String title, String name, String price, String content, String uri, Date date,
			String user_no, String m_ctg, String md_ctg) {
		super();
		this.no = no;
		this.title = title;
		this.name = name;
		this.price = price;
		this.content = content;
		this.url = uri;
		this.date = date;
		this.user_no = user_no;
		this.m_ctg = m_ctg;
		this.md_ctg = md_ctg;
	}

	private Integer no;
	private String title;
	private String name;
	private String price;
	private String content;
	private String url;
	private Date date;

	private String user_no;
	private String m_ctg;
	private String md_ctg;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getM_ctg() {
		return m_ctg;
	}

	public void setM_ctg(String m_ctg) {
		this.m_ctg = m_ctg;
	}

	public String getMd_ctg() {
		return md_ctg;
	}

	public void setMd_ctg(String md_ctg) {
		this.md_ctg = md_ctg;
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	public Integer getNumber() {
		return no;
	}

	public void setNumber(Integer number) {
		this.no = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String uri) {
		this.url = uri;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [no=");
		builder.append(no);
		builder.append(", title=");
		builder.append(title);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", content=");
		builder.append(content);
		builder.append(", uri=");
		builder.append(url);
		builder.append(", date=");
		builder.append(date);
		builder.append(", user_no=");
		builder.append(user_no);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Product other = (Product) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

}
