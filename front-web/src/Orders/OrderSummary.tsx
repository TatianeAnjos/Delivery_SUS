function OrderSummary() {
  return (
    <div className="order-summary-container">
      <div className="order-summary-content">
        <div>
          <span className="amount-selected-container">
            <strong className="amount-selected">2</strong>
            Itens Selecionados
          </span>
          <span className="order-summary-total">
            Valor do Frete
            <input type="text" placeholder="Valor R$" disabled />
          </span>
        </div>
        <button className="order-summary-make-order">Fazer Pedido</button>
      </div>
    </div>
  );
}

export default OrderSummary;
