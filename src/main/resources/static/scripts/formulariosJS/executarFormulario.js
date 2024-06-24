document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll('.listaPergunta .tituloPergunta a').forEach(function(element) {
        element.addEventListener('click', function(event) {
            event.preventDefault();
            let parent = element.closest('.listaPergunta');
            let content = parent.querySelector('.alternativasPerguntas');
            if (parent.classList.contains('ativo')) {
                content.style.display = 'none';
                parent.classList.remove('ativo');
            } else {
                content.style.display = 'flex';
                parent.classList.add('ativo');
            }
        });
    });
});