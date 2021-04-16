document.getElementById("login").addEventListener("click", login);
document.getElementById("username").addEventListener("keyup",checkValue);
document.getElementById("password").addEventListener("keyup",checkValue);
document.getElementById("login").disabled = true;
document.getElementById("login").style.opacity = 0.6;
document.getElementById("alert").style.display="None";

function checkValue()
{

    username = document.getElementById("username").value;
    password = document.getElementById("password").value;
    if(username && password)
    {
        document.getElementById("login").disabled = false;
        document.getElementById("login").style.opacity = 1;
    }
    else
    {
        document.getElementById("login").disabled = true;
        document.getElementById("login").style.opacity = 0.6;
    }
}
let id = sessionStorage.getItem("id");
if(id)
{
    location.href = "template.html";
}
async function login()
{
    document.getElementById("login").disabled = true;
    document.getElementById("login").style.opacity = 0.6;
    username = document.getElementById("username").value;
    password = document.getElementById("password").value;
    if(username && password)
    {
        let response = await fetch('api/admin/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                username: username,
                password: password,
            })
        });
        let result =   response;
        console.log(response);
        if(result["status"]===200){
            let data = await result.text();
            if(data == 1){
                location.replace("template.html");
            }
            else{
                location.replace("content.html");
            }
            // sessionStorage.setItem("id", data);
            // document.getElementById("login").disabled = false;
            // location.href = "templateadmin.html";

        }else{
            document.getElementById("login").disabled = false;
            document.getElementById("login").style.opacity = 1.0;
            document.getElementById("alert").style.display="block";
        }
    }

}