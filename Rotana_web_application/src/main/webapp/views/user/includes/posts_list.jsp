<div id="postsList">
    <c:forEach var="post" items="${posts}">
        <div class="central-meta item">
            <div class="user-post">
                <div class="friend-info">
                    <figure>

                        <c:if test="${empty user.image}">
                        <img src="../../resources/images/resources/friend-avatar10.jpg" alt="">
                        </c:if>
                        <c:if test="${not empty user.image}">
                            <img src="uploads/user/display/${user.image}" alt="">
                        </c:if>
                    </figure>
                    <div class="friend-name">
                        <ins><a href="#" title="" class="postUserName">${post.user.firstName} ${post.user.lastName}</a>
                        </ins>
                        <span>published: ${post.time}</span>
                    </div>
                    <div class="post-meta">
                        <c:if test="${not empty post.photo}">
                        <img src="uploads/${post.photo}" alt="post image" class="postImage">
                        </c:if>
                        <div class="we-video-info">
                            <ul>
                                <li>
                                    <span class="comment" data-toggle="tooltip" title="Comments">
                                        <i class="fa fa-comments-o"></i>
                                        <ins class="commentsSize">${post.comments.size()}</ins>
                                    </span>
                                </li>
                            </ul>
                        </div>
                        <div class="description">
                            <p class="postDetails">${post.details}</p>
                        </div>
                    </div>
                </div>
                <div class="coment-area">
                    <ul class="we-comet">
                        <c:forEach var="comment" items="${post.comments}">
                            <li>
                                <div class="comet-avatar">
                                    <c:if test="${comment.user.image}">
                                        <img src="uploads/user/${comment.user.image}" alt="userImage"
                                             class="commentUserImage">
                                    </c:if>
                                </div>
                                <div class="we-comment">
                                    <div class="coment-head">
                                        <h5><a href="#" title=""
                                               class="commentUserName">${comment.user.firstName} ${comment.user.lastName}</a>
                                        </h5>
                                        <span>${comment.time}</span>
                                        <a class="we-reply" href="index.html#" title="Reply"><i class="fa fa-reply"></i></a>
                                    </div>
                                    <p class="commentComment">${comment.comment}</p>
                                </div>
                            </li>
                        </c:forEach>
                        <li class="post-comment">
                            <div class="comet-avatar">
                                <img src="${user.image}" alt="" class="postCommentUserImage">
                            </div>
                            <div class="post-comt-box">
                                <form method="post" action="addPostComment" class="postCommentForm"
                                      id="${post.id}_postCommentForm">
                                    <input placeholder="Post your comment" name="postComment" class="postComment"
                                           id="${post.id}_postComment">
                                    <div class="add-smiles">
                                        <span class="em em-expressionless" title="add icon"></span>
                                    </div>
                                    <input type="hidden" value="${post.id}" name="commentPostId"
                                           id="${post.id}_commentPostId" class="commentPostId">
                                    <button type="submit">add</button>
                                </form>
                                <div style="display: none" class="savingPostComment" id="${post.id}_savingPostComment">
                                    Posting.....
                                </div>
                            </div>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
    </c:forEach>

    <!-- for javascript purposes !! donot modify-->
    <div>
        <div class="central-meta item" id="postsListDivTemplate" style="display: none">
            <div class="user-post">
                <div class="friend-info">
                    <figure>
                        <img src="../../resources/images/resources/friend-avatar10.jpg" alt="">
                    </figure>
                    <div class="friend-name">
                        <ins><a href="#" title="" class="postUserName">${post.user.firstName} ${post.user.lastName}</a>
                        </ins>
                        <span class="postPublishTime">published: ${post.time}</span>
                    </div>
                    <div class="post-meta">
                        <img src="uploads/${post.photo}" alt="post image" class="postImage">
                        <div class="we-video-info">
                            <ul>
                                <li>
									<span class="comment" data-toggle="tooltip" title="Comments">
                                        <i class="fa fa-comments-o"></i>
                                        <ins class="postCommentsSize">${post.comments.size()}</ins>
                                    </span>
                                </li>
                            </ul>
                        </div>
                        <div class="description">
                            <p class="postDetails">
                                ${post.details}
                            </p>
                        </div>
                    </div>
                </div>
                <div class="coment-area">
                    <ul class="we-comet">

                        <li id="postCommentsLiTemplate">
                            <div class="comet-avatar">

                                <c:if test="${not empty comment.user.image}" >
                                    <img src="uploads/user/${comment.user.image}" alt="userImage" class="commentUserImage">
                                </c:if>
                            </div>
                            <div class="we-comment">
                                <div class="coment-head">
                                    <h5><a href="#" title=""
                                           class="commentUserName">${comment.user.firstName} ${comment.user.lastName}</a>
                                    </h5>
                                    <span class="commentTime">${comment.time}</span>
                                    <a class="we-reply" href="index.html#" title="Reply"><i class="fa fa-reply"></i></a>
                                </div>
                                <p class="commentComment">${comment.comment}</p>
                            </div>
                        </li>
                        <li class="post-comment">
                            <div class="comet-avatar">
                                <img src="${user.image}" alt="" class="postCommentUserImage">
                            </div>
                            <div class="post-comt-box">
                                <form method="post" action="addPostComment" class="postCommentForm"
                                      id="${post.id}_postCommentForm">
                                    <input placeholder="Post your comment" name="postComment" class="postComment"
                                           id="${post.id}_postComment">
                                    <div class="add-smiles">
                                        <span class="em em-expressionless" title="add icon"></span>
                                    </div>
                                    <input type="hidden" value="" name="commentPostId" id="${post.id}_commentPostId"
                                           class="commentPostId">
                                    <button type="submit" value="add">add</button>
                                </form>
                                <div style="display: none" class="savingPostComment" id="${post.id}_savingPostComment">
                                    Posting.....
                                </div>
                            </div>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
    </div><%----%>
</div>