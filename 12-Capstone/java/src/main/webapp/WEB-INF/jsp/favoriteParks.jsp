<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title">Favorite Parks</c:param>
	<c:param name="favsActive">active</c:param>
</c:import>

<div class="container shadow-sm rounded px-5 py-3" id="park-container">
	<h5 class="display-4 text-center" style="font-family: Montserrat">Favorite Parks Survey Results</h5>
	<p class="text-dark text-center" style="font-family: Montserrat">We've asked, and you've answered! These are the results for everyone's favorite National Parks!</p>
	<div class="d-flex justify-content-end">
		<form method="POST">
			<div>
				<label for="activityNumChosen" style="font-family: Montserrat">Choose an Activity Level to Search By</label>
				<select name="activityNumChosen">
					<option value="-1"></option>
					<option value="0">Inactive</option>
					<option value="1">Sedentary</option>
					<option value="2">Active</option>
					<option value="3">Extremely Active</option>
				</select>
			</div>
			<div>
				<label for="stateChosen" style="font-family: Montserrat">Choose State to Search By</label>
				<select name="stateChosen">
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
				</select>
			</div>
			<button class="btn btn-outline-primary mb-3" type="submit">Search</button>
		</form>
	</div>
	<div class="row justify-content-center">
		<c:forEach var="survey" items="${surveys}">
			<c:if test="${survey.value > 0}">
				<div class="col-sm-auto col-lg-2 bg-light m-2 py-2 rounded shadow">
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

