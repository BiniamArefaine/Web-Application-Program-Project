<div class="feature-photo">

    <figure>
        <c:if test="${not empty timelineUser.timelinePhoto}">
            <img src="uploads/user/cover/${user.timelinePhoto}" alt="" style="height: 350px">
        </c:if>
        <c:if test="${empty timelineUser.timelinePhoto}">
            <img src="resources/images/resources/timeline-1.jpg" alt="">
        </c:if>
    </figure>
    <div class="add-btn">
        <span> ${timelineUser.followers.size()} followers</span>
        <c:if test="${not isSelf}">
        <a href="follow?user=${timelineUser.id}" title="" id="${timelineUser.id}_followUser" class="followUser" title="" data-ripple="">Follow</a>
        </c:if>
    </div>
    <form class="edit-phto" id="editCoverPhotoForm" action="editCoverPhoto" enctype="multipart/form-data">
        <i class="fa fa-camera-retro"></i>
        <c:if test="${isSelf}">
        <label class="fileContainer" id="editCoverPhotoLable">
            <span id="editCoverPhotoLabelSpan">Edit Cover Photo</span>
            <input type="file" name="coverPhoto" id="coverPhoto"/>
        </label>
        </c:if>
    </form>
    <div class="container-fluid">
        <div class="row merged">
            <div class="col-lg-2 col-sm-3">
                <div class="user-avatar">
                    <figure>
                        <c:if test="${not empty timelineUser.image}">
                            <img src="uploads/user/display/${user.image}" style="height: 170px" alt="">
                        </c:if>
                        <c:if test="${empty timelineUser.image}">
                            <img src="resources/images/resources/user-avatar.jpg" alt="">
                        </c:if>
                        <form class="edit-phto" id="displayPhotoForm" action="editDisplayPhoto" method="post" enctype="multipart/form-data">

                            <i class="fa fa-camera-retro"></i>
                            <c:if test="${isSelf}">
                                <label class="fileContainer" id="displayPhotoLabel">
                                    <span id="editDisplayPhotoLabelSpan">Edit Display Photo</span>
                                    <input type="file" name="displayPhoto" id="displayPhoto"/>
                                </label>
                            </c:if>
                        </form>
                    </figure>
                </div>
            </div>
            <div class="col-lg-10 col-sm-9">
                <div class="timeline-info">
                    <ul>
                        <li class="admin-name">

                            <a href="home" title="Home" style="text-decoration: none">
                            <h5>${timelineUser.firstName} ${timelineUser.lastName}</h5>
                            <span>${timelineUser.email}</span>
                            </a>

                        </li>
                        <li>
                            <a class="active" href="#" title="" data-ripple="">time line</a>
                            <a class="" href="#" title="" data-ripple="">Photos</a>
                            <a class="" href="followers" title="" data-ripple="">Followers</a>
                            <a class="" href="peopleNearby" title="" data-ripple="">Find Followers</a>
                            <a class="" href="profile" title="" data-ripple="">Profile</a>
                            <a class="" href="logout" title="" data-ripple="">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div><%----%>
</div>