function StepsHeader() {
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
          <input type="text" id="buscar-input"></input>
          <button id="btn-buscar">Buscar</button>
        </div>
      </div>
    </header>
  );
}

export default StepsHeader;
