<html>
    <head>
        <meta charset="UTF-8">
        <title>Batch upload users</title>
    </head>

    <body onload="updateFiles();">
        <form name="upload" enctype="multipart/form-data" action="/" method="POST">
            <p>
                <div><input id="fileInput" type="file" name="uploadedFiles" onchange="updateFiles();" multiple></div>
                <div style="padding-top:20px" id="selectedFiles"></div>
            </p>
            <p>
                <input type="submit" value="Upload files">
            </p>
        </form>

        <script>
            function updateFiles() {
                var nBytes = 0,
                	fileInfo = '',
                        oFiles = document.getElementById("fileInput").files,
                        nFiles = oFiles.length;
                for (var nFileId = 0; nFileId < nFiles; nFileId++) {
                	fileInfo += 'Filename=';
                	fileInfo += oFiles[nFileId].name;
                	fileInfo +=', size=';
                    fileInfo += oFiles[nFileId].size;
                    fileInfo +=' bytes';
                    fileInfo +='</br>';
                }

                document.getElementById("selectedFiles").innerHTML = fileInfo;
            }
        </script>
    </body>
</html>