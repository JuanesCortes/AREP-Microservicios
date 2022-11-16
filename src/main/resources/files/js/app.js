var app = (function() {

    var view = function(error, res) {
        $("#ok").text(res.confirm);
        return "callback";
    }

    function addWordTyped(word) {
        apiclient.addWord(word);
    }

    function showWords(word) {
        apiclient.showWords((req, resp) => {
            createDataTable(resp);
        });
    }

    function createDataTable(data) {
        let table = $("#fl-table tbody");
        table.empty();
        if (data !== undefined) {
            console.log(data);

            var temp_json = JSON.parse(data);

            temp_json.forEach(function parsejson(item_tweet) {
                let values = item_tweet;
                let username = values.username;
                let tweet = values.mensaje;
                let date = values.fecha;

                document.getElementById("info").innerHTML +=
                    `<tr>
            <td>${username}</td>
            <td>${tweet}</td>
            <td>${date}</td>
        </tr>`
            });



        } else {
            alert("Data not found!");
        }
    }

    function login(user, pswd) {
        apiclient.login(user, pswd, (req, resp) => {
            console.log(resp);
        });
    }

    function getCurrentDay() {
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0');
        var yyyy = today.getFullYear();
        today = dd + '/' + mm + '/' + yyyy;
        return today;
    }



    return {
        login: login,
        addWordTyped: addWordTyped,
        showWords: showWords
    }

})();