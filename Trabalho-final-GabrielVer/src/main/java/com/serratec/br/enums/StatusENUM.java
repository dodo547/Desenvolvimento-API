package com.serratec.br.enums;

public enum StatusENUM {
	//Padrão de status de vendas baseado na loja Tray Ecommerce:
	//https://ajuda.troquecommerce.com.br/pt/article/definindo-as-situacoesstatus-dos-pedidos-permitidos-ex97c1/
	AGUARDANDOPGTO(1,"Aguardando Pagamento"),
	AENVIAR(2,"A enviar"),
	ENVIADO(3, "Produto Enviado"),
	FINALIZADO(4,"Entrega Concluída"),
	CANCELADO(5, "Pedido Cancelado");
	
	private Integer codigo;
	private String mensagem;
	
	private StatusENUM(Integer codigo, String mensagem) {
		this.mensagem = mensagem;
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
}
