document.addEventListener("DOMContentLoaded", () => {
    const header = document.getElementById("mainHeader");
    const headerHeight = header.offsetHeight;
    let isFixed = false;
    let placeholder = null;

    const handleScroll = () => {
        const scrollY = window.scrollY;

        if (scrollY > headerHeight && !isFixed) {
            // Crear placeholder para evitar salto
            placeholder = document.createElement("div");
            placeholder.className = "header-placeholder";
            header.parentNode.insertBefore(placeholder, header);

            // Mostrar header fijo con animación
            header.classList.remove("slide-up");
            header.classList.add("fixed-header");

            isFixed = true;
        } else if (scrollY <= headerHeight && isFixed) {
            // Animar salida y luego limpiar
            header.classList.add("slide-up");

            header.addEventListener("animationend", function handler() {
                header.classList.remove("fixed-header", "slide-up");

                // Remover placeholder
                if (placeholder && placeholder.parentNode) {
                    placeholder.parentNode.removeChild(placeholder);
                    placeholder = null;
                }

                isFixed = false;
                header.removeEventListener("animationend", handler);
            });
        }
    };

    window.addEventListener("scroll", handleScroll);
});
