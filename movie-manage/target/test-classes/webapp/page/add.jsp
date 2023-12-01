<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF8">
        <title>Add Movie</title>
    </head>
    <body>
        <h2>Add Movie</h2>
        <form action="${pageContext.request.contextPath}/movie/add" method="post">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title"><br><br>
            <label for="genre">Genre:</label>
            <input type="text" id="genre" name="genre"><br><br>
            <label for="yearOfRelease">Year Of Release</label>
            <input type="text" id="yearOfRelease" name="yearOfRelease"><br><br>
            <input type="submit" value="Add Movie">
        </form>
        <br>
        <a href="${pageContext.request.contextPath}/movie/list">Back to List Of Movies</a>
    </body>
</html>