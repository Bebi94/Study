<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>

<HEAD>
    <TITLE>List Movie</TITLE>
</HEAD>

<BODY BGCOLOR="#FDF5E6">

    <h1>
        <h2>List of Movies</h2>
        <table border="1">
            <tr>
                <th>Title</th>
                <th>Genre</th>
                <th>Year of Release</th>
            </tr>
            <c:forEach var="movie" items="${movies}">
                <tr>
                    <td>${movie.title}</td>
                    <td>${movie.genre}</td>
                    <td>${movie.yearOfRelease}</td>
                </tr>
            </c:forEach>
        </table>
    </h1>

</BODY>

</HTML>