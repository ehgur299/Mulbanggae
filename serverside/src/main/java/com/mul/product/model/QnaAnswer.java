package com.mul.product.model;

import java.util.Date;

public class QnaAnswer 
{
	public QnaAnswer() {}
	
	int answer_no;
	int qna_no;
	String answer_content;
	Date answer_date;
	public int getAnswer_no() {
		return answer_no;
	}
	public void setAnswer_no(int answer_no) {
		this.answer_no = answer_no;
	}
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	public Date getAnswer_date() {
		return answer_date;
	}
	public void setAnswer_date(Date answer_date) {
		this.answer_date = answer_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer_content == null) ? 0 : answer_content.hashCode());
		result = prime * result + ((answer_date == null) ? 0 : answer_date.hashCode());
		result = prime * result + answer_no;
		result = prime * result + qna_no;
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
		QnaAnswer other = (QnaAnswer) obj;
		if (answer_content == null) {
			if (other.answer_content != null)
				return false;
		} else if (!answer_content.equals(other.answer_content))
			return false;
		if (answer_date == null) {
			if (other.answer_date != null)
				return false;
		} else if (!answer_date.equals(other.answer_date))
			return false;
		if (answer_no != other.answer_no)
			return false;
		if (qna_no != other.qna_no)
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QnaAnswer [answer_no=");
		builder.append(answer_no);
		builder.append(", qna_no=");
		builder.append(qna_no);
		builder.append(", answer_content=");
		builder.append(answer_content);
		builder.append(", answer_date=");
		builder.append(answer_date);
		builder.append("]");
		return builder.toString();
	}
	
}
