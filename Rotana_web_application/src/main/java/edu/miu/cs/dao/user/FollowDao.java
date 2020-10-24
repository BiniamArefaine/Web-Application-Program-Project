package edu.miu.cs.dao.user;

import edu.miu.cs.dao.GenericJpaDao;
import edu.miu.cs.domain.Follow;

public class FollowDao extends GenericJpaDao<Long, Follow> implements IFollowDao {

    public FollowDao(){
        entityClass = Follow.class;
    }
}
//