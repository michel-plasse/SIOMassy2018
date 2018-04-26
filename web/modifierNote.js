$('input').change(function (event) {
    var note = $(event.target).val();
    var ids = $(event.target).attr('id').split("-");
   

    var params = "idEvaluation=" + ids[0] + "&idPersonne=" + ids[1] + "&note=" + note;
    $.ajax({
        url: 'modifierNote',
        type: 'POST',
        data: params,
        beforeSend: function (xhr) {
            console.log(params);
        },
        success: function (response) {
            console.log("ok");
            $("#message" + ids[1]).html("");
        },
        error: function (errorThrown) {
            console.log("not sucess :" + errorThrown);
            $("#message" + ids[1]).html(errorThrown.responseText);
        }
    });
    
    });


