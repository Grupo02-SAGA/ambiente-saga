////document.addEventListener("DOMContentLoaded", function() {
////
////    const searchInput = document.getElementById('searchInput');//pega o que o usuário digitar
////
////    const tableRows = document.querySelectorAll('.listaForm')
////    //toda vez que digitar dispara isso
////    searchInput.addEventListener('input', function() {
////
////        const searchText = this.value.toLowerCase();
////
////        tableRows.forEach(function(row) {
////            const rowData = row.innerText.toLowerCase(); // Pega o innerText de cada linha
////            console.log(rowData);
////
////            if (rowData.includes(searchText)) {
////                row.style.display = '';
////            } else {
////                row.style.display = 'none';
////            }
////        });
////    });
////});
//
//document.addEventListener("DOMContentLoaded", function() {
//
//    const searchInput = document.getElementById('searchInput'); // pega o que o usuário digitar
//    const tableRows = document.querySelectorAll('.listaForm'); // seleciona todas as linhas da tabela
//    let timeout = null; // variável para armazenar o timeout
//
//    searchInput.addEventListener('input', function() {
//        clearTimeout(timeout); // limpa o timeout anterior
//
//        // define um novo timeout☺♂
//        timeout = setTimeout(function() {
//            const searchText = searchInput.value.toLowerCase();
//
//            tableRows.forEach(function(row) {
//                const rowData = row.innerText.toLowerCase(); // Pega o innerText de cada linha
//                console.log(rowData);
//
//                if (rowData.includes(searchText)) {
//                    row.style.display = '';
//                } else {
//                    row.style.display = 'none';
//                }
//            });
//        }, 1000); // atraso de 1 segundo (1000 milissegundos)
//    });
//});
//
//document.addEventListener('DOMContentLoaded', (event) => {
//    const searchInput = document.getElementById('searchInput');
//    const searchForm = document.getElementById('searchForm');
//    let typingTimer;                // Timer identifier
//    const doneTypingInterval = 500; // Time in ms (0.5 seconds)
//
//    searchInput.addEventListener('keyup', () => {
//        clearTimeout(typingTimer);
//        typingTimer = setTimeout(doneTyping, doneTypingInterval);
//    });
//
//    searchInput.addEventListener('keydown', () => {
//        clearTimeout(typingTimer);
//    });
//
//    function doneTyping () {
//        searchForm.submit();
//    }
//});
