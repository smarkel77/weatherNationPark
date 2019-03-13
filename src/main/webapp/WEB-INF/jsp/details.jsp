<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>Details</h1>

<div>
	<img
		src="<c:url value="img/parks/${fn:toLowerCase(park.parkCode)}.jpg"/>" />
</div>
<div>
	<h2>${park.parkName} located in ${park.state}</h2>
</div>
<div>
	<p>${park.description}</p>
</div>
<div>
	<p>${park.acreage}</p>
</div>
<div>
	<p>${park.elevation}</p>
</div>
<div>
	<p>${park.milesOfTrail}</p>
</div>
<div>
	<p>${park.numOfCampsites}</p>
</div>
<div>
	<p>${park.climate}</p>
</div>
<div>
	<p>${park.yearFounded}</p>
</div>
<div>
	<p>${park.annualVisitors}</p>
</div>
<div>
	<p>${park.quote}</p>
</div>
<div>
	<p>${park.quoteSource}</p>
</div>
<div>
	<p>${park.description}</p>
</div>
<div>
	<p>${park.entryFee}</p>
</div>
<div>
	<p>${park.numOfSpecies}</p>
</div>
<div>
<c:forEach var="day" items="${parkWeather}">
	<div>
		<img src="<c:url value="img/weather/${fn:toLowerCase(day.forecastImage)}.png"/>" />
	</div>
	<div>
		<p>${day.lowTemp}</p>
	</div>
	<div>
		<p>${day.highTemp}</p>
	</div>
	<div>
		<p>${day.recommendation}</p>
	</div>
</c:forEach>
</div>


	<c:import url="/WEB-INF/jsp/common/footer.jsp" />