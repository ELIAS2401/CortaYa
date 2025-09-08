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
             void cartas.offsetWidth; // Reinicia animación
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

    // ----- INFO DINÁMICA -----
    const servicios = {
            adultx: {
                titulo: "Corte Adultx",
                descripcion: "Un corte clásico o moderno, adaptado a tu estilo. Nuestros barberos profesionales te dejarán impecable sin salir de tu casa.",
                imagen: "/img/messi.jpg"
            },
            nini: {
                titulo: "Corte para Niñe",
                descripcion: "Cortes divertidos y cómodos para los más pequeños. Hacemos que la experiencia sea amena y rápida para ellxs.",
                imagen: "/img/maradona.jpg"
            },
            barba: {
                titulo: "Afeitado de Barba",
                descripcion: "Un afeitado prolijo, suave y a medida. Disfrutá de una experiencia relajante con acabado profesional.",
                imagen: "/img/potro.jpg"
            },
            tinte: {
                titulo: "Coloración y Tinte",
                descripcion: "Dale color a tu estilo. Realizamos coloraciones completas, reflejos, matices y mucho más. Todo sin salir de tu casa.",
                imagen: "/img/tipoDeCorte/seleccion.avif"
            }
        };

   const links = document.querySelectorAll(".nav-seleccion-servicio a");
       const titulo = document.getElementById("titulo-servicio");
       const descripcion = document.getElementById("descripcion-servicio");
       const imagen = document.getElementById("imagen-servicio");
       const imagen2=document.getElementById("imagen-servicio2");

   links.forEach(link => {
          link.addEventListener("click", (e) => {
              e.preventDefault(); // Evita que el enlace recargue la página

              const servicio = e.currentTarget.dataset.servicio;
              const data = servicios[servicio];

              if (data) {

                  titulo.textContent = data.titulo;
                  descripcion.textContent = data.descripcion;
                  imagen.src = data.imagen;
                  imagen.alt = data.titulo;
              }
          });
      });
  });