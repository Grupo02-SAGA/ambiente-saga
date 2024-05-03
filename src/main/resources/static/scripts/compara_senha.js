//// Função para comparar as senhas
//function validarSenha() {
//    var senha = document.getElementById("senha").value;
//    var confirmSenha = document.getElementById("confirmSenha").value;
//
//    // Verificar se as senhas são iguais
//    if (senha !== confirmSenha) {
//        alert("As senhas não coincidem. Por favor, insira senhas iguais.");
//        return false; // Impede o envio do formulário
//    }
//    return true; // Permite o envio do formulário se as senhas forem iguais
//}

// Função para comparar as senhas
function validarSenha() {
    var senha = document.getElementById("senha").value;
    var confirmSenha = document.getElementById("confirmSenha").value;
    var mensagemErro = document.querySelector('.confereSenha');

    // Verificar se as senhas são iguais
    if (senha !== confirmSenha) {
        mensagemErro.style.display = "block"; // Exibe a mensagem de erro
        return false; // Impede o envio do formulário
    } else {
        mensagemErro.style.display = "none"; // Oculta a mensagem de erro se as senhas coincidirem
    }
    return true; // Permite o envio do formulário se as senhas forem iguais
}

// Evento para chamar a função de validação quando o formulário é enviado
document.getElementById("formulario").addEventListener("submit", function(event) {
    if (!validarSenha()) {
        event.preventDefault(); // Impede o envio do formulário se as senhas não coincidirem

    }
});
