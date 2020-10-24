<div class="topbar stick">
    <div class="logo">
        <a title="" href="/home">
            <h3>Rotana</h3>
        </a>
    </div>
    <div class="top-area">
        <ul class="setting-area">
            <li>
                <a href="notifications" title="Notification" data-ripple="">
                    <i class="ti-bell"></i><span id="noOfNotifications">${notifications.size()}</span>
                </a>

            </li>
        </ul>
        <div class="user-img">
            <c:if test="${empty user.image}">
                <img src="../../resources/images/resources/admin.jpg" alt="">
            </c:if>
            <c:if test="${not empty user.image}">
                <img src="uploads/user/display/${user.image}" alt="" style="height: 45px">
            </c:if>
            <span class="status f-online"></span>
            <div class="user-setting">
                <a href="/profile" title=""><i class="ti-pencil-alt"></i>My profile</a>
                <a href="/logout" title=""><i class="ti-power-off"></i>Log out</a>
            </div>
        </div>
        <span class="ti-menu main-menu" data-ripple=""></span>
    </div>
</div><%----%>