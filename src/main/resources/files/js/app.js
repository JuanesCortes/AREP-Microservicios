var app = (function () {
  var view = function(error, res) {
      $("#ok").text(res.confirm);
      return "callback";
    }

  function addWordTyped(word) {
      apiclient.addWord(word);
  }

  function showWords(word){
    apiclient.showWords((req, resp) => {
        createDataTable(resp);
    });
  }

  function createDataTable(data){
    let table = $("#fl-table tbody");
    table.empty();
    if (data !== undefined) {
      datanew = data.split(",");
//      datanew = datanew.slice(Math.max(datanew.length - 10, 0))
      let date = getCurrentDay();
      console.log(datanew);
      let i = 0;
      datanew.forEach(function replace(item){
            console.log(item);
            let value = item;
            if (i === 0){
            table.append(
                `<tr class="default">
                  <td>${value}</td>
                  <td></td>
                  <td></td>
                `
            );}
            else if (i === 1){
            table.append(
                `<tr class="default">
                  <td></td>
                  <td>${value}</td>
                  <td></td>
                `
            );
            }
            else {
              table.append(
                      `<tr class="default">
                        <td></td>
                        <td></td>
                        <td>${value}</td>
                      `
                  );
                  i=0;
            }i++;
      });
    } else {
        alert("Data not found!");
    }
  }

  function getCurrentDay(){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0');
    var yyyy = today.getFullYear();
    today = dd + '/' + mm + '/' + yyyy;
    return today;
  }

  return {
	  addWordTyped:addWordTyped,
	  showWords: showWords
  }

})();