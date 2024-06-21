const xhr = new XMLHttpRequest();
const url = 'http://localhost:8080/coinkeeper/auth';

function cadastrarUsuario() {

    const nome = document.getElementById('nome').value;
    const login = document.getElementById('login').value;
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;
    const senhaConfirm = document.getElementById('senha-confirm').value;

    if (senha !== senhaConfirm) {
        console.log('Senhas diferentes.');
        return;
    }

    // verificar se login já existe
    // verificar se email já existe

    const data = {
        nome: nome,
        login: login,
        email: email,
        senha: senha
    };

    const signupUrl = `${url}/signup`;

    xhr.open('POST', signupUrl, true);
    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                const response = JSON.parse(xhr.responseText);
                console.log(response);
            } else {
                console.error('Erro ao fazer requisição', xhr.status);
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