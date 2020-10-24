package edu.miu.cs.dao.post;

import edu.miu.cs.dao.IGenericJpaDao;
import edu.miu.cs.domain.Comment;
import edu.miu.cs.domain.Post;

import java.util.List;

public interface ICommentDao extends IGenericJpaDao<Long , Comment> {
    List<Comment> findCommentsByPost(Post post);
}
//