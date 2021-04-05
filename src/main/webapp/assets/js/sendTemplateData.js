async function send() {
    var formData = document.getElementById("formData");
    var title = document.getElementById("title").value;
    var object = {title};
    var jsonarr = [];
    jsonarr.push(object);
    var j = 1;
    for (var i = 0; i < formData.length; i = i + 2) {
        object = {
            Element: {
                id: j,
                type: "text",
                name: formData.elements[i].value,
            }
        };
        jsonarr.push(object);
        j = j + 1;
    }
    var json = JSON.stringify(jsonarr);

    let response = await fetch('api/template/xml', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: json
        }

    );
    if(response.status === 200){
        alert("Template Made");
        formData.reset();
        title.clear();
    }
    console.log(response);
    console.log(json);
}