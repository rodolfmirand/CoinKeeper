const xhr = new XMLHttpRequest();
const url = 'http://localhost:8080/coinkeeper/auth';

function logarUsuario() {

    const login = document.getElementById('login').value;
    const senha = document.getElementById('senha').value;

    if (login == "" || senha == "") {
        mensagemLogin('Insira seus dados!');
        return;
    }

    const data = {
        login: login,
        password: senha
    };

    console.log(data);

    const signupUrl = `${url}/login`;

    xhr.open('POST', signupUrl, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.withCredentials = true;

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                window.location.href = "principal.html";
            } else if(xhr.status === 400) {
                mensagemLogin(xhr.responseText);
            }else {
                console.error('Erro ao fazer requisição', xhr.status);
                mensagemLogin('Senha incorreta!');
            }
        }
    };

    xhr.send(JSON.stringify(data));

}

function mensagemLogin(response) {
    const divAlert = document.getElementById('alert-message');
    divAlert.innerText = response;
    divAlert.style.backgroundColor = '#8a6102';
    divAlert.style.display = 'flex';

    setTimeout(() => {
        divAlert.style.display = "none";
    }, 3000);
}

function limparInput() {
    document.getElementById('login').value = "";
    document.getElementById('senha').value = "";
}