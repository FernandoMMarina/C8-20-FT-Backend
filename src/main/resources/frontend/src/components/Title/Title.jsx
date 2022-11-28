import styles from "./Title.module.css";
export const Title = () => {
  return (
    <div className={styles.titleContainer}>
      <span id="titleLeft">VILLAIN</span>
      <span id="titleRight">BURGER</span>
    </div>
  );
};
