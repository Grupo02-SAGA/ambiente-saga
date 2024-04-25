function clickmenu() {
    var menu = document.querySelector('.menu');
    var logoMenu = document.querySelector('.logo-menu');

    
    if (menu.style.display === "block") {
        menu.style.display = "none";
        logoMenu.classList.remove('active');
    } else {
        menu.style.display = "block";
        logoMenu.classList.add('active');
    }
}

// Adiciona um event listener para ocultar o menu ao clicar fora dele
document.addEventListener("click", function(event) {
    var menu = document.querySelector('.menu');
    var logoMenu = document.querySelector('.logo-menu');

    // Verifica se o clique foi fora do menu e fora do ícone do menu
    if (menu.style.display === "block" && event.target !== document.querySelector(".logo-menu img")) {
        menu.style.display = "none";
        logoMenu.classList.remove('active');
    }
});
