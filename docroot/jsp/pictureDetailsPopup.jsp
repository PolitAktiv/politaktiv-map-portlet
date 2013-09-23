

Von <%= request.getParameter("userName") %>: <br />
<%= request.getParameter("description") %> <br />

<% if(!request.getParameter("link").equals("http://")
		&& !request.getParameter("link").equals("")){ %>
	<a href="<%= request.getParameter("link") %>">
		Link
	</a>
<% } %>