document.addEventListener("DOMContentLoaded", function() {

    const searchInput = document.getElementById('searchInput'); // pega o que o usuário digitar
    const tableRows = document.querySelectorAll('.listaEmpresa');

    // toda vez que digitar, dispara isso
    searchInput.addEventListener('input', function() {

        const searchText = this.value.toLowerCase(); // pega o texto digitado pelo usuário em minúsculas

        tableRows.forEach(function(row) {
            const rowData = row.innerText.toLowerCase(); // pega o texto de cada linha em minúsculas

            if (rowData.includes(searchText)) {
                row.style.display = ''; // mostra a linha se o texto estiver presente
            } else {
                row.style.display = 'none'; // oculta a linha se o texto não estiver presente
            }
        });
    });
});
