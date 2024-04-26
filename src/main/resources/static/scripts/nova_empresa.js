const carregar_popup_cancelar = () => {
    const cancelar_popup = document.getElementById("fragmento_popup_cancelar");

    const css_dinamico = document.createElement('link');
    css_dinamico.rel = 'stylesheet';
    css_dinamico.href = '/styles/style_popup_cancelar.css';
    document.head.appendChild(css_dinamico);

    fetch("/register")
        .then(response => response.text())
        .then(html => {
            cancelar_popup.innerHTML = html;

            const button_sim_popup = document.getElementById("confirmar_fragmento");
            const button_nao_popup = document.getElementById("cancelar_fragmento");
            const fade_fundo = document.getElementById("fade");

            const recarregar_pagina = () => {
                return location.href = "/register";
            };

            if(button_sim_popup) {
                button_sim_popup.addEventListener("click", recarregar_pagina);
            }
            if(button_nao_popup) {
                button_nao_popup.addEventListener("click", () => {
                    cancelar_popup.innerHTML = '';
                    fade_fundo.style.display = 'none';
                });
            }
        })
        .catch(error => console.error('Erro ao carregar o fragmento:', error));
};

document.addEventListener("DOMContentLoaded", function() {
    const button_cancelar = document.getElementById("cancelar");
    button_cancelar.addEventListener("click", carregar_popup_cancelar);
});
