package com.coderli.entry;

import java.io.Serializable;

/**
 * @author lishichun
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private int unumber;
	private String uname;
	private String upwd;
	private String usex;
	private int uage;
	private String uaddress;
	private int rid;
	private int pnumber;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int unumber, String uname, String upwd, String usex, int uage,
			String uaddress, int rid, int pnumber) {
		super();
		this.unumber = unumber;
		this.uname = uname;
		this.upwd = upwd;
		this.usex = usex;
		this.uage = uage;
		this.uaddress = uaddress;
		this.rid = rid;
		this.pnumber = pnumber;
	}
	public int getUnumber() {
		return unumber;
	}
	public void setUnumber(int unumber) {
		this.unumber = unumber;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getPnumber() {
		return pnumber;
	}
	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}
	@Override
	public String toString() {
		return "User [unumber=" + unumber + ", uname=" + uname + ", upwd="
				+ upwd + ", usex=" + usex + ", uage=" + uage + ", uaddress="
				+ uaddress + ", rid=" + rid + ", pnumber=" + pnumber + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pnumber;
		result = prime * result + rid;
		result = prime * result
				+ ((uaddress == null) ? 0 : uaddress.hashCode());
		result = prime * result + uage;
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		result = prime * result + unumber;
		result = prime * result + ((upwd == null) ? 0 : upwd.hashCode());
		result = prime * result + ((usex == null) ? 0 : usex.hashCode());
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
		User other = (User) obj;
		if (pnumber != other.pnumber)
			return false;
		if (rid != other.rid)
			return false;
		if (uaddress == null) {
			if (other.uaddress != null)
				return false;
		} else if (!uaddress.equals(other.uaddress))
			return false;
		if (uage != other.uage)
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		if (unumber != other.unumber)
			return false;
		if (upwd == null) {
			if (other.upwd != null)
				return false;
		} else if (!upwd.equals(other.upwd))
			return false;
		if (usex == null) {
			if (other.usex != null)
				return false;
		} else if (!usex.equals(other.usex))
			return false;
		return true;
	}
	
}
