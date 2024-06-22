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

    const signupUrl = `${url}/signup`;

    xhr.open('POST', signupUrl, true);
    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                mensagemCadastro(getValueFromPath(xhr.response, 'message'));
            } else {
                console.error('Erro ao fazer requisição', xhr.status);
                mensagemCadastro(getValueFromPath(xhr.response, 'message'));
            }
        }
    };

    xhr.send(JSON.stringify(data));

    limparInput();
}

function limparInput() {
    document.getElementById('nome').value = "";
    document.getElementById('login').value = "";
    document.getElementById('email').value = "";
    document.getElementById('senha').value = "";
    document.getElementById('senha-confirm').value = "";
}

function mensagemLogin(response) {
    var divMessage = document.querySelector('.alert');
    var msg = response;
    var message = document.createElement("div");
    message.classList.add('message');
    message.innerText = msg;
    divMessage.appendChild(message);

    setTimeout(() => {
        message.style.display = "none";
    }, 3000);
}

function getValueFromPath(obj, path) {
    var json = JSON.parse(obj);
    const keys = path.split('.');
    let current = json;

    for (const key of keys) {
        if (current[key] === undefined) {
            return undefined;
        }
        current = current[key];
    }

    return current;
}