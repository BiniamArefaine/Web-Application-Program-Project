<div class="central-meta">

    <ul class="nearby-contct">
        <c:forEach var="user" items="${users}">
        <li>
            <div class="nearly-pepls">
                <figure>
                    <a href="time-line.html" title="" class="nearbyUserImage"><img src="uploads/${user.image}" height="80" alt=""></a>
                </figure>
                <div class="pepl-info">
                    <h4><a href="timeline?rf=${user.id}" title="" class="nearbyUserName">${user.firstName} ${user.lastName}</a></h4>
                    <span class="nearbyUserEmail">${user.email}</span>
                    <em><i class="fa fa-map-marker"></i><span class="nearByM">2 mutual followers</span></em>
                    <a href="follow?user=${user.id}" title="" id="${user.id}_followUser" class="followUser add-butn" data-ripple="">Follow</a>
                </div>
            </div>
        </li>
        </c:forEach>


    </ul>
</div><!-- photos --><%----%>
</div><!-- centerl meta -->