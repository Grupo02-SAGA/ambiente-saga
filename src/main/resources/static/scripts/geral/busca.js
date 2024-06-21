document.addEventListener("DOMContentLoaded", function() {

    const searchInput = document.getElementById('searchInput');//pega o que o usuário digitar
    const tableRows = document.querySelectorAll('.listaForm')
    //toda vez que digitar dispara isso
    searchInput.addEventListener('input', function() {

        const searchText = this.value.toLowerCase();

        tableRows.forEach(function(row) {
            const rowData = row.innerText.toLowerCase(); // Pega o innerText de cada linha
            console.log(rowData);

            if (rowData.includes(searchText)) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });
    });
});