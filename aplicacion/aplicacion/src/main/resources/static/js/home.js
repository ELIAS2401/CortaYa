document.addEventListener("DOMContentLoaded", () => {
    // ----- HEADER -----
    const header = document.getElementById("mainHeader");
    const headerHeight = header.offsetHeight;
    let isFixed = false;
    let placeholder = null;

    const setHeaderFixedState = (scrollY) => {
        if (scrollY > headerHeight && !isFixed) {
            placeholder = document.createElement("div");
            placeholder.className = "header-placeholder";
            header.parentNode.insertBefore(placeholder, header);

            header.classList.remove("slide-up");
            header.classList.add("fixed-header");

            isFixed = true;
        } else if (scrollY <= headerHeight && isFixed) {
            header.classList.add("slide-up");
            header.addEventListener("animationend", function handler() {
                header.classList.remove("fixed-header", "slide-up");

                if (placeholder && placeholder.parentNode) {
                    placeholder.parentNode.removeChild(placeholder);
                    placeholder = null;
                }

                isFixed = false;
                header.removeEventListener("animationend", handler);
            });
        }
    };

    // ----- CARTAS -----
    const cartas = document.querySelector(".cartas");
    const carousel = document.getElementById("carouselExample");
    if (!cartas || !carousel) return;

    let lastScrollY = window.scrollY;

    const updateCartasVisibility = () => {
        const scrollY = window.scrollY;

        const headerBottom = header.getBoundingClientRect().bottom + scrollY;
        const carouselTop = carousel.getBoundingClientRect().top + scrollY;

        // Si la ventana está completamente por encima del carousel
        if (scrollY + window.innerHeight <= carouselTop) {
            // Mostrar cartas
            cartas.classList.remove("ocultas");
            cartas.classList.add("visible");
        } else if (scrollY >= headerBottom) {
            // Ocultar cartas
            cartas.classList.add("ocultas");
            cartas.classList.remove("visible");
        }

        lastScrollY = scrollY;
    };

    // Inicializar cartas según la posición inicial
    window.requestAnimationFrame(() => {
        setHeaderFixedState(window.scrollY);
        updateCartasVisibility();
    });

    // Detectar scroll
    window.addEventListener("scroll", () => {
        setHeaderFixedState(window.scrollY);
        updateCartasVisibility();
    });

    // Animación de entrada de izquierda a derecha solo al cargar si la página está arriba
    if (window.scrollY === 0) {
        setTimeout(() => {
            cartas.classList.add("visible");
        }, 300);
    }
});
