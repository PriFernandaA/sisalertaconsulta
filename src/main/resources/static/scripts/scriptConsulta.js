(function(){
    $("#formconsulta").on("click", ".js-add-paciente", function(){
        $("#formprop").attr("prop", "paciente");

        const formInputs = $('.modal input');
        formInputs.each(function() {
            $(this).prop("disabled", true)
        })

        const pacienteInputs = $('#modaladdpaciente input');
        pacienteInputs.each(function() {
            $(this).prop("disabled", false)
        })

        $("#modaladdpaciente").modal("show");
    });
    
    $("#formconsulta").on("click", ".js-add-medico", function(){
        $("#formprop").attr("prop", "medico");

        const formInputs = $('.modal input');
        formInputs.each(function() {
            $(this).prop("disabled", true)
        })

        const medicoInputs = $('#modaladdmedico input');
        medicoInputs.each(function() {
            $(this).prop("disabled", false)
        })

        $("#modaladdmedico").modal("show");
    });

    $("#formconsulta").on("click", ".js-add-clinica", function(){
        $("#formprop").attr("prop", "clinica");

        const formInputs = $('.modal input');
        formInputs.each(function() {
            $(this).prop("disabled", true)
        })

        const clinicaInputs = $('#modaladdclinica input');
        clinicaInputs.each(function() {
            $(this).prop("disabled", false)
        })

        $("#modaladdclinica").modal("show");
    });

    $(".formmodal").on("submit", function(e){
        e.preventDefault();
        const formProp = $("#formprop").attr("prop");
        const data = $(this).serialize();
        $.ajax({
            url: `/consultas/${formProp}/add/`,
            method: "POST",
            data,
            success: function(res){
                let select = $(`#${formProp}select`);
                let option = $(`<option>${res.nome}</option>`);
                option.attr("value", res.id);
                option.prop("selected", "selected");

                select.append(option);

                $(`#modaladd${formProp}`).modal("hide");
            },
            error: function(err){
                alert(`Erro ao cadastrar ${formProp}, tente novamente mais tarde.`);
            }
        });
    });

    $("#tabconsulta").on("click",".js-delete", function(){
        let botaoClicado  = $(this);
        $("#btnsim").attr("data-id",botaoClicado.attr("data-id"));
        $("#modalconsulta").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/consultas/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/consultas";
            }
        });
    });
})();