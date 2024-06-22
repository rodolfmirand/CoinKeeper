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

    if (login == "" || email == "" || nome == "") {
        mensagemCadastro('campos-vazios');
        console.log("Campos vazios.")
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
                mensagemCadastro('sucesso');
            } else {
                console.error('Erro ao fazer requisição', xhr.status);
                mensagemCadastro();
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

function mensagemCadastro(response) {
    var divMessage = "";
    var msg = "";
    var message = "";

    switch (response) {
        case 'sucesso':
            divMessage = document.querySelector('.alert');
            msg = "Usuário cadastrado!";
            message = document.createElement("div");
            message.classList.add('message');
            message.style.backgroundColor = 'rgb(7, 83, 7)';
            break;
        case 'campos-vazios':
            divMessage = document.querySelector('.alert');
            msg = "Campos vazios!";
            message = document.createElement("div");
            message.classList.add('message');
            message.style.backgroundColor = 'rgb(110, 0, 0)';
            break;
    }

    message.innerText = msg;
    divMessage.appendChild(message);

    
    setTimeout(() => {
        message.style.display = "none";
    }, 3000);
}

