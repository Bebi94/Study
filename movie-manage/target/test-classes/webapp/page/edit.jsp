<html>

<head>
    <title>Edit Movie</title>
</head>

<body>
    <h2>Edit Movie</h2>
    <c:if test="movie ne null">
        <form action="${pageContext.request.contextPath}/movie/edit">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value="{movie.title}" required><br><br>
            <input type="hidden" id="id" name="id" value="movie.id">
            <input type="submit" value="Save Change">
        </form>
    </c:if>
    <a href="${pageContext.request.contextPath}/movie/list">Back to List Of Movies</a>
</body>

</html>