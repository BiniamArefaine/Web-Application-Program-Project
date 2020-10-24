package edu.miu.cs.dao.post;

import edu.miu.cs.dao.GenericJpaDao;
import edu.miu.cs.domain.Comment;
import edu.miu.cs.domain.Post;

import javax.persistence.Query;
import java.util.List;

public class CommentDao extends GenericJpaDao<Long, Comment> implements ICommentDao {

    public CommentDao() {
        entityClass = Comment.class;
    }

    @Override
    public List<Comment> findCommentsByPost(Post post) {
        String uid = ""+ post.getId();
        String sql = "SELECT distinct comments.* from comments where  comments.POST_ID = " + uid+ " ORDER BY comments.TIME desc";
        Query q = manager.createNativeQuery(sql,Comment.class);
        List<Comment> comments = q.getResultList();
        return comments;
    }//
}
