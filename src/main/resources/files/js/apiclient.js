apiclient = (function() {

    return {
        addWord: function(tweet) {
            const put_request = $.ajax({
                url: "/addWord",
                type: "POST",
                data: '{"tweet":' + tweet + '}',
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
            const get_request = $.ajax({
                url: "/login?name=" + user + "&pswd=" + pswd,
                type: "GET",
                contentType: "application/json",
            });
            alert(get_request);
            get_request.then(function(data) {
                callback(data, data, data);
            }, function(error) {
                callback(null, null, null);
            });
        }
    }
})();