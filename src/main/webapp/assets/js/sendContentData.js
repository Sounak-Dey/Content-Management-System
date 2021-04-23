async function send() {
    var t= localStorage.getItem("richtext");
    var count = localStorage.getItem("countkey");
    var x = document.getElementById("form");
    var y = document.getElementById("title");
    var object = {};
    var temp = {title:y.value};
    var jsonarr = [temp];
    var j = 1;
    console.log(y.value);
    if(t != "norichtext") {
        for (var i = 0; i < count - 1; i++) {
            object = {
                Element: {
                    id: j,
                    type: "text",
                    label: x.elements[i].placeholder,
                    name: x.elements[i].value,
                    title: y.value,
                }
            };
            jsonarr.push(object);
            j = j + 1;
        }
        var lab = localStorage.getItem("RTElabel");
        object = {
            Element: {
                id: j,
                type: "richtext",
                label: lab,
                name: t,
                title: y.value,
            }
        };
        jsonarr.push(object);
    }
    else{
        for (var i = 0; i < x.length; i++) {
            object = {
                Element: {
                    id: j,
                    type: "text",
                    label: x.elements[i].placeholder,
                    name: x.elements[i].value,
                    title: y.value,
                }
            };
            jsonarr.push(object);
            j = j + 1;
        }
    }

    var json = JSON.stringify(jsonarr);

    try {
        let response = await fetch('api/content/xml', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                body: json
            }

        );
        console.log(response);
    }
    catch (e){
        console.log(e);
    }

    //console.log(response);
}