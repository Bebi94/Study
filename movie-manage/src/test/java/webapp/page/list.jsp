<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF8">
        <title>List Of Movies</title>
    </head>
    <body>
        <h2>List Of Movies</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Genre</th>
                <th>Year Of Release</th>
            </tr>
            <c: forEach var="movie" items="movies">
                <tr>
                    <td>${movie.id}</td>
                    <td>${movie.title}</td>
                    <td>${movie.genre}</td>
                    <td>${movie.yearOfRelease}</td>
                </tr>
            </c:>
            
        </table>
    </body>
</html>