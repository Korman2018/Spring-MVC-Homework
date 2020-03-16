<html>
    <head>
        <meta charset="UTF-8">
        <title>Users</title>
    </head>

    <body>
        <div>
            <#list users as user>
             User: ${user.surname}  ${user.name}  ${user.patronymic}
                <#list user.phones as phone>
                    <div>
                    phone: ${phone.number} company: ${phone.company.name}
                    </div>
                </#list>
               <div>
               -------------------------------
                </div>
            </#list>
        </div>
    </body>
</html>