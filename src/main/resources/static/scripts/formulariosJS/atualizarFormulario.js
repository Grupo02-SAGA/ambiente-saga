document.addEventListener('DOMContentLoaded', (event) => {
    const button_cancel_form = document.getElementById("btnCancelar");
    const fade_fundo_cancelar = document.getElementById("fade_cancelar");
    const popupCancelar = document.getElementById("popup");
    const confirma = document.getElementById("btn_confirma");
    const button_sim_popup = document.getElementById("confirmar_fragmento");
    const button_nao_popup = document.getElementById("cancelar_fragmento");
    const fade_fundo_confirmar = document.getElementById("fade_confirmar");
    const body_popup_confirmar = document.getElementById("popup_confirmacao");
    const button_confirmar_popup = document.getElementById("btn_confirmar_fragmento");

    const toggleCancelar = () => {
        [fade_fundo_cancelar, popupCancelar].forEach(el => el.classList.toggle("hide"));
    };

    const togglePopup = () => {
        [body_popup_confirmar, fade_fundo_confirmar].forEach(el => el.classList.toggle("hide"));
    };

    const redirecionar_pagina = () => {
        location.href = "/listaFormsBase";
    };

    button_cancel_form.addEventListener("click", () => {
        toggleCancelar();
    });

    if (button_sim_popup) {
        button_sim_popup.addEventListener("click", () => {
            redirecionar_pagina();
        });
    }

    if (button_nao_popup) {
        button_nao_popup.addEventListener("click", () => {
            toggleCancelar();
        });
    }

    if (button_confirmar_popup) {
        button_confirmar_popup.addEventListener("click", () => {
            fade_fundo_confirmar.style.display = 'none';
            body_popup_confirmar.style.display = 'none';
            redirecionar_pagina();
        });
    }

    // Função para mostrar o popup de confirmação
    window.mostrarPopupConfirmacao = () => {
        togglePopup();
    };

    // Submeter o formulário após a confirmação
    confirma.addEventListener("click", () => {
        const form = document.querySelector("form.criar_pergunta");
        if (form) {
            form.submit();
        }
    });
});



//// Esse é o botão de cancelar lá de baixo
//const button_cancel_form = document.getElementById("btnCancelar");
//// Esses provavelmente são os elementos do mesmo
//const fade_fundo_cancelar = document.getElementById("fade_cancelar");
//const popupCancelar = document.getElementById("popup");
//
//// Esse é o botão de confirmar
//const confirma = document.getElementById("btn_confirma");
//
//// Esse é na hora que clica em cancelar
//const button_sim_popup = document.getElementById("confirmar_fragmento");
//const button_nao_popup = document.getElementById("cancelar_fragmento");
//const fade_fundo_confirmar = document.getElementById("fade_confirmar");
//
//// Esse é o fragmento depois que clica em salvar
//const body_popup_confirmar = document.getElementById("popup_confirmacao");
//
//// Esse é o botão que clica depois dentro do popup de salvar
//const button_confirmar_popup = document.getElementById("btn_confirmar_fragmento");
//
//// CANCELAR
//const toggleCancelar = () => {
//    [fade_fundo_cancelar, popupCancelar].forEach(el => el.classList.toggle("hide"));
//};
//
//// CONFIRMAR
//const togglePopup = () => {
//    [body_popup_confirmar, fade_fundo_confirmar].forEach(el => el.classList.toggle("hide"));
//};
//
//// Esse é pra ativar o botão de cancelar lá de baixo
//button_cancel_form.addEventListener("click", () => {
//    toggleCancelar();
//});
//
//const redirecionar_pagina = () => {
//    location.href = "/listaFormsBase";
//};
//
//if (button_sim_popup) {
//    button_sim_popup.addEventListener("click", () => {
//        redirecionar_pagina();
//    });
//}
//
//if (button_nao_popup) {
//    button_nao_popup.addEventListener("click", () => {
//        toggleCancelar();
//    });
//}
//
//if (button_confirmar_popup) {
//    button_confirmar_popup.addEventListener("click", () => {
//        fade_fundo_confirmar.style.display = 'none';
//        body_popup_confirmar.style.display = 'none';
//        redirecionar_pagina();
//    });
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////document.addEventListener('DOMContentLoaded', (event) => {
////    const button_cancel_form = document.getElementById("btnCancelar");
////    const fade_fundo_cancelar = document.getElementById("fade_cancelar");
////    const popupCancelar = document.getElementById("popup");
////    const confirma = document.getElementById("btn_confirma");
////    const button_sim_popup = document.getElementById("confirmar_fragmento");
////    const button_nao_popup = document.getElementById("cancelar_fragmento");
////    const fade_fundo_confirmar = document.getElementById("fade_confirmar");
////    const body_popup_confirmar = document.getElementById("popup_confirmacao");
////    const button_confirmar_popup = document.getElementById("btn_confirmar_fragmento");
////
////    const toggleCancelar = () => {
////        [fade_fundo_cancelar, popupCancelar].forEach(el => el.classList.toggle("hide"));
////    };
////
////    const togglePopup = () => {
////        [body_popup_confirmar, fade_fundo_confirmar].forEach(el => el.classList.toggle("hide"));
////    };
////
////    const redirecionar_pagina = () => {
////        location.href = "/listaFormsBase";
////    };
////
////    const redirecionar_perguntas = () = {
////       fade_fundo_confirmar.style.display = 'none';
////       body_popup_confirmar.style.display = 'none';
////    };
////
////    button_cancel_form.addEventListener("click", () => {
////        toggleCancelar();
////    });
////
////    if (button_sim_popup) {
////        button_sim_popup.addEventListener("click", () => {
////            redirecionar_pagina();
////        });
////    }
////
////    if (button_nao_popup) {
////        button_nao_popup.addEventListener("click", () => {
////            toggleCancelar();
////        });
////    }
////
////    if (button_confirmar_popup) {
////        button_confirmar_popup.addEventListener("click", () => {
////            fade_fundo_confirmar.style.display = 'none';
////            body_popup_confirmar.style.display = 'none';
////            redirecionar_pagina();
////        });
////    }
////
////    // Função para mostrar o popup de confirmação
////    window.mostrarPopupConfirmacao = () => {
////        togglePopup();
////    };
////
////    // Submeter o formulário após a confirmação
////    confirma.addEventListener("click", () => {
////        const form = document.querySelector("form.criar_pergunta");
////        if (form) {
////            form.submit();
////        }
////    });
////});
////
////
////
////
////
//////// Esse é o botão de cancelar lá de baixo
//////const button_cancel_form = document.getElementById("btnCancelar");
//////// Esses provavelmente são os elementos do mesmo
//////const fade_fundo_cancelar = document.getElementById("fade_cancelar");
//////const popupCancelar = document.getElementById("popup");
//////
//////// Esse é o botão de confirmar
//////const confirma = document.getElementById("btn_confirma");
//////
//////// Esse é na hora que clica em cancelar
//////const button_sim_popup = document.getElementById("confirmar_fragmento");
//////const button_nao_popup = document.getElementById("cancelar_fragmento");
//////const fade_fundo_confirmar = document.getElementById("fade_confirmar");
//////
//////// Esse é o fragmento depois que clica em salvar
//////const body_popup_confirmar = document.getElementById("popup_confirmacao");
//////
//////// Esse é o botão que clica depois dentro do popup de salvar
//////const button_confirmar_popup = document.getElementById("btn_confirmar_fragmento");
//////
//////// CANCELAR
//////const toggleCancelar = () => {
//////    [fade_fundo_cancelar, popupCancelar].forEach(el => el.classList.toggle("hide"));
//////};
//////
//////// CONFIRMAR
//////const togglePopup = () => {
//////    [body_popup_confirmar, fade_fundo_confirmar].forEach(el => el.classList.toggle("hide"));
//////};
//////
//////// Esse é pra ativar o botão de cancelar lá de baixo
//////button_cancel_form.addEventListener("click", () => {
//////    toggleCancelar();
//////});
//////
//////const redirecionar_pagina = () => {
//////    location.href = "/listaFormsBase";
//////};
//////
//////if (button_sim_popup) {
//////    button_sim_popup.addEventListener("click", () => {
//////        redirecionar_pagina();
//////    });
//////}
//////
//////if (button_nao_popup) {
//////    button_nao_popup.addEventListener("click", () => {
//////        toggleCancelar();
//////    });
//////}
//////
//////if (button_confirmar_popup) {
//////    button_confirmar_popup.addEventListener("click", () => {
//////        fade_fundo_confirmar.style.display = 'none';
//////        body_popup_confirmar.style.display = 'none';
//////        redirecionar_pagina();
//////    });
//////}
