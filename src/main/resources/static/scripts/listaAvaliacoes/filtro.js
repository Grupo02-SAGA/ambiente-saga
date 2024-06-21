document.addEventListener('DOMContentLoaded', () => {
    const searchInput = document.getElementById('searchInput');
    const filterSelect = document.getElementById('filterSelect');
    let typingTimer;
    const doneTypingInterval = 500; // 0.5 segundos

    searchInput.addEventListener('keyup', () => {
        clearTimeout(typingTimer);
        typingTimer = setTimeout(doneTyping, doneTypingInterval);
    });

    searchInput.addEventListener('keydown', () => {
        clearTimeout(typingTimer);
    });

    filterSelect.addEventListener('change', () => {
        updateUrl();
    });

    function doneTyping() {
        updateUrl();
    }

    function updateUrl() {
        const filter = filterSelect.value;
        const searchTerm = searchInput.value;
        let url = `/listaAvaliacoes?page=0&filter=${filter}`;
        if (filter.startsWith('base')) {
            const status = filter === 'base1' ? 1 : (filter === 'base2' ? 2 : 3);
            url += `&status=${status}`;
        }
        if (searchTerm) {
            url += `&searchTerm=${encodeURIComponent(searchTerm)}`;
        }
        window.location.href = url;
    }
});

