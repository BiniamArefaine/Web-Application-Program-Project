package edu.miu.cs.service;

import edu.miu.cs.dao.user.IUserDao;
import edu.miu.cs.dao.user.UserDao;
import edu.miu.cs.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private IUserDao userDao = new UserDao();
    public List<User> getUserNearBy(User user){
        List<User> allUsers = userDao.getUserNearBy(user);
        System.out.println(Arrays.toString(allUsers.toArray()));
        List<User> followers = userDao.getUserFollowers(user);
        System.out.println(Arrays.toString(followers.toArray()));
        List<Long> userIds = followers.stream().map(s->s.getId()).collect(Collectors.toList());
        List<User> finalUsers = allUsers.stream().filter(s->userIds.contains(s.getId())==false).collect(Collectors.toList());
        System.out.println(Arrays.toString(finalUsers.toArray()));


        return finalUsers;
    }//
}
