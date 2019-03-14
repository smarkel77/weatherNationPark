<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>Homepage</h1>
<c:url var="tempURL" value="/temp" />
<form method="POST" action="${tempURL}">
	<div>
		<label for="temp">Choose your temp</label> <select name="temp">
			<option value="f">Fahrenheit</option>
			<option value="c">Celsius</option>
		</select>
	</div>
	<div>
		<input class="formSubmitButton" type="submit" />
	</div>

</form>

<div id="park">
	<c:url var="detailsURL" value="/details" />
	<c:forEach var="park" items="${parks}">

		<a href="${detailsURL}?parkCode=${park.parkCode}">
			<div>
				<img
					src="<c:url value="img/parks/${fn:toLowerCase(park.parkCode)}.jpg"/>" />
			</div>
			<div>
				<h2>${park.parkName}located in ${park.state}</h2>
			</div>
		</a>
		<div>
			<p>${park.description}</p>
		</div>

	</c:forEach>
</div>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />