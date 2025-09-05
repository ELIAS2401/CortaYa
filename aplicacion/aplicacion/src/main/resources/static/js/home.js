document.addEventListener("DOMContentLoaded", () => {
    const header = document.getElementById("mainHeader");
    const headerHeight = header.offsetHeight;
    let isFixed = false;
    let placeholder = null;

    const handleScroll = () => {
        const scrollY = window.scrollY;

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

    window.addEventListener("scroll", handleScroll);

    // 👉 Animación cartas al cargar
    const cartas = document.querySelector(".cartas");
    if (cartas) {
        setTimeout(() => {
            cartas.classList.add("visible");
        }, 300); // retardo de 0.3s
    };

});
