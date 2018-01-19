package com.mul.product.model;

import java.util.Date;

public class Notice {

	private Integer no;
	private String title;
	private String content;
	private String url;
	private Date date;
	private Integer user_num;
	private UserInfo userInfo;
	
	public Notice() {}

	public Notice(Integer no, String title, String content, String url, Date date, Integer user_num,
			UserInfo userInfo) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.url = url;
		this.date = date;
		this.user_num = user_num;
		this.userInfo = userInfo;
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

	public Integer getUser_num() {
		return user_num;
	}

	public void setUser_num(Integer user_num) {
		this.user_num = user_num;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((userInfo == null) ? 0 : userInfo.hashCode());
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
		Notice other = (Notice) obj;
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
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
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
		if (userInfo == null) {
			if (other.userInfo != null)
				return false;
		} else if (!userInfo.equals(other.userInfo))
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
		builder.append("Notice [no=");
		builder.append(no);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", url=");
		builder.append(url);
		builder.append(", date=");
		builder.append(date);
		builder.append(", user_num=");
		builder.append(user_num);
		builder.append(", userInfo=");
		builder.append(userInfo);
		builder.append("]");
		return builder.toString();
	}
}
