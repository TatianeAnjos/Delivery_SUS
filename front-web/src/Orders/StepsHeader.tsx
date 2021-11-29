
import "./styles.css";
import ProductList from "./ProductList";
import Footer from "../Footer";
import { useEffect, useState } from 'react';
import { Product } from './types';
import { fetchProducts, fetchProductsByName } from '../api';
import React from 'react';
import ProductCardPorNome from "./ProductCardPorNome";
import ProductCard from "./ProductCard";


function StepsHeader() {
  const [nameProduct, setNameProducts] = useState('');
  const [productsName, setProductsName] = useState<Product[]>([]);
  const [outros, setOutros] = useState('');

  function setName(e: string) {
    setNameProducts(e);

  }
  function buscarPorNome(name: string) {

    fetchProductsByName(name)
      .then(response => setProductsName(response.data))
      .catch(error => console.log(error))
      
      setOutros('OUTROS PRODUTOS QUE TALVEZ VOCÊ SE INTERESSE');
  }

  return (


    <header className="orders-steps-container">
      <div className="order-steps-content">
        <h1 className="steps-title">Selecione o remedio desejado</h1>
        <ul className="steps-items">
          <li>
            <span className="steps-number">1</span>
            Selecione os produtos desejados.
          </li>
          <li>
            <span className="steps-number">2</span>
            Depois clique em <strong>"ENVIAR PEDIDO"</strong>.
          </li>
        </ul>
        <div className="buscar">
          <label>Buscar:</label>
          <input onChange={(e) => setName(e.target.value)} type="text" id="buscar-input"></input>
          <button
            type="submit"
            id="btn-buscar"
            onClick={() => buscarPorNome(nameProduct)}
          >
            Buscar
          </button>
        </div>
        <div className="orders-container">

          <div className="orders-list-container">
            <div className="orders-list-items">
              {productsName.map(product => (
                <ProductCard key={product.id} product={product} />
              ))}
            </div>
          </div>
        </div>
        <div className="outros">
          {outros}
        </div>

      </div>
    </header>
  );
}

export default StepsHeader;
