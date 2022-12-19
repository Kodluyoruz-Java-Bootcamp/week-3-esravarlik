package emlakcepte.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BannerService {

    static String baseUrl = "http://localhost:8081/banners";
    private final RestTemplate restTemplate;

    public BannerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Banner> create(Banner banner) {
        ResponseEntity<Banner> toSave = restTemplate.postForEntity(baseUrl , banner, Banner.class);
        Banner ban = toSave.getBody();
        System.out.println(ban);
        return new ResponseEntity<>(ban, HttpStatus.ACCEPTED);

    }
}
