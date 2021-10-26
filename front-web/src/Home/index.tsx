import Footer from "../Footer";
import "./styles.css";
import { ReactComponent }  from './logo.svg';

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
            <a className="home-btn-order">
              Entrar <br />
            </a>
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
