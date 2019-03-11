<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title"></c:param>
</c:import>

<c:set var="park" value="${park}"/>

<div class="row">
	<c:url var="parkImg" value="img/parks/${park.parkCode.toLowerCase()}.jpg" />
	<img src="${parkImg}" alt="${park.parkName} image">
	<div>${park.parkName}</div>
	<div>${park.state}</div>
	<div>${park.acreage}</div>
	<div>${park.elevationInFeet}</div>
	<div>${park.milesOfTrail}</div>
	<div>${park.campsites}</div>
	<div>${park.climate}</div>
	<div>${park.yearFounded}</div>
	<div>${park.annualVisitorCount}</div>
	<div>${park.inspirationalQuote}</div>
	<div>${park.inspirationalQuoteSource}</div>
	<div>${park.description}</div>
	<div>${park.entryFee}</div>
	<div>${park.numberOfAnimalSpecies}</div>
	<div>
		<c:forEach var="weatherForecast" items="${weather}">
			<div>
				<div>${weatherForecast.forecastDay}</div>
				<div>${weatherForecast.lowTempF}</div>
				<div>${weatherForecast.highTempF}</div>
				<div>${weatherForecast.forecast}</div>
			</div>
		</c:forEach>
	</div>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />