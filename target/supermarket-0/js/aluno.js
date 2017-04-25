$(function ($) {

    atualizaTable();
    if (jQuery.fn.validate) {

    }
});

function atualizaTable() {

    if ($('#fgAtivo').is(':checked')) {
        $('#alunoTable').find('.inativo').removeClass('hide');
    } else {
        $('#alunoTable').find('.inativo').addClass('hide');
    }
}

function verifica() {
    $('#alunoForm').validate({
        rules: {
            "aluno.nmAluno": {
                maxlength: 255,
                required: true
            },
            "aluno.dtNascimento": {
                required: true
            },
            "aluno.nrTelefone": {
                required: true
            },
            "aluno.dsEmail": {
                required: true
            },
            "aluno.tagRfid": {
                required: true
            }
        }
    });
    
}