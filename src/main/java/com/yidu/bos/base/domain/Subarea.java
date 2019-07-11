package com.yidu.bos.base.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Subarea {
	@NotNull
	@Length(min=1,max=15)
	private String subareaId;
	@NotNull
	@Length(min=1,max=15)
	private String sortCode;
	@NotNull
	@Length(min=1,max=15)
	private String subarea;
	@NotNull
	@Length(min=1,max=15)
	private String position;
	@NotNull
	@Length(min=1,max=15)
	private String areaId;
	@NotNull
	@Length(min=1,max=15)
	private String province;
	@NotNull
	@Length(min=1,max=15)
	private String city;
	@NotNull
	@Length(min=1,max=15)
	private String county;
	@NotNull
	@Length(min=1,max=15)
	private String setAreaId;
	@NotNull
	@Length(min=1,max=15)
	private String setArea;
	
	private String keyword;
	@NotNull
	@Length(min=1,max=15)
	private String startNo;
	@NotNull
	@Length(min=1,max=15)
	private String endNo;
	@NotNull
	@Length(min=1,max=15)
	private String oddEvenNo;
	@NotNull
	@Length(min=1,max=15)
	private String auxColumn;
	@NotNull
	@Length(min=1,max=15)
	private String useable;
	@NotNull
	@Length(min=1,max=15)
	private String sacDesc;
	public Subarea() {
		super();
	}
	







	public Subarea(String subareaId, String subarea, String province) {
		super();
		this.subareaId = subareaId;
		this.subarea = subarea;
		this.province = province;
	}








	public Subarea(String subareaId, String sortCode, String subarea, String position, String areaId, String province,
			String city, String county, String setAreaId, String setArea, String keyword, String startNo, String endNo,
			String oddEvenNo, String auxColumn, String useable, String sacDesc) {
		super();
		this.subareaId = subareaId;
		this.sortCode = sortCode;
		this.subarea = subarea;
		this.position = position;
		this.areaId = areaId;
		this.province = province;
		this.city = city;
		this.county = county;
		this.setAreaId = setAreaId;
		this.setArea = setArea;
		this.keyword = keyword;
		this.startNo = startNo;
		this.endNo = endNo;
		this.oddEvenNo = oddEvenNo;
		this.auxColumn = auxColumn;
		this.useable = useable;
		this.sacDesc = sacDesc;
	}
	public String getSubareaId() {
		return subareaId;
	}
	public void setSubareaId(String subareaId) {
		this.subareaId = subareaId;
	}
	public String getSortCode() {
		return sortCode;
	}
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
	public String getSubarea() {
		return subarea;
	}
	public void setSubarea(String subarea) {
		this.subarea = subarea;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getSetAreaId() {
		return setAreaId;
	}
	public void setSetAreaId(String setAreaId) {
		this.setAreaId = setAreaId;
	}
	public String getSetArea() {
		return setArea;
	}
	public void setSetArea(String setArea) {
		this.setArea = setArea;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getStartNo() {
		return startNo;
	}
	public void setStartNo(String startNo) {
		this.startNo = startNo;
	}
	public String getEndNo() {
		return endNo;
	}
	public void setEndNo(String endNo) {
		this.endNo = endNo;
	}
	public String getOddEvenNo() {
		return oddEvenNo;
	}
	public void setOddEvenNo(String oddEvenNo) {
		this.oddEvenNo = oddEvenNo;
	}
	public String getAuxColumn() {
		return auxColumn;
	}
	public void setAuxColumn(String auxColumn) {
		this.auxColumn = auxColumn;
	}
	public String getUseable() {
		return useable;
	}
	public void setUseable(String useable) {
		this.useable = useable;
	}
	public String getSacDesc() {
		return sacDesc;
	}
	public void setSacDesc(String sacDesc) {
		this.sacDesc = sacDesc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaId == null) ? 0 : areaId.hashCode());
		result = prime * result + ((auxColumn == null) ? 0 : auxColumn.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((county == null) ? 0 : county.hashCode());
		result = prime * result + ((endNo == null) ? 0 : endNo.hashCode());
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + ((oddEvenNo == null) ? 0 : oddEvenNo.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((sacDesc == null) ? 0 : sacDesc.hashCode());
		result = prime * result + ((setArea == null) ? 0 : setArea.hashCode());
		result = prime * result + ((setAreaId == null) ? 0 : setAreaId.hashCode());
		result = prime * result + ((sortCode == null) ? 0 : sortCode.hashCode());
		result = prime * result + ((startNo == null) ? 0 : startNo.hashCode());
		result = prime * result + ((subarea == null) ? 0 : subarea.hashCode());
		result = prime * result + ((subareaId == null) ? 0 : subareaId.hashCode());
		result = prime * result + ((useable == null) ? 0 : useable.hashCode());
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
		Subarea other = (Subarea) obj;
		if (areaId == null) {
			if (other.areaId != null)
				return false;
		} else if (!areaId.equals(other.areaId))
			return false;
		if (auxColumn == null) {
			if (other.auxColumn != null)
				return false;
		} else if (!auxColumn.equals(other.auxColumn))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (county == null) {
			if (other.county != null)
				return false;
		} else if (!county.equals(other.county))
			return false;
		if (endNo == null) {
			if (other.endNo != null)
				return false;
		} else if (!endNo.equals(other.endNo))
			return false;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (oddEvenNo == null) {
			if (other.oddEvenNo != null)
				return false;
		} else if (!oddEvenNo.equals(other.oddEvenNo))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (sacDesc == null) {
			if (other.sacDesc != null)
				return false;
		} else if (!sacDesc.equals(other.sacDesc))
			return false;
		if (setArea == null) {
			if (other.setArea != null)
				return false;
		} else if (!setArea.equals(other.setArea))
			return false;
		if (setAreaId == null) {
			if (other.setAreaId != null)
				return false;
		} else if (!setAreaId.equals(other.setAreaId))
			return false;
		if (sortCode == null) {
			if (other.sortCode != null)
				return false;
		} else if (!sortCode.equals(other.sortCode))
			return false;
		if (startNo == null) {
			if (other.startNo != null)
				return false;
		} else if (!startNo.equals(other.startNo))
			return false;
		if (subarea == null) {
			if (other.subarea != null)
				return false;
		} else if (!subarea.equals(other.subarea))
			return false;
		if (subareaId == null) {
			if (other.subareaId != null)
				return false;
		} else if (!subareaId.equals(other.subareaId))
			return false;
		if (useable == null) {
			if (other.useable != null)
				return false;
		} else if (!useable.equals(other.useable))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Subarea [subareaId=" + subareaId + ", sortCode=" + sortCode + ", subarea=" + subarea + ", position="
				+ position + ", areaId=" + areaId + ", province=" + province + ", city=" + city + ", county=" + county
				+ ", setAreaId=" + setAreaId + ", setArea=" + setArea + ", keyword=" + keyword + ", startNo=" + startNo
				+ ", endNo=" + endNo + ", oddEvenNo=" + oddEvenNo + ", auxColumn=" + auxColumn + ", useable=" + useable
				+ ", sacDesc=" + sacDesc + "]";
	}
	
	
}
