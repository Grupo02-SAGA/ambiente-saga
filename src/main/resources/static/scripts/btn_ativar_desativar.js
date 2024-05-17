const estilo = document.getElementById("ativo_inativo");
const estadoInput = document.getElementById("estadoInput");

const animarEstilo = () => {

    estilo.classList.remove("ativo");
    estilo.classList.remove("inativo");

    if (estadoInput.value === "false") {
        estilo.classList.add("inativo");
        estilo.innerHTML = "Inativo";
    } else {
        estilo.classList.add("ativo");
        estilo.innerHTML = "Ativo";
    }

    estadoInput.value = estadoInput.value === "true" ? "false" : "true";
};

estilo.addEventListener("click", () => {
    animarEstilo();
});
