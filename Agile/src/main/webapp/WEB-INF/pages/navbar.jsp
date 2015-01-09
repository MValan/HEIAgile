<ul class="nav nav-tabs">
  <li role="presentation" class="<%if(request.getParameter("activeTab").equals("member")){%>active<%}%>"><a href="../members/members">Membres</a></li>
  <li role="presentation" class="<%if(request.getParameter("activeTab").equals("book")){%>active<%}%>"><a href="../books/books">Livres</a></li>
  <li role="presentation" class="<%if(request.getParameter("activeTab").equals("borrow")){%>active<%}%>"><a href="../borrow/borrow">Emprunts</a></li>
  <li role="presentation" class="<%if(request.getParameter("activeTab").equals("return")){%>active<%}%>"><a href="../borrow/return">Retours</a></li>
  <li role="presentation" class="<%if(request.getParameter("activeTab").equals("opendays")){%>active<%}%>"><a href="../openedDays/openedDays">Jours ouvrés</a></li>
</ul>

