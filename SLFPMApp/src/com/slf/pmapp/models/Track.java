package com.slf.pmapp.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="sunlife_tracks")
public class Track
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column	private String name;
	@Column private String product; 
	@Column private String location; 
	@Column private String technology; 
	@Column private String clientowner;
	@Column private int hourlyrate; 
	
	public Track()
	{
	}
	
	public Track(int id, String name, String product, String location,
			String technology, String clientowner, int hourlyrate)
	{
		super();
		this.id = id;
		this.name = name;
		this.product = product;
		this.location = location;
		this.technology = technology;
		this.clientowner = clientowner;
		this.hourlyrate = hourlyrate;
	}
	@Override
	public String toString()
	{
		//return ToStringBuilder.reflectionToString(this);
		return "Track";
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
	public String getProduct()
	{
		return product;
	}
	public void setProduct(String product)
	{
		this.product = product;
	}
	public String getLocation()
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public String getTechnology()
	{
		return technology;
	}
	public void setTechnology(String technology)
	{
		this.technology = technology;
	}
	public String getClientowner()
	{
		return clientowner;
	}
	public void setClientowner(String clientowner)
	{
		this.clientowner = clientowner;
	}
	public int getHourlyrate()
	{
		return hourlyrate;
	}
	public void setHourlyrate(int hourlyrate)
	{
		this.hourlyrate = hourlyrate;
	}	
}



