import styles from "./ProductCard.module.css";

import Swal from "sweetalert2";
import withReactContent from "sweetalert2-react-content";
import "animate.css";

const swalert = withReactContent(Swal);
export const ProductCard = ({ img }) => {
  const animatedEntrances = [
    " animate__flipInX",
    " animate__rotateIn",
    " animate__rollIn",
    " animate__jackInTheBox",
    " animate__zoomIn",
    " animate__slideInDown",
    " animate__slideInLeft",
    " animate__fadeIn",
    " animate__lightSpeedInLeft",
  ];
  const animatedExits = [
    " animate__flipOutX",
    " animate__rotateOut",
    " animate__rollOut",
    " animate__hinge",
    " animate__zoomOut",
    " animate__slideOutDown",
    " animate__slideOutRight",
    " animate__fadeOut",
    " animate__lightSpeedOutRight",
  ];
  const animation = 3;

  const handleClick = (e) => {
    e.preventDefault();
    // console.log("Target ID :", e.target.id);
    // console.log("onHandleClick token", token);

    swalert.fire();
    swalert.fire({
      customClass: {
        container: [styles.swalertContainer],
        popup: [styles.swalertPopup],
        title: [styles.swalertTitle],
        htmlContainer: [styles.swalertHtml],
        actions: [styles.swalertActions],
        confirmButton: [styles.swalertConfirmButton],
      },
      showClass: {
        popup: "animate__animated" + [animatedEntrances[animation]],
      },
      hideClass: {
        popup: "animate__animated" + [animatedExits[animation]],
      },
      title: "OOPS!",
      text: "Componente en desarrollo...",
      backdrop: true,
      buttonsStyling: false,
      scrollbarPadding: false,
    });
  };

  return (
    <div className={styles.cardMainContainer}>
      <div id="imageContainer" className={styles.imageContainer}>
        <img src={img} alt="burger1"></img>
      </div>
      <div id="solidContainer" className={styles.solidContainer}>
        <div className={styles.burgerName}>Kingpin</div>
        <div className={styles.burgerPrice}>$8.45</div>
        <button className={styles.addButton} onClick={handleClick}>
          Añadir al carrito
        </button>
      </div>
    </div>
  );
};
