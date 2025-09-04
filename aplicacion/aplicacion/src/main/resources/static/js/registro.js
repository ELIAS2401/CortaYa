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
const inputLocalidad = document.getElementById("idLocalidad");
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