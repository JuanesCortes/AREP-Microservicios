apiclient = (function() {

    return {
        addWord: function(tweet) {
            const put_request = $.ajax({
                url: "http://ec2-52-91-175-215.compute-1.amazonaws.com:4568/addWord",
                type: "POST",
                data: '{"tweet":' + tweet + '}',
                contentType: "application/json",
            });
        },
        showWords: function(callback) {
            const get_request = $.ajax({
                url: "http://ec2-44-201-146-90.compute-1.amazonaws.com:4567/showWords",
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
                url: "http://ec2-52-91-175-215.compute-1.amazonaws.com:4568/login?name=" + user + "&pswd=" + pswd,
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

        //ec2-52-91-175-215.compute-1.amazonaws.com:4568/login?name=Carlos&pswd=prueba123



    }
})();