const button_confirmar_popup = document.getElementById("btn_confirmar_fragmento");
const fade_fundo_confirmar = document.getElementById("fade_confirmar");
const body_popup_confirmar = document.getElementById("popup_confirmacao");


button_confirmar_popup.addEventListener("click", () => {
    fade_fundo_confirmar.style.display = 'none';
    body_popup_confirmar.style.display = 'none';
});
