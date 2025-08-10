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

