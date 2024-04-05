<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<h1>Todos</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Course</th>
				<th>Target Date</th>
				<th>Completed</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
			<tbody>
				<c:forEach items= "${todosList}" var="todos">						
					<tr>
						<td>${todos.description}</td>
						<td>${todos.targetDate}</td>
						<td>${todos.done}</td>
						<td><a href="UpdateTodo?id=${todos.id}" class="btn btn-warning">Update</a></td>
						<td><a href="DeleteTodo?id=${todos.id}" class="btn btn-danger">Delete</a></td>
					</tr>
					
				</c:forEach>	
			</tbody>
	</table>
	<a href="addTodo" class="btn btn-success">Add Todo</a>
</div>


<script type="text/javascript">
$('#targetDate').datepicker({
    format: 'yyyy-mm-dd',
});
</script>
	<%@ include file="common/footer.jspf" %>
	




