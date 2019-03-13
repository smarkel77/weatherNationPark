<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>Homepage</h1>

<div id="park">
	<c:forEach var="park" items="${parks}">
		<img src="<c:url value="img/${park.parkCode}"/>" />
		<h2>${park.parkName} located in ${park.state}</h2>
		<p>${park.description}</p>
	</c:forEach>
</div>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />