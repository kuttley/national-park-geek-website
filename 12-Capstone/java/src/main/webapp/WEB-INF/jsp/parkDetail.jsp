<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title"></c:param>
</c:import>

<div class="container shadow-sm rounded px-5 pt-3" id="park-detail-page">
	<c:url var="parkImg" value="img/parks/${park.parkCode.toLowerCase()}.jpg" />
	<img class="img-fluid mx-auto d-block shadow-lg p-1 mb-2 rounded bg-white" src="${parkImg}" alt="${park.parkName} image">
	
	<div id="park-info">
		<div class="mt-3 d-flex align-items-end flex-column" style="font-family: Montserrat">
			<h3 class="display-4">${park.parkName}</h3>
			<h5 class="align-self-end">${park.state}</h5>
		</div>
		<div style="font-family: Overpass">
			<blockquote class="blockquote text-right">
				<p class="mb-0">${park.inspirationalQuote}</p>
				<footer class="blockquote-footer">${park.inspirationalQuoteSource}</footer>
			</blockquote>
			<p>${park.description}</p>
			<!-- TODO: Fix park information to look good. -->
			<p>${park.acreage} ${park.elevationInFeet} ${park.milesOfTrail} ${park.campsites} ${park.climate} ${park.yearFounded} ${park.annualVisitorCount}
			 ${park.entryFee} ${park.numberOfAnimalSpecies}</p>
			 
			 
			 <div class="card-group justify-content-center pb-3">
			 <c:forEach var="weatherForecast" items="${weather}">
				<div class="card weather-card shadow-sm rounded">
					<c:url var="forecastImg" value="/img/weather/${weatherForecast.forecast}.png" />
					<img class="card-img-top" src="${forecastImg}" alt="${weatherForecast.forecast} image">
					<div class="card-body">
						<c:choose>
							<c:when test="${weatherForecast.forecastDay == 1}">
								<c:set var="day" value="Today" />
							</c:when>
							<c:when test="${weatherForecast.forecastDay == 2}">
								<c:set var="day" value="Tomorrow" />
							</c:when>
							<c:when test="${weatherForecast.forecastDay == 3}">
								<c:set var="day" value="2 Days" />
							</c:when>
							<c:when test="${weatherForecast.forecastDay == 4}">
								<c:set var="day" value="3 Days" />
							</c:when>
							<c:when test="${weatherForecast.forecastDay == 5}">
								<c:set var="day" value="4 Days" />
							</c:when>
						</c:choose>
						<h5 class="card-title">${day}</h5>
						
						<c:if test="${sessionScope.tempScale == 'F'}">
							<h5 class="card-text">${weatherForecast.highTempF} °F / <span class="h6">${weatherForecast.lowTempF} °F</span></h5>
						</c:if>
						<c:if test="${sessionScope.tempScale == 'C'}">
							<h5 class="card-text">${weatherForecast.highTempC} °C / <span class="h6">${weatherForecast.lowTempC} °C</span></h5>
						</c:if>
						
						
						<c:set var="weatherAdvisory" value="" />
						<c:set var="tempAdvisory" value="" />
						<c:choose>
							<c:when test="${weatherForecast.forecast == 'sunny'}">
								<c:set var="weatherAdvisory" value="Remember your sunblock! " />
							</c:when>
							<c:when test="${weatherForecast.forecast == 'thunderstorms'}">
								<c:set var="weatherAdvisory" value="Seek shelter and avoid hiking on exposed ridges! " />
							</c:when>
							<c:when test="${weatherForecast.forecast == 'rain'}">
								<c:set var="weatherAdvisory" value="Pack rain gear and waterproof shoes! " />
							</c:when>
							<c:when test="${weatherForecast.forecast == 'snow'}">
								<c:set var="weatherAdvisory" value="Pack snowshoes! " />
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${weatherForecast.highTempF > 75}">
								<c:set var="tempAdvisory" value="It'll be hot! Bring an extra gallon of water" />
							</c:when>
							<c:when test="${weatherForecast.highTempF - weatherForecast.lowTempF > 20}">
								<c:set var="tempAdvisory" value="Wear breathable layers, large temperature change through the day." />
							</c:when>
							<c:when test="${weatherForecast.highTempF < 20}">
								<c:set var="tempAdvisory" value="Be extremely careful in frigid temperatures!" />
							</c:when>
						</c:choose>
						<p class="card-text">${weatherAdvisory}<br><br>${tempAdvisory}</p>
					</div>
				</div>
			 </c:forEach>
			 </div>
		</div>
	</div>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />