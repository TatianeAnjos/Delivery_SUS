import Footer from "../Footer";
import "./styles.css";
import "./JavaScript.js";
import { ReactComponent } from "./logo.svg";
import { Link } from "react-router-dom";

function Home() {
  return (
    <>
      <div className="home-container">
        <div className="home-content">
          <div className="home-actions">
            <h1 className="title">
              O remedio do Sus <br />
              chega até você!!!
            </h1>
            <form className="form-Login" id="form-login">
              <div className="form-group col-md-6">
                <label htmlFor="Email">E-mail</label>
                <input
                  type="text"
                  className="form-control"
                  id="Email"
                  placeholder="Email"
                  name="email"
                />
              </div>
              <div className="form-group col-md-6">
                <label htmlFor="senha">Senha</label>
                <input
                  type="text"
                  className="form-control"
                  id="Senha"
                  placeholder="Senha"
                />
              </div>
              <Link to="/orders" className="home-btn-order" id="btn-enviar">
                Entrar <br />
              </Link>

              <Link to="/cadastroEntregador" className="home-btn-delivery">
                Entrar como Entregador <br />
              </Link>
              <Link to="/cadastroCliente" className="home-btn-cadastro">
                Realizar Cadastro <br />
              </Link>
            </form>
          </div>
          <div className="home-image">
            <ReactComponent />
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
}

export default Home;
