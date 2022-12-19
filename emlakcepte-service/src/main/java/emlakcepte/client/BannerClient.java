package emlakcepte.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/banners")
public class BannerClient {

    private final BannerService bannerService;

    public BannerClient(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @PostMapping
    ResponseEntity<Banner> create(@RequestBody Banner banner){
        return bannerService.create(banner);
    }

}
