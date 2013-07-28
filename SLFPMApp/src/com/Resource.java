package com;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;



@Entity
@Table(name="resources")
public class Resource
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column	private String name;
	@Column private String empid; 
	@Column private String empstatus; 
	@Column private Date dojslf; 
	@Column private String email;
	@Column private String mobile; 
	@Column private String phone;
	
	public Resource()
	{
	}
	
	public Resource(int id, String name, String empid, String empstatus,
			Date dojslf, String email, String mobile, String phone)
	{
		super();
		this.id = id;
		this.name = name;
		this.empid = empid;
		this.empstatus = empstatus;
		this.dojslf = dojslf;
		this.email = email;
		this.mobile = mobile;
		this.phone = phone;
	}
	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmpid()
	{
		return empid;
	}
	public void setEmpid(String empid)
	{
		this.empid = empid;
	}
	public String getEmpstatus()
	{
		return empstatus;
	}
	public void setEmpstatus(String empstatus)
	{
		this.empstatus = empstatus;
	}
	public Date getDojslf()
	{
		return dojslf;
	}
	public void setDojslf(Date dojslf)
	{
		this.dojslf = dojslf;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getMobile()
	{
		return mobile;
	}
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}	
}
