import React from 'react';
import { useEffect, useState } from 'react';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.min.css'; 

import "./style.css";
import { User } from '../Orders/types';

import axios from "axios";

<link
  rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
  integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
  crossOrigin="anonymous"
/>;

type Props = {
  users:User;
}

function Cadastro() {
  const url = "http://localhost:8080/users"

const [name, setName] = useState('');
function onChangeName(ev:string){
  setName(ev);
}
 const [email,setEmail] = useState('');
 function onChangeEmail(ev:string){
  setEmail(ev);
}
 const [phone,setPhone] = useState('');
 function onChangePhone(ev:string){
  setPhone(ev);
}
 const [password,setPassword] = useState('');
 function onChangePassword(ev:string){
  setPassword(ev);
}
 const [logradouro, setLogradouro] = useState('');
 function onChangeLogradouro(ev:string){
  setLogradouro(ev);
}
 const [numero, setNumero] = useState('');
 function onChangeNumero(ev:string){
  setNumero(ev);
}
 const [cidade, setCidade] = useState('');
 function onChangeCidade(ev:string){
  setCidade(ev);
}
 const [bairro, setBairro] = useState('');
 function onChangeBairro(ev:string){
  setBairro(ev);
}
 const [estado, setEstado] = useState('');
 function onChangeEstado(ev:string){
  setEstado(ev);
}


function submit(e:any){
  e.preventDefault();
  axios.post(url,{
    name,
    email,
    phone,
    password,
    logradouro,
    numero, 
    cidade, 
    bairro, 
    estado
  }).then(res=>{toast.success('Cadastro realizado com sucesso')})
  .catch(res=>{toast.error('Erro ao realizar o cadastro')})
  
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
      <h1>Novo Usuário</h1>
      <form onSubmit={(e) => submit(e)} className="form-CadCliente">
        <div className="form-row">
          <div className="form-group col-md-6">
            <label htmlFor="inputNome">Nome</label>
            <input
              type="text"
              className="form-control"
              placeholder="Nome"
              id="inputNome" 
              onChange={(e)=>onChangeName(e.target.value)}

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
            <label htmlFor="inputTelefone">Telefone</label>
            <input
              type="text"
              className="form-control"
              id="inputTelefone"
              placeholder="Telefone"
              onChange={(e)=>onChangePhone(e.target.value)}

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
              onChange={(e)=>onChangeLogradouro(e.target.value)}

            />
          </div>
          <div className="form-group col-md-2">
            <label htmlFor="numero">Numero</label>
            <input
              type="text"
              className="form-control"
              id="numero"
              placeholder="N°"
              onChange={(e)=>onChangeNumero(e.target.value)}

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
            <input type="text"  placeholder="Cidade" className="form-control" id="inputCity"  onChange={(e)=>onChangeCidade(e.target.value)}
 />
          </div>
          <div className="form-group col-md-4">
            <label htmlFor="inputEstado">Estado</label>
            <select id="inputEstado" className="form-control" onChange={(e)=>onChangeEstado(e.target.value)}>
              <option selected>Escolher...</option>
              <option>São Paulo</option>
              <option>Rio de Janeiro</option>
              <option>Paraná</option>
              <option>Mato Grosso do Sul</option>
              <option>Maranhão</option>
              <option>Bahia</option>
              <option>Amazonas</option>
            </select>
          </div>
          <div className="form-group col-md-2">
            <label htmlFor="inputBairro">Bairro</label>
            <input  type="text" 
                    className="form-control" 
                    id="inputBairro"  
                    onChange={(e)=>onChangeBairro(e.target.value)} 
            />
            
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
              onChange={(e)=>onChangeEmail(e.target.value)}


            />
          </div>
          <div className="form-group col-md-6">
            <label htmlFor="inputPassword4">Senha</label>
            <input
              type="password"
              className="form-control"
              id="inputPassword4"
              placeholder="Senha."
              onChange={(e)=>onChangePassword(e.target.value)}

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
        <button type="submit" className="btn btn-primary"
        >
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
