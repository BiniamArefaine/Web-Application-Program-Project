<%@ page import="edu.miu.cs.domain.User" %>
<div class="widget">
    <div class="banner medium-opacity bluesh">
        <div class="baner-top">
            <i class="fa fa-cloud fa-2x"></i>
        </div>
        <div class="banermeta">
            <p id="description"></p>
            <p id="temp"></p>
            <p id="location"></p>
        </div>
    </div>
</div>
<%
    User user = (User)session.getAttribute("authenticated");
    String twitter = "https://twitter.com/"+user.getTwitterAccount();
    if(user.getTwitterAccount() != null){
%>
<div class="widget">
    <a class="twitter-timeline" data-height="800" data-theme="dark" href="<%=twitter%>">Tweets by <%=user.getFirstName() +" "+ user.getLastName()%></a> <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
</div>
<%}%><%----%>