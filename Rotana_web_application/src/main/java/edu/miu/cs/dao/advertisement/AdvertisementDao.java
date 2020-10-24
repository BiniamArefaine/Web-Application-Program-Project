package edu.miu.cs.dao.advertisement;

import edu.miu.cs.dao.GenericJpaDao;
import edu.miu.cs.domain.Advertisement;

public class AdvertisementDao  extends GenericJpaDao<Long, Advertisement> implements IAdvertisementDao {

    public AdvertisementDao(){
        entityClass = Advertisement.class;
    }

}
//