document.addEventListener('DOMContentLoaded', () => {
    const searchInput = document.getElementById('searchInput');
    const filterSelect = document.getElementById('filterSelect');

    filterSelect.addEventListener('change', () => {
        const filter = filterSelect.value;
        let url = `/listaAvaliacoes?page=0&size=20&filter=${filter}`;
        if (filter.startsWith('base')) {
            const status = filter === 'base1' ? 1 : (filter === 'base2' ? 2 : 3);
            url += `&status=${status}`;
        }
        window.location.href = url;
    });
});
