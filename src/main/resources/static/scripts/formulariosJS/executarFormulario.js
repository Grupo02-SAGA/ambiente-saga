document.addEventListener('DOMContentLoaded', function() {
    const perguntas = document.querySelectorAll('.listaPergunta');

    perguntas.forEach(pergunta => {
        const titulo = pergunta.querySelector('.tituloPergunta a');
        const container = pergunta.querySelector('.perguntaContainer');
        const tituloTexto = pergunta.querySelector('.tituloPergunta h3');
        const tituloOriginal = tituloTexto.textContent;

        titulo.addEventListener('click', function(event) {
            event.preventDefault();
            pergunta.classList.toggle('expandir');
            container.style.display = container.style.display === 'flex' ? 'none' : 'flex';

            const checkboxes = container.querySelectorAll('input[type="checkbox"]');
            let algumMarcado = Array.from(checkboxes).some(checkbox => checkbox.checked);

            if (algumMarcado && !pergunta.classList.contains('expandir')) {
                tituloTexto.textContent = 'RESPONDIDO';
                tituloTexto.style.color = 'green';
            } else {
                tituloTexto.textContent = tituloOriginal;
                tituloTexto.style.color = '';
            }
        });

        const checkboxes = container.querySelectorAll('input[type="checkbox"]');
        checkboxes.forEach(checkbox => {
            checkbox.addEventListener('change', function() {
                if (this.checked) {
                    checkboxes.forEach(box => {
                        if (box !== this) {
                            box.checked = false;
                        }
                    });
                }
            });
        });
    });
});
