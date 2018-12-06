package ru.smartsarov.video;

import static ru.smartsarov.video.Constants.WWW24OKO_STREET_CAMERA_PROPERTIES_URL;
import static ru.smartsarov.video.Constants.WWW24OKO_STREET_CAMERA_STREAM_URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jsoup.Jsoup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import ru.smartsarov.video.json.CameraProperty;
import ru.smartsarov.video.json.CameraStream;

@Path("/")
//@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
@Produces(MediaType.APPLICATION_JSON)
public class Video {
	@GET
    public Response index() {
		try(InputStream is = this.getClass().getResourceAsStream("/static/index.html")) {
			return Response.status(Response.Status.OK).entity(is).build();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
		}
    }

	@GET
	@Path("/krsn")
    public Response getCameras() {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/static/cameraProperties"), StandardCharsets.UTF_8))) {
			return Response.status(Response.Status.OK).entity(br.lines().collect(Collectors.joining(System.lineSeparator()))).build();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
		}
	}
	
	@GET
	@Path("/k")
    public Response setCameras() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<CameraProperty> cameraProperties;
		StringBuilder sb = new StringBuilder();
		
		try {
			String cProperties = Jsoup.connect(WWW24OKO_STREET_CAMERA_PROPERTIES_URL).ignoreContentType(true).get().text();
			cameraProperties = gson.fromJson(cProperties, new TypeToken<List<CameraProperty>>(){}.getType());
			
			String cStreams = Jsoup.connect(WWW24OKO_STREET_CAMERA_STREAM_URL).ignoreContentType(true).get().text();
			List<CameraStream> cameraStreams = gson.fromJson(cStreams, new TypeToken<List<CameraStream>>(){}.getType());
			
			//cameraProperties.stream().filter(cp -> cameraStreams.stream().filter(cs -> cs.equals(cp.getId()))).;
			
			for (CameraProperty cp : cameraProperties) {
				for (CameraStream cs : cameraStreams) {
					if (cp.getId().equals(cs.getId())) {
						cp.setCamera(cs.getCamera());
						cp.setUrl(cs.getUrl());
					}
				}
				cp.setPort(8082);

				if (cp.getUrl() != null) {
					String cameraUrl = "http://".concat(cp.getIp().concat(":").concat(String.valueOf(cp.getPort())).concat("/").concat(cp.getUrl()).concat("/"));
					cp.setPreview(cameraUrl.concat("preview.jpg"));

					/*byte[] b = Jsoup.connect("http://".concat(cp.getPreview())).ignoreContentType(true).execute().bodyAsBytes();
					String str = Base64.getEncoder().encodeToString(b);
					cp.setScreenshot(str);*/
					cp.setVideoStream(cameraUrl.concat("embed.html"));
				} else {
					sb.append(cp.getId()).append(System.lineSeparator());
				}
			}

			try (OutputStream fos = Files.newOutputStream(Paths.get("cameraProperties"), StandardOpenOption.CREATE)) {
				cameraProperties = cameraProperties.stream().filter(cp -> cp.getUrl() != null).collect(Collectors.toList());
				fos.write(gson.toJson(cameraProperties).getBytes());
				//fos.write(System.lineSeparator().concat(sb.toString()).getBytes());
				fos.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
		}
		
		return Response.status(Response.Status.OK).entity(gson.toJson(cameraProperties)).build();
    }
	
	/*private void insert2Table() {
		
	}*/
	
	//CREATE TABLE `video` ( `id` INTEGER NOT NULL, `longitude` REAL, `latitude` REAL, `propertyId` INTEGER, `radius` REAL, `mapId` TEXT, `sidegroupId` TEXT, `ip` TEXT, `district` TEXT, `public` INTEGER, `angle` REAL, `name` TEXT, `sector` REAL, `groupId` INTEGER, `camera` INTEGER, `port` INTEGER, `url` TEXT, `preview` TEXT, `screenshot` BLOB, `videoStream` TEXT, PRIMARY KEY(`id`) )
}