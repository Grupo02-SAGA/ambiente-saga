const button_cancel_form = document.getElementById("btnCancelar");
const fade_fundo = document.getElementById("fade_cancelar");
const popup = document.getElementById("popup");
const button_sim_popup = document.getElementById("confirmar_fragmento");
const button_nao_popup = document.getElementById("cancelar_fragmento");

const togglePopup = () => {
    [popup, fade_fundo].forEach((el) => el.classList.toggle("hide"));
};

button_cancel_form.addEventListener("click", () => {
    togglePopup();
});

const redirecionar_pagina = () => {
    return location.href = "/register";
};

if (button_sim_popup) {
    button_sim_popup.addEventListener("click", () => {
        redirecionar_pagina();
    });
}

if (button_nao_popup) {
    button_nao_popup.addEventListener("click", () => {
        togglePopup();
    });
}
