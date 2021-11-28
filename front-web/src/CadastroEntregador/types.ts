export type Item = {
    nomeItem: string;
    quantidade:number;
}

export type Pedido = {
    idPedido: number;
    status : string;
    nomeCliente: string;
    telefoneCliente: string;
    logradouro : string;
    numero : string;
    bairro : string;
    cidade :string;           
} & Item;

