import "./styles.css";
import StepsHeader from "./StepsHeader";
import ProductList from "./ProductList";
import Footer from "../Footer";
import OrderSummary from "./OrderSummary";

function Orders() {
  return (
    <div className="orders-container">
      <StepsHeader />
      <ProductList />
      <OrderSummary />
      <Footer />
    </div>
  );
}

export default Orders;
