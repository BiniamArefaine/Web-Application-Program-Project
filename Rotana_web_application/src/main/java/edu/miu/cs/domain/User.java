package edu.miu.cs.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * The type User.
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "FIRST_NAME", nullable = true)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = true)
    private String lastName;

    @Column(name = "EMAIL", nullable = true)
    private String email;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "PHONE_NUMBER", nullable = true)
    private String phone;


    @Column(name = "DATE_OF_BIRTH")
    private GregorianCalendar dab;


    @Column(name = "PASSWORD", nullable = true)
    private String password;

    @Column(name = "ACCESS", nullable = true)
    private String access;

    @Column(name = "CIRY", nullable = true)
    private String city;

    @Column(name = "COUNTRY", nullable = true)
    private String country;

    @Transient
    private List<Post> posts = new ArrayList<>();

    @Column(name = "GENDER", nullable = true)
    private String gender;


    @Column(name = "ACTIVE")
    private boolean active = Boolean.TRUE;

    @Column(name = "LOGGED_IN")
    private boolean loggedIn;

    @Column(name = "TWITTER_ACCOUNT")
    private String twitterAccount;

    @Column(name = "TIMELINE_PHONE")
    private String timelinePhoto;

    @Transient
    List<User> followers = new ArrayList<>();

    @Transient
    List<User> following = new ArrayList<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }


    public User(String firstName, String lastName, String email, String password, String access, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.access = access;
        this.gender = gender;
    }


    public User(String firstName, String lastName, String email, String password, String image, String access, String gender, List<Post> posts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.image = image;
        this.access = access;
        this.gender = gender;
        this.posts = posts;
    }


    public long getId() {
        return id;
    }

    public User(String firstName, String lastName, String email, String phone, String year, String month, String day, String city, String country, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dab = dab;
        this.city = city;
        this.country = country;
        this.gender = gender;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public GregorianCalendar getDab() {
        return dab;
    }

    public void setDab(GregorianCalendar dab) {
        this.dab = dab;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getTwitterAccount() {
        return twitterAccount;
    }

    public void setTwitterAccount(String twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

    public String getTimelinePhoto() {
        return timelinePhoto;
    }

    public void setTimelinePhoto(String timelinePhoto) {
        this.timelinePhoto = timelinePhoto;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                ", phone='" + phone + '\'' +
                ", dab=" + dab +
                ", password='" + password + '\'' +
                ", access='" + access + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", posts=" + posts +
                ", gender='" + gender + '\'' +
                ", active=" + active +
                ", loggedIn=" + loggedIn +
                ", twitterAccount='" + twitterAccount + '\'' +
                ", timelinePhoto='" + timelinePhoto + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                '}';
    }//
}
