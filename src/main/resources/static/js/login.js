function logarUsuario() {
    const xhr = new XMLHttpRequest();
    const url = 'http://localhost:8080/coinkeeper/auth';
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
                const token = getTokenFromCookie('token');
                redirect(token);
            } else if (xhr.status === 400) {
                mensagemLogin(xhr.responseText);
            } else {
                mensagemLogin(xhr.responseText);
            }
        }
    };

    xhr.send(JSON.stringify(data));

}

function getTokenFromCookie(name) {
    const cookies = document.cookie;
    const cookieArray = cookies.split(';');
    for (let i = 0; i < cookieArray.length; i++) {
        let cookie = cookieArray[i].trim();
        if (cookie.startsWith(name + '=')) {
            return decodeURIComponent(cookie.substring(name.length + 1));
        }
    }
    return null;
}

function redirect(token) {
    const url = 'http://localhost:8080/coinkeeper/painel';
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.setRequestHeader('Authorization', 'Bearer ' + token); 
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
            } else {
                console.error('Erro na requisição:', xhr.status);
            }
        }
    };
    xhr.send();
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