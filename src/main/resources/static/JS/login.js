$(document).ready(function(){

});

async function login(){
    let datos = {};
    datos.correo = document.getElementById('correo').value;
    datos.contrasena = document.getElementById('contrasena').value;

    const request = await fetch('api/login',{
        method: 'POST',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    const dataUser = await request.text();
    if(dataUser != "Fail"){
        localStorage.token = dataUser;
        localStorage.email = datos.correo;
        window.location.href = 'index.html'
    }else{
        alert("Las credenciales son incorrectos. Por favor intente nuevamente.");
    }
}