package com.slf.pmapp.models;

import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ipmfacebookprofile")
public class IpmFacebookProfile {
	@Id
	@Column private java.lang.String id;
	@Column private java.lang.String username;
	@Column private String loginname;
	@Column private java.lang.String name;
	@Column private java.lang.String firstName;
	@Column private java.lang.String lastName;
	@Column private java.lang.String gender;
	@Column private java.util.Locale locale;
	@Column private java.lang.String imgurl;
	@Column private java.lang.String link;

    public IpmFacebookProfile(){
  	
    	
    }
    
    public IpmFacebookProfile(java.lang.String id,
        java.lang.String username,
        java.lang.String name,
        String loginname,
        java.lang.String firstName,
        java.lang.String lastName,
        java.lang.String gender,
        java.util.Locale locale,
        java.lang.String imgurl,
        java.lang.String link){
	
		this.id = id;
		this.loginname = loginname;
		this.username = username;
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.locale = locale;
		this.imgurl = imgurl;
		this.link = link;
	}
    
    @Override
	public String toString()
	{
		//return ToStringBuilder.reflectionToString(this);
		return "ImpFacebookProfile";
	}
	
    public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getLoginname()
	{
		return loginname;
	}
	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	public Locale getLocale()
	{
		return locale;
	}
	public void setLocale(Locale locale)
	{
		this.locale = locale;
	}
	
	public String getImgurl()
	{
		return imgurl;
	}
	public void setImgurl(String imgurl)
	{
		this.imgurl = imgurl;
	}
	
	public String getLink()
	{
		return link;
	}
	public void setLink(String link)
	{
		this.link = link;
	}

}