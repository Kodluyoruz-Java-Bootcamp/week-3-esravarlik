package emlakcepte.controller;

import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/realtyes")
public class RealtyController {

    @Autowired
    private RealtyService realtyService;

    @GetMapping
    public List<Realty> getAll() {
        return realtyService.getAll();
    }

    @GetMapping("/{province}")
    public void getAllByProvince(@PathVariable String province) {
        realtyService.getAllByProvince(province);
    }

    @GetMapping("/{district}")
    public void getAllByDistrict(@PathVariable String district) {
        realtyService.getAllByDistrict(district);
    }

    @GetMapping("/housingTypes")
    public void getAllByProvinceAndByHousingType(@RequestBody Realty realty) {
        realtyService.getAllByProvinceAndByHousingType(realty);

    }

    @GetMapping("/userNames")
    public List<Realty> getAllByUserName(@RequestBody User user) {
        return realtyService.getAllByUserName(user);
    }

    @GetMapping("/{province}/number")
    public Integer getAllNumberOfProvincePostings(@PathVariable String province) {
        return realtyService.getAllNumberOfProvincePostings(province);
    }

    @GetMapping("/provinces")
    public long getRealtyNumberInProvince(@RequestParam List<String> provinces) {
        return realtyService.getRealtyNumberInProvince(provinces);
    }

    @GetMapping("/{province}/limit")
    public void showcaseProvince(@PathVariable String province) {
        realtyService.showcaseProvince(province);
    }

    @GetMapping("/userName")
    public List<Realty> getActiveRealtyByUserName(@RequestBody User user) {
        return realtyService.getActiveRealtyByUserName(user);
    }

    @PostMapping
    public ResponseEntity<Realty> create(@RequestBody Realty realty) {
        System.out.println("realty" + realty);
        realtyService.create(realty);
        return new ResponseEntity<>(realty, HttpStatus.CREATED);
    }

}




