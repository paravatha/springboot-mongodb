package org.springframework.springboot.domain;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Prasad Paravatha
 * Publisher domain class
 */
public class Publisher {
	
	@Field("id")
	private String pubId;
	private String pubName;
	private Integer founded;
	private String location;
	
	public Publisher(String pubName, Integer founded, String location) {
		this.pubName = pubName;
		this.founded = founded;
		this.location = location;
	}
	/**
	 * @return the pubId
	 */
	public String getPubId() {
		return pubId;
	}
	/**
	 * @param pubId the pubId to set
	 */
	public void setPubId(String pubId) {
		this.pubId = pubId;
	}
	/**
	 * @return the pubName
	 */
	public String getPubName() {
		return pubName;
	}
	/**
	 * @return the founded
	 */
	public Integer getFounded() {
		return founded;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param pubName the pubName to set
	 */
	public void setPubName(String pubName) {
		this.pubName = pubName;
	}
	/**
	 * @param founded the founded to set
	 */
	public void setFounded(Integer founded) {
		this.founded = founded;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
    public String toString() {
        return String.format(
                "Publisher[pubId=%s, pubName='%s', location='%s']",
                pubId, pubName, location);
    }
}
