import "./styles.css";
import StepsHeader from "./StepsHeader";
import ProductList from "./ProductList";
import Footer from "../Footer";

function Orders() {
  return (
    <div className="orders-container">
      <StepsHeader />
      <ProductList />
      <Footer />
    </div>
  );
}

export default Orders;
