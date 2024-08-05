document.addEventListener('DOMContentLoaded', function() {
    const perguntasContainer = document.querySelector('.listarPerguntas');

    function initializePergunta(pergunta, index) {
        const titulo = pergunta.querySelector('.tituloPergunta a');
        const container = pergunta.querySelector('.perguntaContainer');
        const tituloTexto = pergunta.querySelector('.tituloPergunta h3');
        const tituloOriginal = tituloTexto.textContent;
        const inputResposta = pergunta.querySelector('input[type="hidden"]');

        // Salvar o título original no dataset do elemento
        tituloTexto.dataset.originalTitle = tituloOriginal;

        // Adiciona evento de clique para expandir/recolher
        titulo.addEventListener('click', function(event) {
            event.preventDefault();
            const expandido = pergunta.classList.contains('expandir');

            // Fecha todas as outras perguntas
            document.querySelectorAll('.listaPergunta').forEach(p => {
                const pTituloTexto = p.querySelector('.tituloPergunta h3');
                const pContainer = p.querySelector('.perguntaContainer');
                const pCheckboxes = p.querySelectorAll('input[type="checkbox"]');
                const pAlgumMarcado = Array.from(pCheckboxes).some(checkbox => checkbox.checked);

                p.classList.remove('expandir');
                pContainer.style.display = 'none';

                if (pAlgumMarcado) {
                    pTituloTexto.textContent = 'RESPONDIDO';
                    pTituloTexto.style.color = '#35B02A';
                } else {
                    pTituloTexto.textContent = pTituloTexto.dataset.originalTitle;
                    pTituloTexto.style.color = '';
                }
            });

            // Se não estava expandido antes, expandir e recolher
            if (!expandido) {
                pergunta.classList.add('expandir');
                container.style.display = 'flex';
                tituloTexto.textContent = tituloTexto.dataset.originalTitle;
                tituloTexto.style.color = '';
            } else {
                // Verifica se há resposta marcada
                const checkboxes = container.querySelectorAll('input[type="checkbox"]');
                const algumMarcado = Array.from(checkboxes).some(checkbox => checkbox.checked);

                if (algumMarcado) {
                    tituloTexto.textContent = 'RESPONDIDO';
                    tituloTexto.style.color = '#35B02A';
                } else {
                    tituloTexto.textContent = tituloTexto.dataset.originalTitle;
                    tituloTexto.style.color = '';
                }
            }
        });

        // Permite que apenas um checkbox seja marcado
        const checkboxes = container.querySelectorAll('input[type="checkbox"]');
        checkboxes.forEach(checkbox => {
            // Adiciona o atributo data-resposta para garantir que ele esteja definido
            checkbox.dataset.resposta = checkbox.value;

            checkbox.addEventListener('change', function() {
                if (this.checked) {
                    checkboxes.forEach(box => {
                        if (box !== this) {
                            box.checked = false;
                        }
                    });
                    // Atualiza o valor do input hidden 0 = conforme, 1 = não conforme, 2 = não se aplica
                    inputResposta.value = this.dataset.resposta;
                } else {
                    inputResposta.value = '';
                }
            });
        });

        // Faz abrir o seletor de arquivos
        const documentoLink = container.querySelector('.documentoPergunta a');
        const inputDocumento = container.querySelector('.inputDocumento');
        const nomeDocumento = container.querySelector('.nomeDocumento');

        documentoLink.addEventListener('click', function(event) {
            event.preventDefault();
            inputDocumento.click();
        });

        // Substitui o texto do HTML pelo nome do arquivo
        inputDocumento.addEventListener('change', function() {
            if (inputDocumento.files.length > 0) {
                nomeDocumento.textContent = inputDocumento.files[0].name;
            } else {
                nomeDocumento.textContent = 'Nenhum arquivo selecionado';
            }
        });
    }

    // Inicializar todas as perguntas da página
    const perguntas = document.querySelectorAll('.listaPergunta');
    perguntas.forEach((pergunta, index) => {
        // Atribui um identificador único baseado no índice
        pergunta.dataset.perguntaId = index;
        initializePergunta(pergunta, index);
    });
});

// Iniciando popup
const popupCancelar = document.getElementById('cancelarResposta');
const fade_fundo = document.getElementById("fade_cancelar");
const popup = document.getElementById("popup");
const button_sim_popup = document.getElementById("confirmar_fragmento");
const button_nao_popup = document.getElementById("cancelar_fragmento");

const togglePopup = () => {
    [popup, fade_fundo].forEach((el) => el.classList.toggle("hide"));
};

popupCancelar.addEventListener("click", () => {
    togglePopup();
});

const redirecionar_pagina = () => {
    return location.href = "/executarAvaliacao";
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