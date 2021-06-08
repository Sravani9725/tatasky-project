package com.cg.pack.entities;

import java.util.Comparator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name = "Pack")
public class Pack implements Comparable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long packId;
	
	@Column(name = "PackName")
	@NotNull
	@Size(min=2,message = "Name Should be Minimum of Two Characters")
	private String packName;
	
	@Column(name = "PackValidity")
	@Size(min=2,message = "Validity name Should be Minimum of Two Characters")
	private String packValidity;
	
	@Column(name = "PackCost")
	public double packCost;
	
	@Column(name = "PackDescription")
	@Size(min=10,message = "Description Should be Minimum of Ten Characters")
	private String packDescription;
	//@Column(name = "Channels")
	//private List<String> channels;

	public Pack() {
		super();
	}

	public long getPackId() {
		return packId;
	}

	public void setPackId(long packId) {
		this.packId = packId;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public String getPackValidity() {
		return packValidity;
	}

	public void setPackValidity(String packValidity) {
		this.packValidity = packValidity;
	}

	public double getPackCost() {
		return packCost;
	}

	public void setPackCost(double packCost) {
		this.packCost = packCost;
	}

	public String getPackDescription() {
		return packDescription;
	}

	public void setPackDescription(String packDescription) {
		this.packDescription = packDescription;
	}

	/*public List<String> getChannels() {
		return channels;
	}

	public void setChannels(List<String> channels) {
		this.channels = channels;
	}*/

	@Override
	public String toString() {
		return "Pack [packId=" + packId + ", packName=" + packName + ", packValidity=" + packValidity + ", packCost="
				+ packCost + ", packDescription=" + packDescription + "]";
	}

	
	@Override
	public int compareTo(Object o) {
	    Pack p = (Pack) o;
	    if(this.packCost > p.packCost )
	    {
	     return 1;
	    }
	    else
		return -1;

	}
	

	
	

}
