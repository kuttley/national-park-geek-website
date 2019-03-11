<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title"></c:param>
</c:import>

<c:set var="park" value="${park}"/>

<div class="row">
	<c:url var="parkImg" value="img/parks/${park.parkCode}.jpg" />
	<img src="${parkImg}" alt="${park.parkName} image">
	<div>${park.parkName}</div>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />