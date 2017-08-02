package com.coderli.entry;

import java.io.Serializable;

public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	private int rid;
	private String rname;
	private String rdesc;
	public Role() {
	}
	public Role(int rid, String rname, String rdesc) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.rdesc = rdesc;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRdesc() {
		return rdesc;
	}
	public void setRdesc(String rdesc) {
		this.rdesc = rdesc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rdesc == null) ? 0 : rdesc.hashCode());
		result = prime * result + rid;
		result = prime * result + ((rname == null) ? 0 : rname.hashCode());
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
		Role other = (Role) obj;
		if (rdesc == null) {
			if (other.rdesc != null)
				return false;
		} else if (!rdesc.equals(other.rdesc))
			return false;
		if (rid != other.rid)
			return false;
		if (rname == null) {
			if (other.rname != null)
				return false;
		} else if (!rname.equals(other.rname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", rname=" + rname + ", rdesc=" + rdesc
				+ "]";
	}
	
}
