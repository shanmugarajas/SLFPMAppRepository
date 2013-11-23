package com.slf.pmapp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userconnection")
public class Userconnection {
	@Id
	@Column(name = "userId")
	private String userid;
	@Column(name = "providerId")
	private String providerid;
	@Column(name = "providerUserId")
	private String provideruserid;
	@Column	private int rank;
	@Column	private String displayName;
	@Column	private String profileUrl;
	@Column	private String imageUrl;
	@Column	private String accessToken;
	@Column	private String secret;
	@Column	private String refreshToken;
	@Column	private long expireTime;
	
	public Userconnection()
	{
	}
	
	public Userconnection(int id,
			String userid,
			String providerid,
			String provideruserid,
			int rank, 
			String displayName,
			String profileUrl,
			String imageUrl, 
			String accessToken,
			String secret,
			String refreshToken, 
			long expireTime
			)
	{
		super();
		this.userid = userid;
		this.providerid = providerid;
		this.rank = rank;
		this.provideruserid = provideruserid;
		this.displayName = displayName;
		this.profileUrl = profileUrl;
		this.imageUrl = imageUrl;
		this.accessToken = accessToken;
		this.secret = secret;
		this.refreshToken = refreshToken;
		this.expireTime = expireTime;
	}
	@Override
	public String toString()
	{
		//return ToStringBuilder.reflectionToString(this);
		return "Userconnection";
	}
		
	public String getUserid()
	{
		System.out.println(this.getClass().toString() + " : userid");
		return userid;
	}
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
	
	public String getproviderid()
	{
		return providerid;
	}
	public void setProviderid(String providerid)
	{
		this.providerid = providerid;
	}
	
	public String getProvideruserid()
	{
		return provideruserid;
	}
	public void setProvideruserid(String provideruserid)
	{
		this.provideruserid = provideruserid;
	}
	
	public int getRank()
	{
		return rank;
	}
	public void setRank(int rank)
	{
		this.rank = rank;
	}
	
	public String getDisplayName()
	{
		return displayName;
	}
	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}
	
	public String getProfileUrl()
	{
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl)
	{
		this.profileUrl = profileUrl;
	}
	
	public String getImageUrl()
	{
		return imageUrl;
	}
	public void setImageUrl(String imageUrl)
	{
		this.imageUrl = imageUrl;
	}
	
	public String getAccessToken()
	{
		return accessToken;
	}
	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}
	
	public String getSecret()
	{
		return secret;
	}
	public void setSecret(String secret)
	{
		this.secret = secret;
	}
	
	public String getRefreshToken()
	{
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken)
	{
		this.refreshToken = refreshToken;
	}
	
	public long getExpireTime()
	{
		return expireTime;
	}
	public void setExpireTime(long expireTime)
	{
		this.expireTime = expireTime;
	}
}
