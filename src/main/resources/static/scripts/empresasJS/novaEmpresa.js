const button_cancel_form = document.getElementById("cancel_form");
const fade_fundo = document.getElementById("fade_cancelar");
const popup = document.getElementById("popup");
const button_sim_popup = document.getElementById("confirmar_fragmento");
const button_nao_popup = document.getElementById("cancelar_fragmento");
//confirmação
const button_confirmar_popup = document.getElementById("btn_confirmar_fragmento");
const fade_fundo_confirmar = document.getElementById("fade_confirmar");
const body_popup_confirmar = document.getElementById("popup_confirmacao");

const togglePopup = () => {
    [popup, fade_fundo].forEach((el) => el.classList.toggle("hide"));
};

button_cancel_form.addEventListener("click", () => {
    togglePopup();
});


const redirecionar_pagina = () => {
    return location.href = "/listaEmpresas";
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
///confirmação
if (button_confirmar_popup){
    button_confirmar_popup.addEventListener("click", () => {
    fade_fundo_confirmar.style.display = 'none';
    body_popup_confirmar.style.display = 'none';
    redirecionar_pagina();

    });
}