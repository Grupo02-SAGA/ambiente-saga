const estilo = document.getElementById("ativo_inativo");

const animarEstilo = () => {
    estilo.classList.toggle("inativo");
    if (estilo.classList.contains("inativo")) {
        estilo.innerHTML = "Inativo";
    } else {
        estilo.innerHTML = "Ativo";
    }
};

estilo.addEventListener("click", () => {
    animarEstilo();
});
