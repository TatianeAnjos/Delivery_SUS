<<<<<<< HEAD
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
=======
import { Product } from './types';

type Props = {
    product: Product;
>>>>>>> e63d1de03d76e6fba3dda6a9ecc53acdd64a28db
}

export default function ProductCard({product}:Props){
    return(
       <div className="order-card-container">
           <h3 className="order-card-title">
               {product.name}
           </h3>
            <img src= {product.imgUrl}className="order-card-image" alt={product.name}/>
             <h3 className="order-card-price">
             </h3>
             <div className="order-card-description">
                 <h3>Descrição</h3>
                 <p>{product.description}</p>
             </div>
             
       </div>
    );

}