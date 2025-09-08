const btnCliente = document.getElementById("btnCliente");
const btnBarbero = document.getElementById("btnBarbero");
const rolInput = document.getElementById("rolInput");

btnCliente.addEventListener("click", () => {
    btnCliente.classList.add("active");
    btnBarbero.classList.remove("active");
    rolInput.value = "Cliente";
});

btnBarbero.addEventListener("click", () => {
    btnBarbero.classList.add("active");
    btnCliente.classList.remove("active");
    rolInput.value = "Barbero";
});

// Elementos del DOM
const inputLocalidad = document.getElementById("localidad");
const listaLocalidad = document.getElementById("suggestionsLocalidad");
const inputCalle = document.getElementById("calleAltura");
const listaCalle = document.getElementById("suggestionsCalle");

let localidades = [];
let localidadSeleccionadaId = null;

// --- Cargar localidades desde el backend ---
fetch('/api/localidades')
    .then(res => res.json())
    .then(data => {
        localidades = data || [];
    })
    .catch(err => console.error("Error al cargar localidades:", err));

// --- Autocomplete de localidades ---
inputLocalidad.addEventListener("input", () => {
    const valor = inputLocalidad.value.toLowerCase();
    listaLocalidad.innerHTML = "";
    localidadSeleccionadaId = null; // reset si cambia texto

    if (valor.length === 0) {
        listaLocalidad.style.display = "none";
        return;
    }

    const filtradas = localidades.filter(loc =>
        loc.nombre && loc.nombre.toLowerCase().includes(valor)
    );

    filtradas.forEach(loc => {
        const li = document.createElement("li");
        li.textContent = loc.nombre;
        li.classList.add("list-group-item");
        li.addEventListener("click", () => {
            inputLocalidad.value = loc.nombre;
            listaLocalidad.style.display = "none";

            document.getElementById("idLocalidad").value = loc.idLocalidad; // <-- esto es lo nuevo
            document.getElementById("localidadLat").value = loc.lat || '';
            document.getElementById("localidadLon").value = loc.lon || '';
            document.getElementById("localidadCP").value = loc.cp || '';

            localidadSeleccionadaId = loc.idLocalidad; // clave para calles
            inputCalle.value = ""; // limpiar calle al cambiar localidad
            listaCalle.innerHTML = "";
            listaCalle.style.display = "none";
        });
        listaLocalidad.appendChild(li);
    });

    listaLocalidad.style.display = filtradas.length > 0 ? "block" : "none";
});

// --- Autocomplete de calles ---
inputCalle.addEventListener("input", () => {
    const query = inputCalle.value;

    if (!localidadSeleccionadaId || query.length === 0) {
        listaCalle.innerHTML = "";
        listaCalle.style.display = "none";
        return;
    }
    console.log("Buscando calles en localidad:", localidadSeleccionadaId, "con query:", query);
    fetch(`/api/calles?idLocalidad=${localidadSeleccionadaId}&query=${encodeURIComponent(query)}`)
        .then(res => {
            console.log("Response bruta:", res);
            return res.json(); // <- acá parseamos a JSON
        })
        .then(data => {
            console.log("Calles recibidas:", data);
            listaCalle.innerHTML = "";

            data.forEach(calle => {
                const li = document.createElement("li");
                li.textContent = calle;
                li.classList.add("list-group-item");
                li.addEventListener("click", () => {
                    inputCalle.value = calle;
                    listaCalle.style.display = "none";
                });
                listaCalle.appendChild(li);
            });

            listaCalle.style.display = data.length > 0 ? "block" : "none";
        })
        .catch(err => console.error("Error al cargar calles:", err));
});

// --- Validación de contraseña en tiempo real ---
const passwordInput = document.getElementById("contrasenia");
const confirmPasswordInput = document.getElementById("confirmarContrasenia");

const passwordFeedback = document.createElement("div");
passwordFeedback.classList.add("form-text");
passwordInput.parentNode.appendChild(passwordFeedback);

function validarPassword(password) {
    const reglas = [
        { regex: /.{8,}/, mensaje: "Mínimo 8 caracteres" },
        { regex: /[A-Z]/, mensaje: "Al menos una mayúscula" },
        { regex: /[0-9]/, mensaje: "Al menos un número" },
        { regex: /[@$!%*?&]/, mensaje: "Al menos un caracter especial (@$!%*?&)" }
    ];
    return reglas.map(r => ({
        mensaje: r.mensaje,
        valido: r.regex.test(password)
    }));
}

passwordInput.addEventListener("input", () => {
    const resultados = validarPassword(passwordInput.value);
    passwordFeedback.innerHTML = resultados
        .map(r => r.valido ? `✅ ${r.mensaje}` : `❌ ${r.mensaje}`)
        .join("<br>");
});

confirmPasswordInput.addEventListener("input", () => {
    if (confirmPasswordInput.value !== passwordInput.value) {
        confirmPasswordInput.setCustomValidity("Las contraseñas no coinciden");
    } else {
        confirmPasswordInput.setCustomValidity("");
    }
});

// -- Validar nro celular --

const celularInput = document.getElementById("nroCelular");

celularInput.addEventListener("input", () => {
    const regex = /^\+?\d{10,15}$/;
    if (!regex.test(celularInput.value.replace(/\D/g, ''))) {
        celularInput.setCustomValidity("Ingresá un número de celular válido (mínimo 10 dígitos)");
    } else {
        celularInput.setCustomValidity("");
    }
});

