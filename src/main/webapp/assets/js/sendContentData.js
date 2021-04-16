async function send() {
    var x = document.getElementById("form");
    var y = document.getElementById("title")
    var object = {};
    var temp = {title:y.value};
    var jsonarr = [temp];
    var j = 1;
    console.log(y.value);
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