
package ru.smartsarov.video.json;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CameraProperty implements Serializable {
	private final static long serialVersionUID = -5925917218909866227L;
	
	@SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("propertyId")
    @Expose
    private Integer propertyId;
    @SerializedName("radius")
    @Expose
    private Double radius;
    @SerializedName("mapId")
    @Expose
    private String mapId;
    @SerializedName("sidegroupId")
    @Expose
    private String sidegroupId;
    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("district")
    @Expose
    private String district;
    @SerializedName("public")
    @Expose
    private Boolean _public;
    @SerializedName("angle")
    @Expose
    private Double angle;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sector")
    @Expose
    private Double sector;
    @SerializedName("groupId")
    @Expose
    private Integer groupId;
    
    @SerializedName("camera")
    @Expose
    private Integer camera;
    
    @SerializedName("port")
    @Expose
    private Integer port;
    
    @SerializedName("url")
    @Expose
    private String url;
    
    @SerializedName("preview")
    @Expose
    private String preview;
    
    @SerializedName("screenshot")
    @Expose
    private String screenshot;
    
    @SerializedName("videoStream")
    @Expose
    private String videoStream;

    @SerializedName("available")
    @Expose
    private Integer available;
    
    /**
     * No args constructor for use in serialization
     * 
     */
    public CameraProperty() {
    }

    /**
     * 
     * @param _public
     * @param ip
     * @param latitude
     * @param groupId
     * @param sidegroupId
     * @param district
     * @param name
     * @param angle
     * @param mapId
     * @param id
     * @param radius
     * @param propertyId
     * @param sector
     * @param longitude
     */
    public CameraProperty(Double longitude, Integer propertyId, Double radius, String mapId, String sidegroupId, String ip, Integer id, Double latitude, String district, Boolean _public, Double angle, String name, Double sector, Integer groupId) {
        super();
        this.longitude = longitude;
        this.propertyId = propertyId;
        this.radius = radius;
        this.mapId = mapId;
        this.sidegroupId = sidegroupId;
        this.ip = ip;
        this.id = id;
        this.latitude = latitude;
        this.district = district;
        this._public = _public;
        this.angle = angle;
        this.name = name;
        this.sector = sector;
        this.groupId = groupId;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public String getSidegroupId() {
        return sidegroupId;
    }

    public void setSidegroupId(String sidegroupId) {
        this.sidegroupId = sidegroupId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Object getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Boolean getPublic() {
        return _public;
    }

    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSector() {
        return sector;
    }

    public void setSector(Double sector) {
        this.sector = sector;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getCamera() {
		return camera;
	}

	public void setCamera(Integer camera) {
		this.camera = camera;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getVideoStream() {
		return videoStream;
	}

	public void setVideoStream(String videoStream) {
		this.videoStream = videoStream;
	}

	public String getScreenshot() {
		return screenshot;
	}

	public void setScreenshot(String screenshot) {
		this.screenshot = screenshot;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CameraProperty.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("longitude");
        sb.append('=');
        sb.append(((this.longitude == null)?"<null>":this.longitude));
        sb.append(',');
        sb.append("propertyId");
        sb.append('=');
        sb.append(((this.propertyId == null)?"<null>":this.propertyId));
        sb.append(',');
        sb.append("radius");
        sb.append('=');
        sb.append(((this.radius == null)?"<null>":this.radius));
        sb.append(',');
        sb.append("mapId");
        sb.append('=');
        sb.append(((this.mapId == null)?"<null>":this.mapId));
        sb.append(',');
        sb.append("sidegroupId");
        sb.append('=');
        sb.append(((this.sidegroupId == null)?"<null>":this.sidegroupId));
        sb.append(',');
        sb.append("ip");
        sb.append('=');
        sb.append(((this.ip == null)?"<null>":this.ip));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("latitude");
        sb.append('=');
        sb.append(((this.latitude == null)?"<null>":this.latitude));
        sb.append(',');
        sb.append("district");
        sb.append('=');
        sb.append(((this.district == null)?"<null>":this.district));
        sb.append(',');
        sb.append("_public");
        sb.append('=');
        sb.append(((this._public == null)?"<null>":this._public));
        sb.append(',');
        sb.append("angle");
        sb.append('=');
        sb.append(((this.angle == null)?"<null>":this.angle));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("sector");
        sb.append('=');
        sb.append(((this.sector == null)?"<null>":this.sector));
        sb.append(',');
        sb.append("groupId");
        sb.append('=');
        sb.append(((this.groupId == null)?"<null>":this.groupId));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
