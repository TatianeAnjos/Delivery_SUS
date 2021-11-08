import Footer from "../Footer";
import "./styles.css";
import { ReactComponent }  from './logo.svg';
import { Link } from "react-router-dom";

function Home() {
  return (
    <>
      <div className="home-container">
        <div className="home-content">
          <div className="home-actions">
            <h1 className="home-title">
              Agora o Sus <br />
              leva o remedio <br />
              até você!!!
            </h1>
            <Link to="/orders"className="home-btn-order">
              Entrar <br />
            </Link>
            <Link to="/teste"className="home-btn-delivery">
              Entregador entre aqui <br />
            </Link>
            <Link to="/cadastrocliente"className="home-btn-cadastro">
              Realizar Cadastro <br />
            </Link>
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
