<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
   
<div class="container">
	<h1>Add Todo List</h1>
	
	<form:form method="post" modelAttribute="todo">
		<fieldset class="mb-3">
			<form:label path="description" class="fw-bold">Course : </form:label>
			<form:input type="text" path="description" required="required"/>
			<form:errors path="description" cssClass="text-danger"/>
		</fieldset>
		<fieldset class="mb-3">
			<form:label path="targetDate" class="fw-bold">Target Date : </form:label>
			<form:input type="date" path="targetDate" required="required"/>
			<form:errors path="targetDate" cssClass="text-danger"/>
		</fieldset>
		<form:input type="hidden" path="id"/>
		<form:input type="hidden" path="done"/>
		<input type ="submit" class="btn btn-success"/>
	</form:form>
</div>