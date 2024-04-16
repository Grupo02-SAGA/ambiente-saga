function clickmenu() {
    // Se o menu estiver visível, oculta-o; caso contrário, exibe-o
    if (itens.style.display === "block") {
        itens.style.display = "none";
    } else {
        itens.style.display = "block";
    }
}

// Adiciona um event listener para ocultar o menu ao clicar fora dele
document.addEventListener("click", function(event) {
    // Verifica se o clique foi fora do menu e fora do ícone do menu
    if (itens.style.display === "block" && event.target !== document.querySelector(".logo-menu img")) {
        itens.style.display = "none";
    }
});
