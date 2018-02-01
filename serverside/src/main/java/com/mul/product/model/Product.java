package com.mul.product.model;

import java.util.Date;

public class Product {

	private Integer no;
	private String title;
	private String productname;
	private String price;
	private String content;
	private String url;
	private Date date;

	private Integer user_no;
	private String m_ctg;
	private String md_ctg;
	
	public Product() {}
	
	public Product(Integer no, String title, String productname, String price, String content, String url, Date date,
			Integer user_no, String m_ctg, String md_ctg) {
		super();
		this.no = no;
		this.title = title;
		this.productname = productname;
		this.price = price;
		this.content = content;
		this.url = url;
		this.date = date;
		this.user_no = user_no;
		this.m_ctg = m_ctg;
		this.md_ctg = md_ctg;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
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

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getUser_no() {
		return user_no;
	}

	public void setUser_no(Integer user_no) {
		this.user_no = user_no;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((m_ctg == null) ? 0 : m_ctg.hashCode());
		result = prime * result + ((md_ctg == null) ? 0 : md_ctg.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productname == null) ? 0 : productname.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((user_no == null) ? 0 : user_no.hashCode());
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
		if (m_ctg == null) {
			if (other.m_ctg != null)
				return false;
		} else if (!m_ctg.equals(other.m_ctg))
			return false;
		if (md_ctg == null) {
			if (other.md_ctg != null)
				return false;
		} else if (!md_ctg.equals(other.md_ctg))
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
		if (productname == null) {
			if (other.productname != null)
				return false;
		} else if (!productname.equals(other.productname))
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
		if (user_no == null) {
			if (other.user_no != null)
				return false;
		} else if (!user_no.equals(other.user_no))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [no=");
		builder.append(no);
		builder.append(", title=");
		builder.append(title);
		builder.append(", productname=");
		builder.append(productname);
		builder.append(", price=");
		builder.append(price);
		builder.append(", content=");
		builder.append(content);
		builder.append(", url=");
		builder.append(url);
		builder.append(", date=");
		builder.append(date);
		builder.append(", user_no=");
		builder.append(user_no);
		builder.append(", m_ctg=");
		builder.append(m_ctg);
		builder.append(", md_ctg=");
		builder.append(md_ctg);
		builder.append("]");
		return builder.toString();
	}
}
