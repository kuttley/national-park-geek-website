<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title">Daily Survey</c:param>
	<c:param name="surveyActive">active</c:param>
</c:import>
<div class="card mb-3 shadow">
	<h2 class="surveyHeading">Please take Survey below</h2>
	<h3 class="surveyHeading">Let us know which National Park is your favorite!</h3>
	<form:form id="postForm" action="survey" method="POST" modelAttribute="survey">
		<div>
			<label class="surveyLabel" for="parkCode">Choose a Park</label>
			<form:select class="selectSurvey" path="parkCode">
				<option value=""></option>
				<c:forEach var="park" items="${parksList}">
					<option value="${park.parkCode}">${park.parkName}</option>
				</c:forEach>
			</form:select>
		</div>
		<div>
			<label class="surveyLabel" for="email">Email</label>
			<form:input class="selectSurvey" type="email" path="email" />
		</div>
		<div>
			<label class="surveyLabel" for="activityLevel">Choose an Activity Level</label>
			<form:select class="selectSurvey" path="activityLevel">
				<option value=""></option>
				<option value="inactive">Inactive</option>
				<option value="sedentary">Sedentary</option>
				<option value="active">Active</option>
				<option value="extremelyactive">Extremely Active</option>
			</form:select>
		</div>
		<div>
			<label class="surveyLabel" for="state">What is your state of residence?</label>
			<form:select class="selectSurvey" path="state">
				<option value=""></option>
				<option value="AK">Alaska</option>
				<option value="AL">Alabama</option>
				<option value="AR">Arkansas</option>
				<option value="AZ">Arizona</option>
				<option value="CA">California</option>
				<option value="CO">Colorado</option>
				<option value="CT">Connecticut</option>
				<option value="DC">District of Columbia</option>
				<option value="DE">Delaware</option>
				<option value="FL">Florida</option>
				<option value="GA">Georgia</option>
				<option value="HI">Hawaii</option>
				<option value="IA">Iowa</option>
				<option value="ID">Idaho</option>
				<option value="IL">Illinois</option>
				<option value="IN">Indiana</option>
				<option value="KS">Kansas</option>
				<option value="KY">Kentucky</option>
				<option value="LA">Louisiana</option>
				<option value="MA">Massachusetts</option>
				<option value="MD">Maryland</option>
				<option value="ME">Maine</option>
				<option value="MI">Michigan</option>
				<option value="MN">Minnesota</option>
				<option value="MO">Missouri</option>
				<option value="MS">Mississippi</option>
				<option value="MT">Montana</option>
				<option value="NC">North Carolina</option>
				<option value="ND">North Dakota</option>
				<option value="NE">Nebraska</option>
				<option value="NH">New Hampshire</option>
				<option value="NJ">New Jersey</option>
				<option value="NM">New Mexico</option>
				<option value="NV">Nevada</option>
				<option value="NY">New York</option>
				<option value="OH">Ohio</option>
				<option value="OK">Oklahoma</option>
				<option value="OR">Oregon</option>
				<option value="PA">Pennsylvania</option>
				<option value="PR">Puerto Rico</option>
				<option value="RI">Rhode Island</option>
				<option value="SC">South Carolina</option>
				<option value="SD">South Dakota</option>
				<option value="TN">Tennessee</option>
				<option value="TX">Texas</option>
				<option value="UT">Utah</option>
				<option value="VA">Virginia</option>
				<option value="VT">Vermont</option>
				<option value="WA">Washington</option>
				<option value="WI">Wisconsin</option>
				<option value="WV">West Virginia</option>
				<option value="WY">Wyoming</option>
			</form:select>
		</div>
		<button class="surveyButton" type="submit">Submit</button>
	</form:form>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />