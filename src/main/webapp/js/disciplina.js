/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function ($) {
    setupDataMask();
    $("#dt").mask("99/99/9999");
    $('#divPresente').slideUp();
});

function gerar() {
//    var id = $('#idDisciplina').val()
    var id = $('#id').val();
    var dt = $('#dt').val();
    $.ajax({
        url: $('#url').val() + '/ajax/geraSchedule!geraSchedule',
        data: {
            'id': id,
            'dt': dt
        },
        success: function (data) {
            if (data.dsErro === "erro") {
                bootbox.alert("Ocorreu um erro.");
            }
            location.reload();
        },
        error: function () {
            bootbox.alert("Ocorreu um erro.");
        }
    });
}

function carregaPresenca(idSchedule) {
    var id = $('#id').val();
    $.ajax({
        url: $('#url').val() + '/ajax/carregaListaPresenca!carregaListaPresenca',
        data: {
            'idSchedule': idSchedule,
            'id': id
        },
        success: function (data) {
            if (data.dsErro === "erro") {
                bootbox.alert("Ocorreu um erro.");
            }
            $('#divPresente').empty();
            $('#divPresente').html(data);
            $('#divPresente').slideDown();
        },
        error: function () {
            bootbox.alert("Ocorreu um erro.");
        }
    });
}
function adicionaPresenca(idSchedule) {
    var id = $('#id').val();
    $.ajax({
        url: $('#url').val() + '/ajax/adicionaPresenca!adicionaPresenca',
        data: {
            'idSchedule': idSchedule,
            'id': id
        },
        success: function (data) {
            if (data.dsErro === "erro") {
                bootbox.alert("Ocorreu um erro.");
            }
            $('#divPresente').empty();
            $('#divPresente').html(data);
            $('#divPresente').slideDown();
        },
        error: function () {
            bootbox.alert("Ocorreu um erro.");
        }
    });
}
function carregaAlunos() {
    var id = $('#comboDisciplina').val();
    $.ajax({
        url: $('#url').val() + '/ajax/carregaListaAlunosByDisciplina!carregaListaAlunosByDisciplina',
        data: {
            'id': id
        },
        success: function (data) {
            if (data.dsErro === "erro") {
                bootbox.alert("Ocorreu um erro.");
            }
            $('#divAlunos').empty();
            $('#divAlunos').html(data);
            $('#divAlunos').slideDown();

        },
        error: function () {
            bootbox.alert("Ocorreu um erro.");
        }
    });
    loadAlunos();
}

function removeMatricula(idAluno) {
    var id = $('#comboDisciplina').val();
    $.ajax({
        url: $('#url').val() + '/ajax/removeMatricula!removeMatricula',
        data: {
            'id': id,
            'idAluno': idAluno
        },
        success: function (data) {
            if (data.dsErro === "erro") {
                bootbox.alert("Ocorreu um erro.");
            }
            carregaAlunos();
        },
        error: function () {
            bootbox.alert("Ocorreu um erro.");
        }
    });
}

function loadAlunos() {
    var id = $('#comboDisciplina').val();
    $.ajax({
        url: $('#url').val() + '/ajax/loadAluno!loadAluno',
        async: false,
        data: {
            "id": id
        },
        success: function (data) {
            var select = $('#comboAluno');
            select.html("");
            select.append("<option value=''></option>");
            $.each(data.alunoList, function (key, objeto) {
                select.append("<option value=" + objeto.idAluno + " > " +
                        objeto.nmAluno + " </option>");
            });
        },
        error: function () {
        }
    });
}


function criaMatricula() {

    var id = $('#comboDisciplina').val();
    var idAluno = $('#comboAluno').val();
    $.ajax({
        url: $('#url').val() + '/ajax/criaMatricula!criaMatricula',
        async: false,
        data: {
            "id": id,
            "idAluno": idAluno
        },
        success: function (data) {
            carregaAlunos();
        },
        error: function () {
        }
    });

}