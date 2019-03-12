<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title">Favorite Parks</c:param>
	<c:param name="favsActive">active</c:param>
</c:import>

<div class="container shadow-sm rounded px-5 py-3" id="park-container">
	<h5 class="display-4 text-center" style="font-family: Montserrat">Favorite Parks Survey Results</h5>
	<p class="text-dark text-center" style="font-family: Montserrat">We've asked, and you've answered! These are the results for everyone's favorite National Parks!</p>
	<div class="row justify-content-center">
		<c:forEach var="survey" items="${surveys}">
			<c:if test="${survey.value > 0}">
				<div class="col-sm-2 bg-light m-2 py-2 rounded shadow">
					<c:url var="parkImg" value="img/parks/${survey.key.parkCode.toLowerCase()}.jpg" />
					<img class="card-img park-image shadow " src="${parkImg}" alt="${survey.key.parkName} image">
					<p class="mt-2 h6 text-center">${survey.key.parkName}</p>
					<c:if test="${survey.value > 1}">
						<p class="text-center">${survey.value} people voted for this park!</p>
					</c:if>
					<c:if test="${survey.value < 2}">
						<p class="text-center">${survey.value} person voted for this park!</p>
					</c:if>
				</div>
				
				
			</c:if>
		</c:forEach>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />