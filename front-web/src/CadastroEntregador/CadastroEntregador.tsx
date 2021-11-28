import Footer from "../Footer";
import "./style.css";
import { Pedido } from "./types";
import { useEffect, useState } from 'react';
import { fetchOrders } from "../api";
import axios from "axios";
import { toast } from "react-toastify";

<link
  rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
  integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
  crossOrigin="anonymous"
/>;


function CadastroEntregador() {

const[selecionado, setSelecionado] = useState<Pedido>();
const[order, setOrders] = useState<Pedido[]>([]);
useEffect(() => {
  fetchOrders()
  .then(response => setOrders(response.data))
  .catch(error => console.log(error))
}, []);
function setSel(e:any){
  setSelecionado(e);
  console.log(selecionado);
}

const [status, setStatus] = useState('');
const altera_status = "http://localhost:8080/orders/atualizar-status?status=4&id="+`${selecionado?.idPedido}`;

function onChangeStatus(ev:any){
 setStatus(ev);
}


function submit(e:any){
  e.preventDefault();
  axios.post(altera_status)
  .then(res=>{toast.success('Entrega Finalizada com Sucesso')})
  .catch(res=>{toast.error('Erro ao Finalizar Entrega')})
  
}
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
      <table>
        <thead>
          <tr>
            <th scope="col">Ordem</th>
            <th scope="col">Numero do Pedido</th>
            <th scope="col">Nome</th>
            <th scope="col">Valor</th>
            <th scope="col">Status</th>
          </tr>
        </thead>
        </table>

      <table className="table table-sm">
        
        <tbody>
          <tr>
            {order.map(order => (
<>
<tr>
            <th scope="row">{order.idPedido}</th>
            <td>{order.idPedido}</td>
            <td>{order.nomeCliente}</td>
            <td>{order.quantidade}</td>
            <td>{order.status}</td>
            <td>{order.nomeItem}</td>

            <button type="submit" className="btn btn-primary"
            onClick={() => setSel(order)}

            >
            
              Selecionar Pedido
            </button>
          </tr>
</>            ))}
            
          </tr>
        </tbody>
      </table>

      <form onSubmit={(e)=>{submit(e)}} className="form-CadCliente">
        <div className="form-row">

          <div className="form-group col-md-6">
            <label htmlFor="Pedido">Pedido</label>
            <input
              type="text"
              className="form-control"
              id="Pedido"
              placeholder="Pedido"
              value={selecionado?.idPedido}
              disabled
            />
          </div>
          <div className="form-group col-md-6">
            <label htmlFor="inputNome">Nome Cliente</label>
            <input
              type="text"
              className="form-control"
              id="inputNome"
              placeholder="Nome Cliente"
              value={selecionado?.nomeCliente}
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
              value={`${selecionado?.logradouro}`+ ` - ${selecionado?.numero}`}
              disabled
            />
          </div>
          <div className="form-group col-md-6">
            <label htmlFor="inputSobrenome">Bairro</label>
            <input
              type="text"
              className="form-control"
              id="inputSobrenome"
              placeholder="Endereço"
              value={`${selecionado?.bairro}` +` - ${selecionado?.cidade}`}
              disabled
            />
          </div>
          
          <div className="form-group col-md-6">
            <label htmlFor="inputNome">Telefone</label>
            <input
              type="text"
              className="form-control"
              id="inputNome"
              placeholder="Telefone"
              value={selecionado?.telefoneCliente}
              disabled
            />
          </div>
          
        </div>

        <button type="submit" className="btn btn-primary">
          Iniciar entrega
        </button>
        <button onSubmit={(e)=>{onChangeStatus(e)}} type="submit" className="btn btn-primary">
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