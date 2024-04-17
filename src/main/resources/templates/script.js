function clickmenu() {
    var conteudo = document.querySelector('.conteudo');
    var menu = document.querySelector('.menu');

    // Se a barra lateral estiver visível, oculta-a; caso contrário, exibe-a
    if (menu.style.display === "block") {
        menu.style.display = "none";
        conteudo.style.width = "100%"; // Quando a barra lateral é ocultada, o conteúdo ocupa 100% da largura
    } else {
        menu.style.display = "block";
        conteudo.style.width = "70%"; // Quando a barra lateral é exibida, o conteúdo ocupa 70% da largura
    }
}

// Adiciona um event listener para ocultar o menu ao clicar fora dele
document.addEventListener("click", function(event) {
    var menu = document.querySelector('.menu');

    // Verifica se o clique foi fora do menu e fora do ícone do menu
    if (menu.style.display === "block" && event.target !== document.querySelector(".logo-menu img")) {
        menu.style.display = "none";
        var conteudo = document.querySelector('.conteudo');
        conteudo.style.width = "100%"; // Quando o menu é ocultado ao clicar fora dele, o conteúdo ocupa 100% da largura
    }
});
