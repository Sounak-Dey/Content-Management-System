async function send() {
    var x = document.getElementById("formid");
    var y = document.getElementsByTagName("label");
    var object = {};
    var jsonarr = [];
    var j = 1;
    for (var i = 0; i < x.length; i++) {
        object = {
            Element: {
                id: j,
                type: "text",
                label: y[i].innerText,
                name: x.elements[i].value,
            }
        };
        jsonarr.push(object);
        j = j + 1;
    }
    var json = JSON.stringify(jsonarr);
    var temp = JSON.stringify(jsonarr[0]);

    let response = await fetch('api/students/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: temp
        }

    );
    console.log(json);
}