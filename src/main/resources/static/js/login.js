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
        senha: senha
    };

    const signupUrl = `${url}/login`;

    xhr.open('POST', signupUrl, true);
    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                if (xhr.response === null)
                    mensagemLogin('Senha incorreta!');
                // lógica para usar o token do response
            } else {
                console.error('Erro ao fazer requisição', xhr.status);
                mensagemLogin('Usuário não encontrado.');
            }
        }
    };

    xhr.send(JSON.stringify(data));

    limparInput();
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
    document.getElementById('nome').value = "";
    document.getElementById('login').value = "";
    document.getElementById('email').value = "";
    document.getElementById('senha').value = "";
    document.getElementById('senha-confirm').value = "";
}