<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title">Home</c:param>
	<c:param name="homeActive">active</c:param>
</c:import>

<%-- 	<ul class="list-unstyled">
		<c:forEach var="park" items="${parksList}">
			<li class="media my-4">
				<c:url var="parkImg" value="img/parks/${park.parkCode.toLowerCase()}.jpg" />
				<img class="align-self-start mr-3 park-image" src="${parkImg}" alt="${park.parkName} image">
				<div class="media-body">
					<h4 class="mt-0 mb-1">${park.parkName}</h4>
					<h5>${park.state}</h5>
					<p>${park.description}</p>
				</div>
			</li>
		</c:forEach>
	</ul> --%>
	
	<c:forEach var="park" items="${parksList}">
		<div class="card mb-2 mt-2">
			<div class="row no-gutters">
				<c:url var="parkDetailPage" value="/park?id=${park.parkCode.toLowerCase()}" /> 
				<div class="col-md-4 mt-auto mb-auto">
					<c:url var="parkImg" value="img/parks/${park.parkCode.toLowerCase()}.jpg" />
					<a href="${parkDetailPage}"><img class="card-img park-image ml-2" src="${parkImg}" alt="${park.parkName} image"></a>
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h4 class="card-title"><a href="${parkDetailPage}">${park.parkName}</a></h4>
						<h5 class="card-text text-black-50">${park.state}</h5>
						<p class="card-text">${park.description}</p>
					</div>
			</div>
			</div>
		</div>
	</c:forEach>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />