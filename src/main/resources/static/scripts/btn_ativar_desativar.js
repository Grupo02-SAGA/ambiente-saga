const estilo = document.getElementById("ativo_inativo");
const estadoInput = document.getElementById("estadoInput")

const animarEstilo = () => {
    estilo.classList.toggle("inativo");

    estadoInput.value = estadoInput.value === "true" ? "false" : "true";

    if (estilo.classList.contains("inativo") && estadoInput.value === "false") {
        estilo.innerHTML = "Inativo";
    } else {
        estilo.innerHTML = "Ativo";
    }
};

estilo.addEventListener("click", () => {
    animarEstilo();
});
