package com.chenjifeng.cms.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Special implements Serializable{
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String tittle;
	private String aabstract;
	private Date created;
	private Integer number;
	
	private List<Article> listArticle;
	
	
	
	
	
	
	
	
	public List<Article> getListArticle() {
		return listArticle;
	}
	public void setListArticle(List<Article> listArticle) {
		this.listArticle = listArticle;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getAabstract() {
		return aabstract;
	}
	public void setAabstract(String aabstract) {
		this.aabstract = aabstract;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aabstract == null) ? 0 : aabstract.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tittle == null) ? 0 : tittle.hashCode());
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
		Special other = (Special) obj;
		if (aabstract == null) {
			if (other.aabstract != null)
				return false;
		} else if (!aabstract.equals(other.aabstract))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tittle == null) {
			if (other.tittle != null)
				return false;
		} else if (!tittle.equals(other.tittle))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Special [id=" + id + ", tittle=" + tittle + ", aabstract="
				+ aabstract + ", created=" + created + ", number=" + number
				+ ", listArticle=" + listArticle + "]";
	}
	
	
	
	
}
