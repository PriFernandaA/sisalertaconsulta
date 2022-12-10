(function(){
    $("#formexame").on("click", ".js-add-paciente", function(){
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

    $("#formexame").on("click", ".js-add-clinica", function(){
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
            url: `/exames/${formProp}/add/`,
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

    $("#tabexame").on("click",".js-delete", function(){
        let botaoClicado  = $(this);
        $("#btnsim").attr("data-id",botaoClicado.attr("data-id"));
        $("#modalexame").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/exames/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/exames";
            }
        });
    });
})();