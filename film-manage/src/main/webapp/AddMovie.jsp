<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>

<HEAD>
    <TITLE>Add Movie</TITLE>
</HEAD>

<BODY BGCOLOR="#FDF5E6">
    <FORM ACTION="/addmovie" METHOD="POST">
        <CENTER>
            <h2>Add Movie</h2>
            <label for="title">Movie Title:</label>
            <input type="text" id="title" name="title"><br><br>
            <label for="genre">Movie Genre:</label>
            <input type="text" id="genre" name="genre"><br><br>
            <label for="genre">Movie Genre:</label>
            <input type="number" id="yearOfRelease" name="yearOfRelease"><br><br>
            <input type="submit" value="Submit">
        </CENTER>

    </FORM>

    <h1>
        <FORM ACTION="/listmovie" METHOD="GET">
            <CENTER>
                <h2>List Movie</h2>
                <input type="submit" value="Submit">
            </CENTER>

        </FORM>
    </h1>

    <h1>Find movie by name</h1>

    
    

</BODY>

</HTML>