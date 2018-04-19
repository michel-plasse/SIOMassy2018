/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$("td > select").change(function (e) {
    var etat = $(e.target).val();
    var modifier = $(e.target).attr('id');
    $.ajax({
        url: 'ModifierCandidature',
        type: 'POST',
        data: {"Etat": etat, "Modifier": modifier},
        success: function (response) {
            console.log("Sucess!");
            //$('#changeHere').html(response);
        },
        error: function (errorThrown) {

            alert("not success :" + errorThrown);
        }
    });
});