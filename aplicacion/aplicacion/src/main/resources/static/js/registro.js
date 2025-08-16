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

const localidadInput = document.getElementById("localidad");
const suggestionsLocalidad = document.getElementById("suggestionsLocalidad");

let localidades = /*[[${localidades}]]*/ []; // Thymeleaf inyecta tu lista de localidades del backend

function filtrarLocalidades(query) {
    return localidades.filter(loc => loc.nombre.toLowerCase().includes(query.toLowerCase()));
}

localidadInput.addEventListener("input", () => {
    const query = localidadInput.value.trim();
    const resultados = query ? filtrarLocalidades(query) : localidades;

    suggestionsLocalidad.innerHTML = "";
    resultados.forEach(loc => {
        const li = document.createElement("li");
        li.className = "list-group-item";
        li.textContent = loc.nombre;
        li.onclick = () => {
            localidadInput.value = loc.nombre;
            suggestionsLocalidad.innerHTML = "";

            // Coordenadas
            document.getElementById("localidadLat").value = loc.latitud.toFixed(6);
            document.getElementById("localidadLon").value = loc.longitud.toFixed(6);
            if(loc.codigoPostal) document.getElementById("localidadCP").value = loc.codigoPostal;

            // Mover mapa
            map.setView([loc.latitud, loc.longitud], 14);
            if (marcador) map.removeLayer(marcador);
            marcador = L.marker([loc.latitud, loc.longitud]).addTo(map);
        };
        suggestionsLocalidad.appendChild(li);
    });
});

// Mostrar lista completa al hacer focus
localidadInput.addEventListener("focus", () => {
    suggestionsLocalidad.innerHTML = "";
    localidades.forEach(loc => {
        const li = document.createElement("li");
        li.className = "list-group-item";
        li.textContent = loc.nombre;
        li.onclick = () => {
            localidadInput.value = loc.nombre;
            suggestionsLocalidad.innerHTML = "";

            document.getElementById("localidadLat").value = loc.latitud.toFixed(6);
            document.getElementById("localidadLon").value = loc.longitud.toFixed(6);
            if(loc.codigoPostal) document.getElementById("localidadCP").value = loc.codigoPostal;

            map.setView([loc.latitud, loc.longitud], 14);
            if (marcador) map.removeLayer(marcador);
            marcador = L.marker([loc.latitud, loc.longitud]).addTo(map);
        };
        suggestionsLocalidad.appendChild(li);
    });
});