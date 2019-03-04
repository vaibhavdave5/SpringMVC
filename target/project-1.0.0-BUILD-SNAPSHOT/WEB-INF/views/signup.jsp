<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<head>
</head>
<body>
	<h3>Welcome!! Enter Your Details</h3>
	<form:form method="POST" action="/project/signup" modelAttribute="userForm">
		<table>
			<tr>
				<td><spring:bind path="name">
						<div class="form-group">
							<label class="col-sm-2 control-label">Name</label>
							<div class="col-sm-10">
								<form:input path="name" type="text" class="form-control "
									id="name" placeholder="Name" />
								<form:errors path="name" class="control-label" />
							</div>
						</div>
					</spring:bind></td>
			</tr>
			<tr>
				<td><spring:bind path="email">
						<div class="form-group">
							<label class="col-sm-2 control-label">Email</label>
							<div class="col-sm-10">
								<form:input path="email" type="text" class="form-control "
									id="name" placeholder="Email" />
								<form:errors path="email" class="control-label" />
							</div>
						</div>
					</spring:bind></td>
			</tr>
			<tr>
				<td><spring:bind path="password">
						<div class="form-group">
							<label class="col-sm-2 control-label">Password</label>
							<div class="col-sm-10">
								<form:input path="password" type="text" class="form-control "
									id="name" placeholder="Password" />
								<form:errors path="password" class="control-label" />
							</div>
						</div>
					</spring:bind></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>