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
	@Column	private String userId;
	@Id
	@Column	private String providerId;
	@Id
	@Column	private String providerUserId;
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
			String userId,
			String providerId,
			String providerUserId,
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
		this.userId = userId;
		this.providerId = providerId;
		this.rank = rank;
		this.providerUserId = providerUserId;
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
		
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	public String getProviderId()
	{
		return providerId;
	}
	public void setProviderId(String providerId)
	{
		this.providerId = providerId;
	}
	
	public String getProviderUserId()
	{
		return providerUserId;
	}
	public void setProviderUserId(String providerUserId)
	{
		this.providerUserId = providerUserId;
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
