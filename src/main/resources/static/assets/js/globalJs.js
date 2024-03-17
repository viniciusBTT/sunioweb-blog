
//Montando a data table client side
    document.addEventListener('DOMContentLoaded', function () {
        let table = new DataTable('#table', {
            language: {
                decimal: ',',
                thousands: '.',
                emptyTable: "Nenhum registro localizado",
                search: "Pesquisar",
                loadingRecords: "Carregando",
                zeroRecords: "Nenhum registro localizado",
                lengthMenu: "Mostrar _MENU_ registros",
                info: "Mostrando de _START_ a _END_ de _TOTAL_ resultados",
                infoEmpty: "Mostrando 0 a 0 de 0 registros",
                infoFiltered: "Filtrado de _MAX_ entradas totais",
                paginate: {
                    firts: "Primeiro",
                    last: "Ultimo",
                    next: "Proximo",
                    previous: "Anterior"
                }
            },
            responsive: true,
            columnDefs: [{
                targets: -1,
                orderable: false
            }]
        });
    });



//Gatilhos para o retorno de sucesso e falha
    if(success)
        alertSuccess();

    if(error)
        alertError();

    //gatilho para o alerta de sucesso
    function alertSuccess(){
        Swal.fire({
            icon: 'success',
            position: "center",
            html: success,
            timer: 1800,
            timerProgressBar: true,
            background: '#f1f1f1',
            showConfirmButton: false,
        })
    }
    //gatilho para o alerta de erro
    function alertError(){
        Swal.fire({
            icon: 'error',
            position: "center",
            html: error,
            timerProgressBar: true,
            background: '#f1f1f1 ',
            backdrop: "rgba(0, 0, 0, 0)" ,
        })
    }

//Marca o item do sidebar conrrespondente a página

function setSidebarActive(sideBarActive){
        const menuItens = document.querySelectorAll(".nav-link");
        menuItens[sideBarActive].classList.add("active");
}
setSidebarActive(sideBarActive)

