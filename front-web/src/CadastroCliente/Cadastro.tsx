import "./style.css";
<link
  rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
  integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
  crossOrigin="anonymous"
/>;

function Cadastro() {
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
      <h1>Novo Usuário</h1>
      <form className="form-CadCliente">
        <div className="form-row">
          <div className="form-group col-md-6">
            <label htmlFor="inputNome">Nome</label>
            <input
              type="text"
              className="form-control"
              id="inputNome"
              placeholder="Nome"
            />
          </div>
          <div className="form-group col-md-4">
            <label htmlFor="inputSobrenome">Sobrenome</label>
            <input
              type="text"
              className="form-control"
              id="inputSobrenome"
              placeholder="Sobrenome"
            />
          </div>
          <div className="form-group col-md-2">
            <label htmlFor="inputNome">CPF</label>
            <input
              type="text"
              className="form-control"
              id="inputNome"
              placeholder="CPF"
            />
          </div>
        </div>

        <div className="form-row">
          <div className="form-group col-md-6">
            <label htmlFor="endereco">Endereço</label>
            <input
              type="text"
              className="form-control"
              id="endereco"
              placeholder="Rua, Avenida, Travessa..."
            />
          </div>
          <div className="form-group col-md-2">
            <label htmlFor="numero">Numero</label>
            <input
              type="text"
              className="form-control"
              id="numero"
              placeholder="N°"
            />
          </div>
          <div className="form-group col-md-">
            <label htmlFor="complemento">Complemento</label>
            <input
              type="text"
              className="form-control"
              id="complemento"
              placeholder="Complemento"
            />
          </div>
        </div>

        <div className="form-row">
          <div className="form-group col-md-6">
            <label htmlFor="inputCity">Cidade</label>
            <input type="text" className="form-control" id="inputCity" />
          </div>
          <div className="form-group col-md-4">
            <label htmlFor="inputEstado">Estado</label>
            <select id="inputEstado" className="form-control">
              <option selected>Escolher...</option>
              <option>...</option>
            </select>
          </div>
          <div className="form-group col-md-2">
            <label htmlFor="inputCEP">CEP</label>
            <input type="text" className="form-control" id="inputCEP" />
          </div>
        </div>
        <div className="form-row">
          <div className="form-group col-md-6">
            <label htmlFor="inputEmail4">Email</label>
            <input
              type="email"
              className="form-control"
              id="inputEmail4"
              placeholder="Email"
            />
          </div>
          <div className="form-group col-md-6">
            <label htmlFor="inputPassword4">Senha</label>
            <input
              type="password"
              className="form-control"
              id="inputPassword4"
              placeholder="Senha"
            />
          </div>
        </div>

        <div className="form-group">
          <div className="form-check">
            {/* <input
              className="form-check-input"
              type="checkbox"
              id="gridCheck"
            /> */}
            {/* <label className="form-check-label" htmlFor="gridCheck">
              Clique em mim
            </label> */}
          </div>
        </div>
        <button type="submit" className="btn btn-primary">
          Cadastrar
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

export default Cadastro;
