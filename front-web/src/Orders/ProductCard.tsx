import { ReactComponent as Remedio } from "./remedio.svg";

// type props {
//   product: Product;
//   onSelectProduct: (product) => void;
// }

function Orders() {
  return (
    <div
      className="order-card-container"
      //  onClick={() => onSelectProduct(product)}
    >
      <h3 className="order-card-title">DorFlex</h3>
      <Remedio className="order-card-image" />
      <h3 className="order-card-price">R$35,90</h3>
      <div className="order-card-description">
        <h3>Descrição</h3>
        <p>Idicado para dores musculares</p>
      </div>
    </div>
  );
}

export default Orders;
