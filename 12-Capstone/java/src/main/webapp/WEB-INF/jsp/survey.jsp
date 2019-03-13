<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title">Daily Survey</c:param>
	<c:param name="surveyActive">active</c:param>
</c:import>
<div class="container shadow-sm rounded px-5 py-3" id="park-container">
	<h2 class="text-center" style="font-family: Montserrat">Please take Survey below</h2>
	<h4 class="text-center" style="font-family: Montserrat">Let us know which National Park is your favorite!</h4>
	<div class="d-flex p-3">
		<form:form action="survey" method="POST" modelAttribute="survey">
			<div class="form-group row justify-content-between">
				<label class="lead col-auto col-form-label" for="parkCode" style="font-family: Overpass">Choose a Park</label>
				<div class="ml-auto col-auto d-flex align-self-center">
					<form:select cssClass="form-control form-control-sm" path="parkCode" required="required">
						<option value=""></option>
						<c:forEach var="park" items="${parksList}">
							<option value="${park.parkCode}">${park.parkName}</option>
						</c:forEach>
					</form:select>
					<form:errors path="parkCode" />
				</div>
			</div>
			<div class="form-group row">
				<label class="lead col-auto col-form-label" for="email" style="font-family: Overpass">Email</label>
				<div class="ml-auto col-auto d-flex align-self-center">
					<form:input cssClass="form-control form-control-sm" type="email" path="email" pattern="^.+@.+\..{2,7}" required="required" />
					<form:errors path="emailValid" />
				</div>
			</div>
			<div class="form-group row">
				<label class="lead col-auto col-form-label" for="activityLevel" style="font-family: Overpass">Choose an Activity Level</label>
				<div class="ml-auto col-auto d-flex align-self-center">
					<form:select cssClass="form-control form-control-sm" path="activityLevel" required="required">
						<option value=""></option>
						<option value="inactive">Inactive</option>
						<option value="sedentary">Sedentary</option>
						<option value="active">Active</option>
						<option value="extremelyactive">Extremely Active</option>
					</form:select>
					<form:errors path="activityLevel" />
				</div>
			</div>
			<div class="form-group row">
				<label class="lead col-auto col-form-label" for="state" style="font-family: Overpass;">What is your state of residence?</label>
				<div class="ml-auto col-auto d-flex align-self-center ">
					<form:select cssClass="form-control form-control-sm" path="state" required="required">
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
					<form:errors path="state" />
				</div>
			</div>
			<div class="d-flex justify-content-end">
			<button class="btn btn-outline-primary" type="submit">Submit</button>
			</div>
		</form:form>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />