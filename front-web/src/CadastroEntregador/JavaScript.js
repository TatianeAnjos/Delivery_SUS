function ValidarLogin(){
    var form = document.querySelector("#form-login")

    var name = form.name.value;
    // eslint-disable-next-line eqeqeq
    if (name == ""){
        alert("Preencher Senha")
    }

}