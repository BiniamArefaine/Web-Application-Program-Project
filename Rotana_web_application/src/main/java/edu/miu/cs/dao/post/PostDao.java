package edu.miu.cs.dao.post;
import javax.persistence.*;
import edu.miu.cs.dao.GenericJpaDao;
import edu.miu.cs.domain.Post;
import edu.miu.cs.domain.User;

import java.util.List;

public class PostDao extends GenericJpaDao<Long, Post> implements IPostDao {

    public PostDao(){
        entityClass = Post.class;
    }

    @Override
    public List<Post> getPostsUserHome(User userId) {
        String uid = ""+userId.getId();
        String sql = "SELECT distinct posts.* from follow,posts where  (posts.USER_ID = follow.follower_ID and follow.followed_ID = " + uid+ " ) or posts.USER_ID = " + uid+ " ORDER BY posts.TIME desc";
        Query q = manager.createNativeQuery(sql,Post.class);
        List<Post> posts = q.getResultList();
        return posts;
    }//

    @Override
    public List<Post> getPostsUserHomePaged(User userId, Integer start, Integer interval) {
        return null;
    }

    @Override
    public List<Post> getPostsByUser(User user) {
        String uid = ""+ user.getId();
        String sql = "SELECT  posts.* from posts where posts.USER_ID = " + uid+ " ORDER BY posts.TIME desc";
        Query q = manager.createNativeQuery(sql,Post.class);
        List<Post> posts = q.getResultList();
        return posts;
    }
}
