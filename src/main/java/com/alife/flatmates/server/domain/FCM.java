package com.alife.flatmates.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="fcm")
public class FCM extends AbstractAuditingEntity {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
    @NotNull
    @Size(max = 7)
    @Column(name = "device_type", length = 7)
    private String deviceType;

    @NotNull
    @Size(max = 25)
    @Column(name = "device_manufacturer", length = 25)
    private String deviceManufacturer;
    
    @NotNull
    @Size(max = 25)
    @Column(name = "device_model", length = 25)
    private String deviceModel;
    
    @Size(max = 25)
    @Column(name = "device_version", length = 25)
    private String deviceVersion;
    
    @Size(max = 25)
    @Column(name = "device_version_release", length = 25)
    private String deviceVersionRelease;
    
    @Size(max = 255)
    @Column(name = "fcm_token", length = 255)
    private String fcmToken;
    
    @NotNull
    @Column(nullable = false)
    private boolean active = true;
    
    @Transient
    private String userName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType.trim().toUpperCase();
	}

	public String getDeviceVersion() {
		return deviceVersion;
	}

	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDeviceManufacturer() {
		return deviceManufacturer;
	}

	public void setDeviceManufacturer(String deviceManufacturer) {
		this.deviceManufacturer = deviceManufacturer;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getDeviceVersionRelease() {
		return deviceVersionRelease;
	}

	public void setDeviceVersionRelease(String deviceVersionRelease) {
		this.deviceVersionRelease = deviceVersionRelease;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FCM other = (FCM) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FCM [id=" + id + ", user=" + user + ", deviceType=" + deviceType + ", deviceManufacturer="
				+ deviceManufacturer + ", deviceModel=" + deviceModel + ", deviceVersion=" + deviceVersion
				+ ", deviceVersionRelease=" + deviceVersionRelease + ", fcmToken=" + fcmToken + ", active=" + active
				+ "]";
	}
    
    
}
