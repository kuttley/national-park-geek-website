<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title">Favorite Parks</c:param>
	<c:param name="favsActive">active</c:param>
</c:import>

<c:forEach var="survey" items="${surveys}">
	<c:if test="${survey.value > 0}">
		<div class="card mb-2 mt-2">
			<div class="row no-gutters">
				<div class="col-md-4 mt-auto mb-auto">
					<c:url var="parkImg"
						value="img/parks/${survey.key.parkCode.toLowerCase()}.jpg" />
					<img class="card-img park-image ml-2" src="${parkImg}" alt="${survey.key.parkName} image">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h4 class="card-title">${survey.key.parkName}</h4>
						<h5 class="card-text text-black-50">${survey.key.state}</h5>
						<c:if test="${survey.value > 1}">
							<p class="card-text">This is the favorite National Park of ${survey.value} people!</p>
						</c:if>
						<c:if test="${survey.value < 2}">
							<p class="card-text">This is the favorite National Park of ${survey.value} person!</p>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</c:if>
</c:forEach>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />