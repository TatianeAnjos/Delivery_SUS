import "./style.css";
<link
  rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
  integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
  crossOrigin="anonymous"
/>;

function CadastroEntregador() {
  return (
    <>
      <head>
        <link
          rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossOrigin="anonymous"
        />
      </head>
      <h1>Entregas Pendentes</h1>

      <table className="table table-sm">
        <thead>
          <tr>
            <th scope="col">Ordem</th>
            <th scope="col">Numero do Pedido</th>
            <th scope="col">Nome</th>
            <th scope="col">Valor</th>
            <th scope="col">Status</th>
            <th scope="col">Selecionar Pedido</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>124578</td>
            <td>Carlos</td>
            <td>R$ 10,25</td>
            <td>Em andamento </td>
            <button type="submit" className="btn btn-primary" id="pedido">
              Selecionar Pedido
            </button>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td>235689</td>
            <td>Maria</td>
            <td>R$ 15,00</td>
            <td>Pedente</td>
            <button type="submit" className="btn btn-primary" id="pedido">
              Selecionar Pedido
            </button>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>748596</td>
            <td>José</td>
            <td>R$ 25,30</td>
            <td>Pendente</td>
            <button type="submit" className="btn btn-primary" id="pedido">
              Selecionar Pedido
            </button>
          </tr>
        </tbody>
      </table>

      <form className="form-PedidosPendentes">
        <div className="form-row">
          <div className="form-group col-md-6">
            <label htmlFor="Pedido">Pedido</label>
            <input
              type="text"
              className="form-control"
              id="Pedido"
              placeholder="Pedido"
              value="124578"
              disabled
            />
          </div>
          <div className="form-group col-md-6">
            <label htmlFor="inputSobrenome">Endereço</label>
            <input
              type="text"
              className="form-control"
              id="inputSobrenome"
              placeholder="Endereço"
              value="Brigadeiro Faria Lima, 1744"
              disabled
            />
          </div>
          <div className="form-group col-md-6">
            <label htmlFor="inputNome">Valor</label>
            <input
              type="text"
              className="form-control"
              id="inputNome"
              placeholder="Valor"
              value="R$ 10,25"
              disabled
            />
          </div>
        </div>
        <button type="submit" className="btn btn-primary">
          Iniciar entrega
        </button>
        <button type="submit" className="btn-send">
          Finalizar Pedido
        </button>
      </form>

      <footer className="main-footer">Site desenvolvido para TCC UNIP.</footer>

      <body>
        <script
          src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
          integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
          crossOrigin="anonymous"
        ></script>
        <script
          src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
          integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
          crossOrigin="anonymous"
        ></script>
        <script
          src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
          integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
          crossOrigin="anonymous"
        ></script>
      </body>
    </>
  );
}

export default CadastroEntregador;
