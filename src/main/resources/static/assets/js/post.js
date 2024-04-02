function  handleBtnPostModal(id){
    url =  `/posts/save${id ? '/'+id : ''}`

    fetch(url, {
        method: 'GET'
    })
    .then(response => {
        // Retorna o corpo da resposta como texto
        return response.text();
    })
    .then(html => {

        Swal.fire({
            title: "Cadastro de postagem",
            html: html,
            showConfirmButton: false,
        })
    })
    .catch(error => {
        Swal.fire({
                    icon: 'error',
                    position: "center",
                    text: 'Erro ao buscar o post',
                    timerProgressBar: true,
                    background: '#f1f1f1 ',
                    backdrop: "rgba(0, 0, 0, 0)" ,
                })
        console.error('Erro', error);
    });


}
