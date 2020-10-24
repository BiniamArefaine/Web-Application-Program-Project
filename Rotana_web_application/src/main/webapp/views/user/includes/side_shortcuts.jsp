<div class="widget">
    <h4 class="widget-title">Shortcuts</h4>
    <ul class="naves">
        <li>
            <i class="ti-clipboard"></i>
            <a href="home" title="">Home</a>
        </li>
        <li>
            <i class="ti-mouse-alt"></i>
            <a href="timeline?rf=${user.id}" title="">Timeline</a>
        </li>

        <li>
            <i class="ti-files"></i>
            <a href="followers" title="">Followers</a>
        </li>

        <li>
            <i class="ti-files"></i>
            <a href="following" title="">Following</a>
        </li>

        <li>
            <i class="ti-user"></i>
            <a href="peopleNearby" title="">Find Nearby Users</a>
        </li>

        <li>
            <i class="ti-bell"></i>
            <a href="notifications" title="">Notifications</a>
        </li>

        <li>
            <i class="ti-mouse-alt"></i>
            <a href="profile" title="">Profile</a>
        </li>

        <li>
            <i class="ti-power-off"></i>
            <a href="/logout" title="">Logout</a>
        </li>
    </ul>
</div>
<c:forEach var="image" items="${advertisements}" varStatus="counter">
    <c:if test="${not image.blocked}">
        <a href="${image.link}" target="_blank">
            <div class="widget">
                <h4 class="widget-title">${image.company}</h4>
                <img src="uploads/advertisements/${image.image}" alt="uploads/advertisements/${image.image}" height="50px"/>
            </div>
        </a>
    </c:if>
</c:forEach><%----%>


