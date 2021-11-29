import "./styles.css";
import StepsHeader from "./StepsHeader";
import ProductList from "./ProductList";
import Footer from "../Footer";
<<<<<<< HEAD
import OrderSummary from "./OrderSummary";
=======
import { useEffect, useState } from 'react';
import {Product} from './types';
import {fetchProducts} from '../api';
import React from 'react';
>>>>>>> e63d1de03d76e6fba3dda6a9ecc53acdd64a28db

function Orders() {
  const[products, setProducts] = useState<Product[]>([]);
  useEffect(() => {
    fetchProducts()
    .then(response => setProducts(response.data))
    .catch(error => console.log(error))
  }, []);
  return (
    <div className="orders-container">
      <StepsHeader />
<<<<<<< HEAD
      <ProductList />
      <OrderSummary />
=======
      <ProductList products = {products}/>
>>>>>>> e63d1de03d76e6fba3dda6a9ecc53acdd64a28db
      <Footer />
    </div>
  );
}

export default Orders;
