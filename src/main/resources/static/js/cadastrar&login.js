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

    fetch(signupUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Erro ao chamar API: ${response.status} ${response.statusText}`);
        }
        return response.text();
    })
    .then(data => {
        console.log('Resposta do servidor:', data);
    })
    .catch(error => {
        console.log('Erro ao chamar API:', error);
    });
}
