<div class="central-meta">
    <div class="editing-interest">
        <h5 class="f-title"><i class="ti-bell"></i>All Notifications </h5>
        <div class="notification-box">
            <ul>
                <c:forEach var="notf" items="${notifications}">
                <li>
                    <figure>
                        <c:if test="${empty notf.user.image}">
                        <img src="images/resources/friend-avatar.jpg" alt="">
                        </c:if>

                        <c:if test="${not empty notf.user.image}">
                            <img src="uploads/user/display/${notf.user.image}" alt="">
                        </c:if>
                    </figure>

                    <div class="notifi-meta">
                        <p>${notf.details}</p>
                        <span>${notf.notTime}</span>
                    </div>
                    <i class="del fa fa-close"></i>
                </li>
                </c:forEach>

            </ul>
        </div>
    </div>
</div>
</div><!-- centerl meta --><%----%>