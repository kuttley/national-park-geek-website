<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title"></c:param>
</c:import>

<div class="container rounded" id="park-detail">
	<c:url var="parkImg" value="img/parks/${park.parkCode.toLowerCase()}.jpg" />
	<img class="img-fluid mx-auto pt-2 d-block rounded" src="${parkImg}" alt="${park.parkName} image">
	
	<h3 class="display-4 mt-3">${park.parkName}</h3>
</div>

<%-- <div class="row">
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
				<c:if test="${sessionScope.tempScale == 'F'}">
					<div>${weatherForecast.lowTempF}</div>
					<div>${weatherForecast.highTempF}</div>
				</c:if>
				<c:if test="${sessionScope.tempScale == 'C'}">
					<div>${weatherForecast.lowTempC}</div>
					<div>${weatherForecast.highTempC}</div>
				</c:if>
				<div>${weatherForecast.forecast}</div>
			</div>
		</c:forEach>
	</div>
</div> --%>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />