package emlakcepte.service;

import emlakcepte.client.Banner;
import emlakcepte.client.BannerServiceClient;
import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.model.enums.HousingType;
import emlakcepte.model.enums.RealtyType;
import emlakcepte.model.enums.UserType;
import emlakcepte.repository.RealtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RealtyService {

    @Autowired
    private RealtyRepository realtyDao;

    @Autowired
    private BannerServiceClient bannerServiceClient;

    public void create(Realty realty) {

        if (UserType.INDIVIDUAL.equals(realty.getUser().getType()) && realty.getHousingType().equals(HousingType.RESIDENTIAL)) {
            if (realty.getUser().getRealtyList().size() > 3) {
                System.out.println("Individual users can post up to 3 ads.");
            }
        } else {
            realtyDao.saveRealty(realty);
            System.out.println("createRealty :: " + realty);
        }

        Banner bannerRequest = new Banner(String.valueOf(realty.getNo()), 1, "123123", "");

        Banner bannerResponse = bannerServiceClient.create(bannerRequest);

        if (bannerResponse.getAdet() > 1) {
            System.out.println("Error! ");
        }
    }

    public List<Realty> getAll() {
        return realtyDao.findAll();
    }

    public void printAll(List<Realty> realtyList) {
        realtyList.forEach(realty -> System.out.println(realty));
    }

    //search by city
    public void getAllByProvince(String province) {

        getAll().stream().filter(realty -> realty.getProvince().equals(province))
                // .count();
                .forEach(realty -> System.out.println(realty));

    }

    //search by district
    public void getAllByDistrict(String district) {

        getAll().stream()
                .filter(realty -> realty.getDistrict().equals(district))
                .forEach(realty -> System.out.println(realty));

    }

    public void getAllByProvinceAndByHousingType(Realty realty) {
        getAll().stream()
                .filter(re -> re.getProvince().equals(realty.getProvince()))
                .filter(re -> HousingType.RESIDENTIAL.equals(realty.getHousingType()))
                .collect(Collectors.toList());
    }

    public List<Realty> getAllByUserName(User user) {
        return getAll().stream()
                .filter(realty -> realty.getUser().getMail().equals(user.getMail()))
                .collect(Collectors.toList());
    }

    public Integer getAllNumberOfProvincePostings(String province) {
        return Math.toIntExact(getAll().stream()
                .filter(realty -> realty.getProvince().equals(province))
                .count());
    }

    public long getRealtyNumberInProvince(List<String> provinces) {
        return getAll().stream()
                .filter(realty -> provinces.contains(realty.getProvince()))
                .count();
    }

    public void showcaseProvince(String province) {
        getAll().stream()
                .filter(realty -> realty.getProvince().equals(province))
                .limit(10)
                .forEach(realty -> System.out.println(realty));
    }


    public List<Realty> getActiveRealtyByUserName(User user) {
        return getAll().stream().filter(realty -> realty.getUser().getName().equals(user.getName()))
                .filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus())).collect(Collectors.toList());
    }

}







