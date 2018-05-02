/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$('input').change(function (event) {
    var estPresent = $(event.target).val();
    var url = event.target.parentNode.action;
    console.log(url);
    $.ajax({
        url: url,
        type: 'POST',
        data: "estPresent=" + estPresent,
        success: function (response) {
            console.log("ok");
        },
        error: function (errorThrown) {
            console.log("not success :" + errorThrown);
        }
    });
});
