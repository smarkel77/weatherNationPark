<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>Homepage</h1>

<div id="park">
<c:url var="detailsURL" value="/details" />
	<c:forEach var="park" items="${parks}">
	
	<a href="${detailsURL}?parkCode=${park.parkCode}">
	<div>
		<img src="<c:url value="img/parks/${fn:toLowerCase(park.parkCode)}.jpg"/>" />
		</div>
		<div>
		<h2>${park.parkName} located in ${park.state}</h2>
		</div>
		<div>
		<p>${park.description}</p>
		</div>
		</a>
	</c:forEach>
</div>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />