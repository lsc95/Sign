package com.coderli.entry;

import java.io.Serializable;

public class Menu implements Serializable{

	private static final long serialVersionUID = 1L;
	private int mid;
	private String mname;
	private String murl;
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	public Menu(int mid, String mname, String murl) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.murl = murl;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMurl() {
		return murl;
	}
	public void setMurl(String murl) {
		this.murl = murl;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mid;
		result = prime * result + ((mname == null) ? 0 : mname.hashCode());
		result = prime * result + ((murl == null) ? 0 : murl.hashCode());
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
		Menu other = (Menu) obj;
		if (mid != other.mid)
			return false;
		if (mname == null) {
			if (other.mname != null)
				return false;
		} else if (!mname.equals(other.mname))
			return false;
		if (murl == null) {
			if (other.murl != null)
				return false;
		} else if (!murl.equals(other.murl))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", mname=" + mname + ", murl=" + murl + "]";
	}
	
}
