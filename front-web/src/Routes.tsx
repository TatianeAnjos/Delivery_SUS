import { BrowserRouter, Switch, Route } from "react-router-dom";
import CadastroCliente from "./CadastroCliente";
import Home from "./Home";
import Navbar from "./Navbar";
import CadastroE from "./CadastroEntregador";
import Orders from "./Orders";

function Routes() {
  return (
    <BrowserRouter>
      <Navbar />
      <Switch>
        <Route path="/orders">
          <Orders />
        </Route>
        <Route path="/cadastrocliente">
          <CadastroCliente />
        </Route>
        <Route path="/cadastroentregador">
          <CadastroE />
        </Route>
        <Route path="/">
          <Home />
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

export default Routes;
