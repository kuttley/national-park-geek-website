<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title">Daily Survey</c:param>
	<c:param name="surveyActive">active</c:param>
</c:import>

<h2>Take Survey</h2>
<form id="postForm" action="makePost" method="POST">
	<div>
		<label for="parkCode">Choose a Park</label> <select name="parkCode">
			<c:forEach var="park" items="${parksList}">
				<option value="${park.parkCode}">${park.name}</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<label for="email">Email</label> <input type="email" name="email" />
	</div>
	<div>
		<label for="parkCode">Choose an Activity Level</label> <select
			name="parkCode">
			<option value="inactive">Inactive</option>
			<option value="sedentary">Sedentary</option>
			<option value="active">Active</option>
			<option value="extremelyactive">Extremely Active</option>
		</select>
	</div>
	<div>
		<label for="activitylevel">Subject</label> <input type="text"
			name="subject" />
	</div>
	<button type="submit">Submit</button>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />