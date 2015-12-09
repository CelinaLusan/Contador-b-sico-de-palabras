import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

	public class Main {
		/**
		 * @param args
		 */
		public static void extraer (String file){
			try {
				HashSet <String> stopwords = new HashSet <String>(); //Declaración de HashMap que contendra los auxiliares de lenguaje
				Scanner stop = new Scanner(new File("stop.txt"));
				stop.useDelimiter("\\\\|,|\\.|:|;|-|\\p{javaWhitespace}+");				
					while(stop.hasNext()){
						String palabra=stop.next();
						stopwords.add(palabra);
					}
					
				
				Scanner s=new Scanner(new File(file));
				s.useDelimiter("\\\\|,|\\.|:|;|-|\\p{javaWhitespace}+");
					int valor,cont=0;
					int total=0;
					int valordos;
				HashMap <String,Integer> diccionario = new HashMap<String,Integer>();
				HashMap <String,Integer> todasLasPalabras = new HashMap<String,Integer>();
					while(s.hasNext()){
						String palabra=s.next().trim().toLowerCase();
						if(!palabra.equals("")){
							total++; //cuenta palabras y auxiliares de lenguaje
							//agrega todas las palabras al hashmap para despues mostrarlas en el reporte
							if(!todasLasPalabras.containsKey(palabra)){
								todasLasPalabras.put(palabra,1);
							}else{
								valordos=todasLasPalabras.get(palabra);
								todasLasPalabras.put(palabra,valordos+1);
							}
							if(!stopwords.contains(palabra)){
								cont++; //cuenta solo palabras
								//agrega al hashmap solo palabras no auxiliares
								if(!diccionario.containsKey(palabra)){
									diccionario.put(palabra,1);
								}else{
									valor=diccionario.get(palabra);
									diccionario.put(palabra, valor+1);
								}
							}
						}
					}
				stop.close();
				s.close();
				System.out.println("Total de palabras sin auxiliares: "+cont);
				System.out.println("Total de palabras con auxiliares: "+total);
				ordenar(diccionario,todasLasPalabras,cont,total);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			return;
		}
		
		public static void ordenar(HashMap<String,Integer> palabras,HashMap<String,Integer> todasLasPalabras,int cont,int total){
			List<Elemento> ordenacion= new ArrayList<Elemento>();
			List<Elemento> ord = new ArrayList<Elemento>();
			HashMap <String,Integer> diccio =palabras;
			
			List<Elemento> ordenaTodo= new ArrayList<Elemento>();
			List<Elemento> ordTodo = new ArrayList<Elemento>();
			HashMap <String,Integer> diccioTodo =todasLasPalabras;
			
			//ordenacion de palabras sin auxiliares
			for(String x:diccio.keySet()){
				Integer c= diccio.get(x); 
				Elemento e=new Elemento(x,c);
				ordenacion.add(e);
			}
			 
			ord.add(ordenacion.get(0));
				for(int i = 1; i <ordenacion.size(); i++){
					int tem = ordenacion.get(i).getValor();
					int j=i-1;
					while (j>=0 && tem<ord.get(j).getValor()) {
						j--;
					}
					String t = ordenacion.get(i).getPalabra();
		        	Integer tt=ordenacion.get(i).getValor();
		        	Elemento z=new Elemento(t,tt);
		        	ord.add(j+1,z);
					
				}
				System.out.println("Las 10 palabras mas repetidas son: ");
				int contador=9;
				int i=ord.size()-1;
				while(contador>=0 && i>=0){
					System.out.println(ord.get(i));
					i--;
					contador--;
				}
				//Ordenación de todas las pablabras por el método sort
				for(String x:diccioTodo.keySet()){
					Integer c= diccioTodo.get(x); 
					Elemento e=new Elemento(x,c);
					ordenaTodo.add(e);
				}
				
				ordTodo.add(ordenaTodo.get(0));
				for(int ii = 1; ii <ordenaTodo.size(); ii++){
					int tem = ordenaTodo.get(ii).getValor();
					int j=ii-1;
					while (j>=0 && tem<ordTodo.get(j).getValor()) {
						j--;
					}
					String t = ordenaTodo.get(ii).getPalabra();
		        	Integer tt=ordenaTodo.get(ii).getValor();
		        	Elemento z=new Elemento(t,tt);
		        	ordTodo.add(j+1,z);
					
				}
				
				save(ord,ordTodo,cont,total);//solo guarda las palabras sin auxiliares
		}

		
		public static void save(List<Elemento> l,List<Elemento> l2,int cont,int total){
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter("mitexto_reporte.txt"));
				bw.write("Total de palabras sin auxiliares "+cont);
				bw.newLine();
				bw.write("Total de palabras con auxiliares "+total);
				bw.newLine();
				bw.newLine();
				bw.write("Las 10 palabras más comunes sin auxiliares son: ");
				bw.newLine();
				bw.newLine();
				int contador=9;
				int i=l.size()-1;;
					while(contador>=0 && i>=0){
						bw.write(l.get(i)+"");
						bw.newLine();
						i--;
						contador--;
					}
				bw.newLine();
				bw.write("Conteo de todas las palabras: ");
				bw.newLine();
				bw.newLine();
				int ii=l2.size()-1;;
					while(ii>=0){
						bw.write(l2.get(ii)+"");
						bw.newLine();
						ii--;
					}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("No se pudo crear");
			}finally {
				if(bw != null)
					try {
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			extraer(args[0]);
		}

}
