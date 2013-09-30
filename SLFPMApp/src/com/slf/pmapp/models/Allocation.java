package com.slf.pmapp.models;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="sunlife_allocations")
public class Allocation
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
    @JoinColumn(name="ResourceID")
	private Resource resource;
	@ManyToOne
    @JoinColumn(name="TrackID")
	private Track track;
	@Column	private int resourceID;
	@Column private int trackID; 
	@Column private String ACF2ID; 
	@Column private String VPNToken;
	@Column private String BillingStatus; 
	@Column private Date ProjStartDate;
	@Column private Date ProjEndDate;
	@Column private int PercentAllocation; 
	@Column private String ProjectModule; 
	@Column private String SunLifeLead; 
	@Column private String Role; 
	
	public Allocation()
	{
	}
	
	public Allocation(int id,
			int resourceID,
			Resource resource,
			Track track,
			int trackID,
			String ACF2ID, 
			String VPNToken,
			String BillingStatus, 
			Date ProjStartDate,
			Date ProjEndDate,
			int PercentAllocation, 
			String ProjectModule,
			String SunLifeLead,
			String Role)
	{
		super();
		this.id = id;
		this.resourceID = resourceID;
		this.resource = resource;
		this.track = track;
		this.trackID = trackID;
		this.ACF2ID = ACF2ID;
		this.VPNToken = VPNToken;
		this.BillingStatus = BillingStatus;
		this.ProjStartDate = ProjStartDate;
		this.ProjEndDate = ProjEndDate;
		this.PercentAllocation = PercentAllocation;
		this.ProjectModule = ProjectModule;
		this.SunLifeLead = SunLifeLead;
		this.Role = Role;
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
	
	
    public Resource getResource() {
        return resource;
    }
	
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Track getTrack() {
        return track;
    }
	
    public void setTrack(Track track) {
        this.track = track;
    }
    
    public int getResourceID()
	{
		return resourceID;
	}
	public void setResourceID(int resourceID)
	{
		this.resourceID = resourceID;
	}
	
	public int getTrackId()
	{
		return trackID;
	}
	public void setTrackId(int trackID)
	{
		this.trackID = trackID;
	}
	
	public String getACF2ID()
	{
		return ACF2ID;
	}
	public void setACF2ID(String ACF2ID)
	{
		this.ACF2ID = ACF2ID;
	}
	
	public String getVPNToken()
	{
		return VPNToken;
	}
	public void setVPNToken(String VPNToken)
	{
		this.VPNToken = VPNToken;
	}
	
	public String getbillingStatus()
	{
		return BillingStatus;
	}
	public void setbillingStatus(String BillingStatus)
	{
		this.BillingStatus = BillingStatus;
	}
	
	public Date getprojStartDate()
	{
		return ProjStartDate;
	}
	public void setprojStartDate(Date ProjStartDate)
	{
		this.ProjStartDate = ProjStartDate;
	}
	
	public Date getprojEndDate()
	{
		return ProjEndDate;
	}
	public void setprojEndDate(Date ProjEndDate)
	{
		this.ProjEndDate = ProjEndDate;
	}
	
	public int getpercentAllocation()
	{
		return PercentAllocation;
	}
	public void setpercentAllocation(int PercentAllocation)
	{
		this.PercentAllocation = PercentAllocation;
	}
	
	public String getprojectModule()
	{
		return ProjectModule;
	}
	public void setprojectModule(String ProjectModule)
	{
		this.ProjectModule = ProjectModule;
	}
	
	public String getsunLifeLead()
	{
		return SunLifeLead;
	}
	public void setsunLifeLead(String SunLifeLead)
	{
		this.SunLifeLead = SunLifeLead;
	}
	
	public String getrole()
	{
		return Role;
	}
	public void setrole(String Role)
	{
		this.Role = Role;
	}
}