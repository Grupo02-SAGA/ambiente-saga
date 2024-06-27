const limparInput = document.getElementById('limpar_input');
const botaoCancelar = document.getElementById("btnCancelar");
const fade = document.getElementById("fade_editar");
const fadePopup = document.getElementById("fade_cancelar");
const popupCancelar = document.getElementById("popup");
const popup = document.getElementById("popup_edicao");
const botaoSim = document.getElementById("confirmar_edicao");
const BotaoNao = document.getElementById("cancelar_fragmento");
const BotaoFragmento = document.getElementById("confirmar_fragmento")
const botao = document.getElementById("btn_confirmar_fragmento");
const fade_fundo_confirmar = document.getElementById("fade_confirmar");
const body_popup_confirmar = document.getElementById("popup_confirmacao");


const togglePopup = () => {
    [popup, fade].forEach((el) => el.classList.toggle("hide"));
};

const toggleCancelar = () => {
    [fadePopup, popupCancelar].forEach((el) => el.classList.toggle("hide"));
}

limparInput.addEventListener('click', (event) => {
    event.preventDefault();
    document.querySelector('.inputPergunta').value = '';
});

if (botao) {
    botao.addEventListener("click", () => {
        fade_fundo_confirmar.style.display = 'none';
        body_popup_confirmar.style.display = 'none';
    })
}

botaoCancelar.addEventListener("click", () => {
    toggleCancelar();
});

if(botaoSim){
    botaoSim.addEventListener("click", () => {
        fade.style.display = 'none';
        popup.style.display = 'none';
    });
};

if(BotaoNao){
    BotaoNao.addEventListener("click", () => {
        toggleCancelar();
    });
};

const redirecionar_pagina = () =>{
    return location.href = "/listaFormsBase"
}

if(BotaoFragmento){
    BotaoFragmento.addEventListener("click", () => {
        redirecionar_pagina();
    });
};


