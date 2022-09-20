package com.quinnox.Simple;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bike {
	

	private String bname;
	private int model;
	private int id;
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getModel() {
		return model;
	}
	public void setModel(int model) {
		this.model = model;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
			return "Bike [bname=" + bname + ", model=" + model + ", id=" + id + "]";
	}
	

}
