
package ru.smartsarov.video.json;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CameraStream implements Serializable {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("port")
    @Expose
    private Integer port;
    @SerializedName("camera")
    @Expose
    private Integer camera;
    private final static long serialVersionUID = 1316708727568376794L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CameraStream() {
    }

    /**
     * 
     * @param port
     * @param id
     * @param type
     * @param camera
     * @param url
     */
    public CameraStream(String url, String type, Integer id, Integer port, Integer camera) {
        super();
        this.url = url;
        this.type = type;
        this.id = id;
        this.port = port;
        this.camera = camera;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getCamera() {
        return camera;
    }

    public void setCamera(Integer camera) {
        this.camera = camera;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CameraStream.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("port");
        sb.append('=');
        sb.append(((this.port == null)?"<null>":this.port));
        sb.append(',');
        sb.append("camera");
        sb.append('=');
        sb.append(((this.camera == null)?"<null>":this.camera));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
