document.addEventListener('DOMContentLoaded', function () {
    var senhaInput = document.getElementById('senha');
    var confirmSenha = document.getElementById('confirmSenha');
    var toggleSenhaButton = document.getElementById('toggleSenha');

    toggleSenhaButton.addEventListener('click', function () {
        if (senhaInput.type === 'password') {
            senhaInput.type = 'text';
            confirmSenha.type = 'text';
            toggleSenhaButton.textContent = 'Ocultar Senha';
        } else {
            senhaInput.type = 'password';
            confirmSenha.type = 'password';
            toggleSenhaButton.textContent = 'Mostrar Senha';
        }
    });


    function togglePassword() {
    if (senhaInput.type === 'password') {
    passwordField.type = 'text';
    } else {
    senhaInput.type = 'password';
    }
    }

    togglePassword();

});
