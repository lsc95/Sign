package com.coderli.entry;

import java.io.Serializable;

public class Sign implements Serializable {
	private static final long serialVersionUID = 1L;
	private int sid;
	private int unumber;
	private String sintime;
	private String sinstatus;
	private String souttime;
	private String soutstatus;
	private String sdate;

	public Sign() {
		// TODO Auto-generated constructor stub
	}

	public Sign(int sid, int unumber, String sintime, String sinstatus,
			String souttime, String soutstatus, String sdate) {
		super();
		this.sid = sid;
		this.unumber = unumber;
		this.sintime = sintime;
		this.sinstatus = sinstatus;
		this.souttime = souttime;
		this.soutstatus = soutstatus;
		this.sdate = sdate;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getUnumber() {
		return unumber;
	}

	public void setUnumber(int unumber) {
		this.unumber = unumber;
	}

	public String getSintime() {
		return sintime;
	}

	public void setSintime(String sintime) {
		this.sintime = sintime;
	}

	public String getSinstatus() {
		return sinstatus;
	}

	public void setSinstatus(String sinstatus) {
		this.sinstatus = sinstatus;
	}

	public String getSouttime() {
		return souttime;
	}

	public void setSouttime(String souttime) {
		this.souttime = souttime;
	}

	public String getSoutstatus() {
		return soutstatus;
	}

	public void setSoutstatus(String soutstatus) {
		this.soutstatus = soutstatus;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sdate == null) ? 0 : sdate.hashCode());
		result = prime * result + sid;
		result = prime * result
				+ ((sinstatus == null) ? 0 : sinstatus.hashCode());
		result = prime * result + ((sintime == null) ? 0 : sintime.hashCode());
		result = prime * result
				+ ((soutstatus == null) ? 0 : soutstatus.hashCode());
		result = prime * result
				+ ((souttime == null) ? 0 : souttime.hashCode());
		result = prime * result + unumber;
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
		Sign other = (Sign) obj;
		if (sdate == null) {
			if (other.sdate != null)
				return false;
		} else if (!sdate.equals(other.sdate))
			return false;
		if (sid != other.sid)
			return false;
		if (sinstatus == null) {
			if (other.sinstatus != null)
				return false;
		} else if (!sinstatus.equals(other.sinstatus))
			return false;
		if (sintime == null) {
			if (other.sintime != null)
				return false;
		} else if (!sintime.equals(other.sintime))
			return false;
		if (soutstatus == null) {
			if (other.soutstatus != null)
				return false;
		} else if (!soutstatus.equals(other.soutstatus))
			return false;
		if (souttime == null) {
			if (other.souttime != null)
				return false;
		} else if (!souttime.equals(other.souttime))
			return false;
		if (unumber != other.unumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sign [sid=" + sid + ", unumber=" + unumber + ", sintime="
				+ sintime + ", sinstatus=" + sinstatus + ", souttime="
				+ souttime + ", soutstatus=" + soutstatus + ", sdate=" + sdate
				+ "]";
	}

}
