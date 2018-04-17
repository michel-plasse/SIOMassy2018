/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$('input').blur(function (e) {
    var etat =$(e.target).val();
    var modifier=$(e.target).attr('id');
    alert("etat: ", etat, " | modifier: ", modifier);
   $.ajax({
        url:'NoteServlet',
        type:'Put',
        data:{"Etat":etat,"Modifier":modifier}
    });
   
      
});


