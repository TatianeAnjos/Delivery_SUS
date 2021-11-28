import "./style.css";
import { useEffect, useState } from 'react';
import { fetchOrders } from "../api";
import { Pedido } from "./types";
import React from 'react';
import CadastroEntregador from "./CadastroEntregador";

function CadastroEntrega() {
  const[order, setOrders] = useState<Pedido[]>([]);

  useEffect(() => {
    fetchOrders()
    .then(response => setOrders(response.data))
    .catch(error => console.log(error))
  }, []);

  return (
    <div className="cadastro-container">
      <CadastroEntregador/>
    </div>
  );
  /// componente entregador
}

export default CadastroEntrega;

