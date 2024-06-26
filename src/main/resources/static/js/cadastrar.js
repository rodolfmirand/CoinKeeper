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
        mensagemCadastro('Senhas diferentes.')
        return;
    }

    if (login == "" || email == "" || nome == "" || senha == "" || senhaConfirm == "") {
        mensagemCadastro('Campos vazios.');
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
                mensagemCadastro(xhr.responseText, "sucesso");
                limparInput();
            } else {
                console.error('Erro ao fazer requisição', xhr.status);
                mensagemCadastro(xhr.responseText, null);
            }
        }
    };

    xhr.send(JSON.stringify(data));
}

function mensagemCadastro(response, status) {
    const divAlert = document.getElementById('alert-message');
    divAlert.innerText = response;

    if (status == "sucesso") {
        divAlert.style.backgroundColor = 'rgb(7, 83, 7)';
    } else {
        divAlert.style.backgroundColor = '#8a6102';
    }

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