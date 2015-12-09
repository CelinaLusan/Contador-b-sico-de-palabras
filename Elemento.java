public class Elemento {
		private String palabra;
		private Integer valor;
		
		public Elemento(String p,Integer v){
			this.palabra=p;
			this.valor=v;
			return;
		}

		@Override
		public String toString() {
			return "Palabra " + palabra + ", N° de Veces Repetidas=" + valor ;
		}

		public String getPalabra() {
			return palabra;
		}

		public void setPalabra(String palabra) {
			this.palabra = palabra;
		}

		public Integer getValor() {
			return valor;
		}

		public void setValor(Integer valor) {
			this.valor = valor;
		}
		
}
