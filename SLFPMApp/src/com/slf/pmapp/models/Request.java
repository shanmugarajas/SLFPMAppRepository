package com.slf.pmapp.models;

import java.util.Date;

import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="requests")
public class Request
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
		
	@Column	private String requestid;
	@Column private Date requestdate; 
	@Column private String role; 
	@Column private String track;
	@Column private int percentallocation; 
	@Column private String projectmodule; 
	@Column private String sunlifelead; 
	@Column private String status;
	@Column private Date expectedclosuredate;
	
	public Request()
	{
	}
	
	public Request(int id,
			String requestid,
			Date requestdate,
			String role, 
			String track,
			int percentallocation,
			String projectmodule, 
			String sunlifelead,
			String status,
			Date expectedclosuredate)
	{
		super();
		this.id = id;
		this.requestid = requestid;
		this.requestdate = requestdate;
		this.role = role;
		this.track = track;
		this.percentallocation = percentallocation;
		this.projectmodule = projectmodule;
		this.sunlifelead = sunlifelead;
		this.status = status;
		this.expectedclosuredate = expectedclosuredate;
	}
	@Override
	public String toString()
	{
		//return ToStringBuilder.reflectionToString(this);
		return "Request";
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	 
    public String getRequestid()
	{
		return requestid;
	}
	public void setRequestid(String requestid)
	{
		this.requestid = requestid;
	}
	
	public Date getRequestdate()
	{
		return requestdate;
	}
	public void setRequestdate(Date requestdate)
	{
		this.requestdate = requestdate;
	}
	
	public String getRole()
	{
		return role;
	}
	public void setRole(String role)
	{
		this.role = role;
	}
	
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public String getTrack()
	{
		return track;
	}
	public void setTrack(String track)
	{
		this.track = track;
	}
	
	public Date getExpectedclosuredate()
	{
		return expectedclosuredate;
	}
	public void setExpectedclosuredate(Date expectedclosuredate)
	{
		this.expectedclosuredate = expectedclosuredate;
	}
	
	public int getPercentallocation()
	{
		return percentallocation;
	}
	public void setPercentallocation(int percentallocation)
	{
		this.percentallocation = percentallocation;
	}
	
	public String getProjectmodule()
	{
		return projectmodule;
	}
	public void setProjectmodule(String projectmodule)
	{
		this.projectmodule = projectmodule;
	}
	
	public String getSunlifelead()
	{
		return sunlifelead;
	}
	public void setSunlifelead(String sunlifelead)
	{
		this.sunlifelead = sunlifelead;
	}
	
}