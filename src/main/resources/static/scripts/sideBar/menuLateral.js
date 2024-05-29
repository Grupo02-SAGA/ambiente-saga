function clickmenu() {
    var menu = document.querySelector('.menu');
    var logoMenu = document.querySelector('.logo-hamburger');


    if (menu.style.display === "block") {
        menu.style.display = "none";
        logoMenu.classList.remove('active');
    } else {
        menu.style.display = "block";
        logoMenu.classList.add('active');
    }
}

document.addEventListener("click", function(event) {
    var menu = document.querySelector('.menu');
    var logoMenu = document.querySelector('.logo-hamburger');

    if (menu.style.display === "block" && event.target !== document.querySelector(".logo-hamburger img")) {
        menu.style.display = "none";
        logoMenu.classList.remove('active');
    }
});