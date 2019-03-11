<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title">Home</c:param>
	<c:param name="homeActive">active</c:param>
</c:import>

	<c:forEach var="park" items="${parksList}">
		<div class="row">
			<c:url var="parkImg" value="img/parks/${park.parkCode}.jpg" />
			<img src="${parkImg}" alt="${park.parkName} image">
		</div>
	
	</c:forEach>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />