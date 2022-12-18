package emlakcepte.repository;

import emlakcepte.model.Realty;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RealtyRepository {

    private static List<Realty> realtyList = new ArrayList<>();

    public void saveRealty(Realty realty) {
        realty.getUser().getRealtyList().add(realty);
        realtyList.add(realty);
    }

    public List<Realty> findAll() {
        return realtyList;
    }

}
