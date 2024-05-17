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

<<<<<<< HEAD
//coloca o nome da sua lista aqui!!
const redirecionar_pagina = () => {
    return location.href = "/lista_forms_base";
=======

const redirecionar_pagina = () => {
    return location.href = "/lista_empresas";
>>>>>>> cbf934332ee7c5f039b0f1538445d8f95da8d93c
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
<<<<<<< HEAD
    fade_fundo_confirmar.style.display = 'none';
    body_popup_confirmar.style.display = 'none';
    redirecionar_pagina();
=======
        fade_fundo_confirmar.style.display = 'none';
        body_popup_confirmar.style.display = 'none';
        redirecionar_pagina();
>>>>>>> cbf934332ee7c5f039b0f1538445d8f95da8d93c
    });
}