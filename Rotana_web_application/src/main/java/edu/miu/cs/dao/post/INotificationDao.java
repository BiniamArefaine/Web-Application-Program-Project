package edu.miu.cs.dao.post;

import edu.miu.cs.dao.IGenericJpaDao;
import edu.miu.cs.domain.Notification;
import edu.miu.cs.domain.User;

import java.util.List;

public interface INotificationDao extends IGenericJpaDao<Long, Notification> {
    public  abstract  List<Notification> getNotificationsByUser(User user);
    public abstract   void updateNotifications(List<Notification> notifications);
}
//