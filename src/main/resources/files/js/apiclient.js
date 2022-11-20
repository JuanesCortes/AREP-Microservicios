apiclient = (function() {

    return {
        addWord: function(username, tweet) {
            const put_request = $.ajax({
                url: "/addWord",
                type: "POST",
                data: '{ "username": "' + username + '", "tweet": "' + tweet + '" }',
                contentType: "application/json",
            });
        },
        showWords: function(callback) {
            const get_request = $.ajax({
                url: "/showWords",
                type: "GET",
                contentType: "application/json",
            });
            get_request.then(function(data) {
                callback(data, data);
            }, function(error) {
                callback(null, null);
            });
        },

        login: function(user, pswd, callback) {
            const get_request = $.get({
                url: "/login?name=" + user + "&pswd=" + pswd,
                contentType: "application/json",
            });
            var t = null;
            get_request.then(function(data) {
                t = data;
            });
            alert("Login succefully");
            get_request.then(function(data) {
                callback(data, data, data);
            }, function(error) {
                alert("login error");
            });
        }
    }
})();