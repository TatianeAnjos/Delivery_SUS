
export type Product = {
    id: number;
    name: string;
    description: string;
    imgUrl: string;
}

export type Categories = {
    id: number;
    name: string;
}

type ProductId = {
    id: number;
}

export type ClientePedido = {
    idCliente: number;
}

export type OrderPayload = {
    products : ProductId[];
} & ClientePedido;

export type User = {
     name: string;
	 email: string;
	 phone: string;
	 password: string;
	 logradouro: string;
	 numero: string;
	 cidade: string;
	 bairro: string;
	 estado: string
};

export type item = {
    nomeItem: string;
    quantidade:number;
}

export type order = {
    idPedido: number;
    status : string;
    nomeCliente: string;
    telefoneCliente: string;
    logradouro : string;
    numero : string;
    bairro : string;
    cidade :string;           
}

