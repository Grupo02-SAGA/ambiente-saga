const button_confirmar_popup = document.querySelector("#confirmar_fragmento");

const recarregar_pagina = () => {
    return location.href = "/register"
}

button_confirmar_popup.addEventListener("click", recarregar_pagina)
