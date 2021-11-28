
import { Product } from './types';

type Props = {
    product: Product;
}

function ProductCard({product}:Props){
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

export default ProductCard;
