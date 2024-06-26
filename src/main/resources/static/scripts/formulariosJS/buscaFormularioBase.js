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
        let url = `/listaFormsBase?page=0&size=20&filter=${filter}`;

        if (filter === '1') {
            url += `&estado=true`;
        } else if (filter === '0') {
            url += `&estado=false`;
        }

        if (searchTerm) {
            url += `&searchTerm=${encodeURIComponent(searchTerm)}`;
        }

        window.location.href = url;
    }
});
