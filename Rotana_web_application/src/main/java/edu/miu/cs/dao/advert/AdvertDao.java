package edu.miu.cs.dao.advert;

import edu.miu.cs.dao.GenericJpaDao;
import edu.miu.cs.domain.Advertisement;

public class AdvertDao extends GenericJpaDao<Long, Advertisement> implements IAdvertDao {

    public AdvertDao() {
        entityClass = Advertisement.class;
    }
}//