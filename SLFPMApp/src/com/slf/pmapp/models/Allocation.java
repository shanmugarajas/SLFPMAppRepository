package com.slf.pmapp.models;

import java.util.Date;

import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="sunlife_allocations")
public class Allocation
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "resourceid", nullable = false, insertable = false, updatable = false)
	private Resource resource;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "trackid", nullable = false, insertable = false, updatable = false)
	private Track track;
	
	@Column	private int resourceid;
	@Column private int trackid; 
	@Column private String acf2id; 
	@Column private String vpntoken;
	@Column private Date vpnexpiry;
	@Column private String billingstatus; 
	@Column private Date projstartdate;
	@Column private Date projenddate;
	@Column private int percentallocation; 
	@Column private String projectmodule; 
	@Column private String sunlifelead; 
	@Column private String role; 
	
	public Allocation()
	{
	}
	
	public Allocation(int id,
			int resourceid,
			int trackid,
			String acf2id, 
			String vpntoken,
			Date vpnexpiry,
			String billingstatus, 
			Date projstartdate,
			Date projenddate,
			int percentallocation, 
			String projectmodule,
			String sunlifelead,
			String role)
	{
		super();
		this.id = id;
		this.resourceid = resourceid;
		this.trackid = trackid;
		this.acf2id = acf2id;
		this.vpntoken = vpntoken;
		this.vpnexpiry = vpnexpiry;
		this.billingstatus = billingstatus;
		this.projstartdate = projstartdate;
		this.projenddate = projenddate;
		this.percentallocation = percentallocation;
		this.projectmodule = projectmodule;
		this.sunlifelead = sunlifelead;
		this.role = role;
	}
	@Override
	public String toString()
	{
		//return ToStringBuilder.reflectionToString(this);
		return "Allocation";
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	 
    public int getResourceid()
	{
		return resourceid;
	}
	public void setResourceid(int resourceid)
	{
		this.resourceid = resourceid;
	}
	
	public int getTrackid()
	{
		return trackid;
	}
	public void setTrackid(int trackid)
	{
		this.trackid = trackid;
	}
	
	public String getAcf2id()
	{
		return acf2id;
	}
	public void setAcf2id(String acf2id)
	{
		this.acf2id = acf2id;
	}
	
	public String getVpntoken()
	{
		return vpntoken;
	}
	public void setVpntoken(String vpntoken)
	{
		this.vpntoken = vpntoken;
	}
	
	public Date getVpnexpiry()
	{
		return vpnexpiry;
	}
	public void setVpnexpiry(Date vpnexpiry)
	{
		this.vpnexpiry = vpnexpiry;
	}
	
	public String getBillingstatus()
	{
		return billingstatus;
	}
	public void setBillingstatus(String billingstatus)
	{
		this.billingstatus = billingstatus;
	}
	
	public Date getProjstartdate()
	{
		return projstartdate;
	}
	public void setProjstartdate(Date projstartdate)
	{
		this.projstartdate = projstartdate;
	}
	
	public Date getProjenddate()
	{
		return projenddate;
	}
	public void setProjenddate(Date projenddate)
	{
		this.projenddate = projenddate;
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
	
	public String getRole()
	{
		return role;
	}
	public void setRole(String role)
	{
		this.role = role;
	}
	
	public Resource getResource()
	{
		return resource;
	}
	
	public void setResource(Resource resource)
	{
		this.resource = resource;
	}
	
	public Track getTrack()
	{
		return track;
	}
	
	public void setTrack(Track track)
	{
		this.track = track;
	}
	
}