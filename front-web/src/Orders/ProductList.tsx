import ProductCard from './ProductCard';

function ProductList(){
    return(
       <div className="orders-list-container">
           <div className="orders-list-items">
           <ProductCard />
           <ProductCard />
           <ProductCard />
           <ProductCard />
           <ProductCard />
           <ProductCard />
           <ProductCard />
           </div>
       </div>
    );

}

export default ProductList;