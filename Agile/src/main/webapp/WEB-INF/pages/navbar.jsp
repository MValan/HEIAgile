<ul class="nav nav-tabs">
  <li role="presentation" class="<%if(request.getParameter("activeTab").equals("member")){%>active<%}%>"><a href="../members/members"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Membres</a></li>
  <li role="presentation" class="<%if(request.getParameter("activeTab").equals("book")){%>active<%}%>"><a href="../books/books"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> Livres</a></li>
  <li role="presentation" class="<%if(request.getParameter("activeTab").equals("borrow")){%>active<%}%>"><a href="../borrow/borrow"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Emprunts</a></li>
  <li role="presentation" class="<%if(request.getParameter("activeTab").equals("return")){%>active<%}%>"><a href="../borrow/return"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> Retours</a></li>
  <li role="presentation" class="<%if(request.getParameter("activeTab").equals("opendays")){%>active<%}%>"><a href="../openedDays/openedDays"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span> Jours ouvrés</a></li>
</ul>

